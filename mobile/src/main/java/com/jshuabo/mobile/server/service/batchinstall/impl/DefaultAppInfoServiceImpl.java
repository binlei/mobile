package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInfoMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageInfoDetailMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageInfoMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageTypeMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;
import com.jshuabo.mobile.server.service.batchinstall.IAppInfoService;

@Service("appInfoService")
public class DefaultAppInfoServiceImpl implements IAppInfoService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAppInfoServiceImpl.class);

    @Value("${imageFilePath}")
    public static String imageFilePath; // 图片文件路径

    @Value("${packageInfoPath}")
    public static String packageInfoPath; // ftp 使用的信息文件

    @Autowired
    private IAppInfoMapper appInfoMapper;

    @Autowired
    private IAppPackageTypeMapper appPackageTypeMapper;

    @Autowired
    private IAppPackageInfoMapper appPackageInfoMapper;

    @Autowired
    private IAppPackageInfoDetailMapper appPackageInfoDetailMapper;

    @Override
    public String page(Map<String, Object> params) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Long orgId = user.getOrganization().getId();

        params.put("imageFilePath", imageFilePath);
        params.put("orgId", orgId);
        List<AppInfo> appInfoList = appInfoMapper.page(params);
        Long total = appInfoMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", appInfoList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public void save(AppInfo appInfo) {
        appInfo.setStatus(BaseStatus.DISABLED); // 默认未通过 / 失效
        appInfoMapper.save(appInfo);
    }

    @Override
    public AppInfo load(Long appId) {
        return appInfoMapper.load(appId);
    }

    @Override
    public void update(AppInfo appInfo) {
        appInfoMapper.update(appInfo);
        //     根据apkid 查询属于哪些包，更新包大小
        List<AppPackageInfo> appPackageList = appPackageInfoDetailMapper.queryPackageByApkId(appInfo.getId());        
        for (int i = 0; i < appPackageList.size(); i++) {
            appPackageInfoMapper.updateQty(appPackageList.get(i));
        }
    }

    @Override
    public List<AppInfo> loadAll() {
        return appInfoMapper.loadAll();
    }

    /*
     * (non Javadoc)
     * 
     * @Title: audited
     * 
     * @Description: 通过审核
     * 
     * @see com.jshuabo.mobile.server.service.batchinstall.IAppInfoService#audited()
     */
    @Override
    public void audited(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            appInfoMapper.auditedPass(new Long(id[i]));
        }
    }

    @Override
    public Integer queryAppByTypeId(Long appTypeId) {
        return appInfoMapper.queryAppByTypeId(appTypeId);
    }

    @Override
    public int searchAppByName(String appName) {
        return appInfoMapper.searchAppByName(appName);
    }

    @Override
    public Integer delete(AppInfo appInfo) {
        return appInfoMapper.delete(appInfo);
    }

    @Override
    public List<AppInfo> queryAppNamesByOrgId(Long orgId) {
        String imagePath = DefaultAppInfoServiceImpl.imageFilePath;
        return appInfoMapper.queryAppNamesByOrgId(orgId, imagePath);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jshuabo.mobile.server.service.batchinstall.IAppInfoService#createPackageInfoFile(java
     * .lang.Long)
     */
    @Override
    public String createPackageInfoFile(Long orgId) {
        try {
            List<Map<String, Object>> packageTypeMap = null;
            List<Map<String, Object>> packageInfoMap = null;
            List<Map<String, Object>> appInfoMap = null;
            Map<String, Object> map = new HashMap<String, Object>();
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            // 查询包类型
            packageTypeMap = appPackageTypeMapper.getAppPkgTypeByUserOrgId(orgId);

            for (int i = 0; i < packageTypeMap.size(); i++) {
                Long pkgTypeId = (Long) packageTypeMap.get(i).get("id");
                packageInfoMap = appPackageInfoMapper.queryAppPgkInfoByPgkTypeId(pkgTypeId, orgId);

                for (int j = 0; j < packageInfoMap.size(); j++) {
                    // 添加到应用类型中
                    Long pkgInfoId = (Long) packageInfoMap.get(j).get("id");
                    appInfoMap = appPackageInfoDetailMapper.queryAppInfoByPgkId(pkgInfoId);
                    for (int j2 = 0; j2 < appInfoMap.size(); j2++) {
                        // 添加到 应用中
                        packageInfoMap.get(j).put("appList", appInfoMap);
                    }
                    packageTypeMap.get(i).put("packageList", packageInfoMap);
                }
            }
            map.put("packageTypeList", packageTypeMap);
            map.put("msg", " ");
            map.put("status", "success");
            map.put("userId", user.getId());
            map.put("userName", user.getName());
            map.put("organizationId", user.getOrganization().getId());
            map.put("organization", user.getOrganization().getName());

            String packageInfoJSONString = JacksonUtils.object2json(map);
            File packageInfoFile = new File(packageInfoPath + "MAC");
            FileOutputStream fos = null;
            if (!packageInfoFile.exists()) {
                packageInfoFile.createNewFile();
            }
            fos = new FileOutputStream(packageInfoFile);
            fos.write(packageInfoJSONString.getBytes());
            if (fos != null) {
                fos.close();
            }

        } catch (IOException e) {
            logger.error("创建 packageInfoFile IOException 异常：[{}]", e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }


    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        DefaultAppInfoServiceImpl.imageFilePath = imageFilePath;
    }

    public String getPackageInfoPath() {
        return packageInfoPath;
    }

    public void setPackageInfoPath(String packageInfoPath) {
        DefaultAppInfoServiceImpl.packageInfoPath = packageInfoPath;
    }
}
