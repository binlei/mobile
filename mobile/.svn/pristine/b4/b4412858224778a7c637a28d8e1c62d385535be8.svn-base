package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.model.base.EntityFactory;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInfoMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageInfoDetailMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageInfoMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfoDetail;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoService;

@Service("appPackageInfoService")
public class DefaultAppPackageInfoServiceImpl implements IAppPackageInfoService {

    @Autowired
    private IAppPackageInfoMapper appPackageInfoMapper;

    @Autowired
    private IAppPackageInfoDetailMapper appPackageInfoDetailMapper;

    @Autowired
    private IAppInfoMapper appInfoMapper;

    @Override
    public String page(Map<String, Object> params) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Long orgId = user.getOrganization().getId();

        params.put("orgId", orgId);
        List<AppPackageInfo> appPackageInfoList = appPackageInfoMapper.page(params);
        Long total = appPackageInfoMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", appPackageInfoList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public void save(AppPackageInfo appPackageInfo) {
        appPackageInfo.setStatus(BaseStatus.ENABLED);
        appPackageInfoMapper.save(appPackageInfo);
    }

    @Override
    public void addDetail(Long packageInfoId, Long appInfoId) {
        AppPackageInfo packageInfo = appPackageInfoMapper.load(packageInfoId);
        AppInfo appInfo = appInfoMapper.load(appInfoId);

        // EntityFactory bean 工厂
        AppPackageInfoDetail detail = EntityFactory.getEntity(AppPackageInfoDetail.class);
        detail.setAppInfo(appInfo);
        detail.setAppPackageInfo(packageInfo);

        // 根据 应用包ID 得到 该应用包下面的APK 明细
        Set<AppPackageInfoDetail> details = appPackageInfoDetailMapper.queryDetail(packageInfoId);

        packageInfo.setDetails(details);
        packageInfo.addDetail(detail); //

        appPackageInfoDetailMapper.save(detail);

        // 更新安装包信息 数量/总文件大小
        appPackageInfoMapper.updateQty(packageInfo);
    }

    @Override
    public String deleteDetailByPkgIdAndApkId(long apkPkgId, long apkId){
        AppPackageInfoDetail detail = appPackageInfoDetailMapper.loadByPkgIdAndApkId(apkPkgId,apkId);
        AppPackageInfo packageInfo = detail.getAppPackageInfo();

        // 根据 应用包ID 得到 该应用包下面的APK 明细
        Set<AppPackageInfoDetail> details = appPackageInfoDetailMapper.queryDetail(packageInfo.getId());
        for (AppPackageInfoDetail appPackageInfoDetail : details) {
            if (detail.getId().equals(appPackageInfoDetail.getId())) {
                details.remove(appPackageInfoDetail);
                break;
            }
        }
        packageInfo.setDetails(details);
        packageInfo.removeDetail(detail);

        int result = appPackageInfoDetailMapper.delete(detail);
        // 更新安装包信息
        appPackageInfoMapper.updateQty(packageInfo);
        if (result != 0) {
            return ResultConstant.SUCCESSED;
        }
        return ResultConstant.DEFEATED;

    }

    @Override
    public AppPackageInfo load(Long appPkgInfoId) {
        return appPackageInfoMapper.load(appPkgInfoId);
    }

    public void update(AppPackageInfo appPackageInfo) {
        // appPackageInfoMapper.updateAppByPackageId();
        appPackageInfoMapper.update(appPackageInfo);
    }

    @Override
    public Map<String, Object> queryByPackageId(Map<String, Object> map) {
        map.put("imageFilePath", DefaultAppInfoServiceImpl.imageFilePath);
        List<String> list = appPackageInfoDetailMapper.queryByPackageId(map);
        int total = appPackageInfoDetailMapper.totalAppInfoByPkgId((Long) map.get("appPkgInfoId"));
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("total", total);
        m.put("rows", list);
        return m;
    }

    @Override
    public Integer queryAppPackageNameByName(String appPackageName) {
        return appPackageInfoMapper.queryAppPackageNameByName(appPackageName);
    }

    @Override
    public String deleteByPackageId(long appPkgInfoId) {
        Integer result = null;
        result = appPackageInfoDetailMapper.totalAppInfoByPkgId(appPkgInfoId);
        if (result != ResultConstant.RESULTED) {
            return ResultConstant.NOT_EMPTY;
        } else {
            result = appPackageInfoMapper.deleteById(appPkgInfoId);
            if (result != null) {
                return ResultConstant.SUCCESSED;
            }
        }
        return ResultConstant.DEFEATED;
    }

}
