package com.jshuabo.mobile.server.web.controller.batchinstall;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.service.organization.IOrganizationService;
import com.jshuabo.frame.server.util.io.FileUtil;
import com.jshuabo.frame.server.util.io.MD5Utils;
import com.jshuabo.frame.server.util.math.DoubleUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.batchinstall.utils.apk.ApkInfo;
import com.jshuabo.mobile.server.batchinstall.utils.apk.ApkUtil;
import com.jshuabo.mobile.server.batchinstall.utils.apk.IconUtil;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;
import com.jshuabo.mobile.server.service.batchinstall.IAppInfoService;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoDetailService;


@Controller
@RequestMapping("/appInfo")
public class AppInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AppInfoController.class);

	@Value("${fileStoragePath}")
	public static String fileStoragePath;	// 下载文件来源-本应用文件,参数传递路径是相对于应用的url地址,类似"/download/1.jpg"
    
	@Value("${aaptPath}")
	public static String aaptPath;
	
	private String fileLoaction = "/apks/";

    @Autowired
    private IAppInfoService appInfoService;
    @Autowired
    private IOrganizationService orgServer;
    @Autowired
    private IAppPackageInfoDetailService appPackageInfoDetailService;

    /**
     * @Title: appInfoList
     * @Description: 查询应用列表
     * @return
     * @return: String
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView appInfoList() {
        ModelAndView mav = new ModelAndView("appInfo/list");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String orgCode = user.getOrganization().getCode();
        mav.addObject("orgCode", orgCode);
        return mav;
    }
    
    @RequestMapping(value = "/listView", method = RequestMethod.GET)
    public ModelAndView appInfoListView() {
        ModelAndView mav = new ModelAndView("appInfo/listView");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String orgCode = user.getOrganization().getCode();
        mav.addObject("orgCode", orgCode);
        return mav;
    }
    

    /**
     * @Title: requestAddAppInfoPage
     * @Description: 转向add页面
     * @param appInfo
     * @return
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String requestAddAppInfoPage(AppInfo appInfo) {
        return "appInfo/add";
    }

    /**
     * @Title: addAppInfo
     * @Description: 上传
     * @param file
     * @param appInfo
     * @param request
     * @throws IOException
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileApk(@RequestParam("file") CommonsMultipartFile file, AppInfo appInfo,
            HttpServletRequest request) {
        try {
            logger.info("file upload start !!!");
            Long orgId = appInfo.getOrganization().getId(); 
            // 获取文件名称
            String fileName = file.getOriginalFilename();
            // String fileExtension = FilenameUtils.getExtension(fileName);
            String fileBaseName = FilenameUtils.getBaseName(fileName);
            String STORE_PATH = fileStoragePath + fileLoaction;
            String LOCA_LOCATION = STORE_PATH + orgId; // 图片ico路径
            String RELATIVE_LOCATION = fileLoaction + orgId;
            String APK_LOCATION = STORE_PATH + orgId + "/" + fileName; // APK 路径
     
            File apkFile = new File(LOCA_LOCATION, fileName);

            // 保存本地
            if (!apkFile.exists()) {
                apkFile.mkdirs();
            }
            file.transferTo(apkFile);
            
            ApkInfo apkInfo = new ApkUtil(aaptPath).getApkInfo(APK_LOCATION);
            logger.info("apkInfo is [{}] !!!", apkInfo);
            
            String icoPath = LOCA_LOCATION + "/" + fileBaseName + ".png";
            IconUtil.extractFileFromApk(APK_LOCATION, apkInfo.getApplicationIcon(), icoPath);
            // 得到文件MD5
            appInfo.setMd5(MD5Utils.fileMD5(apkFile));
            appInfo.setFilePath(RELATIVE_LOCATION + "/" + fileName);
            appInfo.setFileSize(DoubleUtils.keepTwoNumber(((double) FileUtil.getFileSize(apkFile) / 1024) / 1024));
            appInfo.setAppVersion(apkInfo.getVersionName());
            appInfo.setFileName(fileName);
            appInfo.setFilePackageName(apkInfo.getPackageName());
            // 得到 应用图片
            appInfo.setIcoPath(RELATIVE_LOCATION + "/" + fileBaseName + ".png");

            appInfoService.save(appInfo);
            logger.info("apk file upload end");
        } catch (Exception e) {
            logger.error("catch Exception:[{}]", e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return "success";
    }

    /**
     * @Title: downloadFile
     * @Description: 下载文件
     * @param fileName
     * @param response
     * @return: String
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response, HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileName = request.getParameter("fileName");
        String filePath = request.getParameter("filePath");

        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            InputStream inputStream = new FileInputStream(fileStoragePath + filePath);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            logger.error("catch FileNotFoundException:[{}]", e.getLocalizedMessage());
        } catch (IOException e) {
            logger.error("catch IOException:[{}]", e.getLocalizedMessage());
        }
    }

    /**
     * @Title: requestEditAppInfoPage
     * @Description: 转向编辑页面
     * @param appId
     * @param model
     * @return: String
     */
    @RequestMapping(value = "/edit/{appId}", method = RequestMethod.GET)
    public String requestEditAppInfoPage(@PathVariable long appId, Model model) {
        model.addAttribute("appInfo", appInfoService.load(appId));
        return "appInfo/edit";
    }

    /**
     * @Title: editAppInfo
     * @Description: 编辑
     * @param appId
     * @param appInfo
     * @return: String
     */
    @RequestMapping(value = "/edit/{appId}", method = RequestMethod.POST)
    @ResponseBody
    public String editAppInfo(@RequestParam("file") CommonsMultipartFile file, AppInfo appInfo,
            HttpServletRequest request) {
        try {
            if (file.getSize() != 0) {
                Long orgId = appInfo.getOrganization().getId();

                // 获取文件名称
                String fileName = file.getOriginalFilename();
                String fileBaseName = FilenameUtils.getBaseName(fileName);
                /*
                 * String fileExtension = FilenameUtils.getExtension(fileName); String fileBaseName
                 * = FilenameUtils.getBaseName(fileName); String newFileName = fileBaseName + "." +
                 * fileExtension;
                 */
                String STORE_PATH = fileStoragePath + fileLoaction;
                String LOCA_LOCATION = STORE_PATH + orgId; // 图片ico路径
                String RELATIVE_LOCATION = fileLoaction + orgId;
                String APK_LOCATION = STORE_PATH + orgId + "/" + fileName; // APK 路径

                File apkFile = new File(LOCA_LOCATION, fileName);

                // 保存本地
                if (!apkFile.exists()) {
                    apkFile.mkdirs();
                }
                file.transferTo(apkFile);

                ApkInfo apkInfo = new ApkUtil(aaptPath).getApkInfo(APK_LOCATION);
                String icoPath = LOCA_LOCATION + "/" + fileBaseName + ".png";
                IconUtil.extractFileFromApk(APK_LOCATION, apkInfo.getApplicationIcon(), icoPath);
                /*
                 * ApkInfo apkInfo = new ApkUtil(aaptPath).getApkInfo(APK_LOCATION); String filePath
                 * = FILE_LOCATION + orgId + "/";
                 */
                // 得到文件MD5
                appInfo.setMd5(MD5Utils.fileMD5(apkFile));
                appInfo.setFilePath(RELATIVE_LOCATION + "/" + fileName);
                appInfo.setFileSize(DoubleUtils.keepTwoNumber(((double) FileUtil
                        .getFileSize(apkFile) / 1024) / 1024));
                appInfo.setAppVersion(apkInfo.getVersionName());
                appInfo.setFileName(fileName);
                appInfo.setFilePackageName(apkInfo.getPackageName());
                // 得到 应用图片
                appInfo.setIcoPath(RELATIVE_LOCATION + "/" + fileBaseName + ".png");
                appInfo.setFilePackageName(apkInfo.getPackageName());
            }
            appInfoService.update(appInfo);
        } catch (Exception e) {
            logger.error("catch Exception edit editAppInfo  :[{}]",e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    /**
     * @Title: deleteAppInfo
     * @Description: 删除
     * @param appInfoId
     * @param appInfo
     * @return: String
     */
    @RequestMapping(value = "/{appInfoId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAppInfo(@PathVariable long appInfoId, AppInfo appInfo,HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        try {
            String result = appPackageInfoDetailService.queryAppIsInPackageByAppId(appInfoId);
            if (!result.equals(ResultConstant.INEXISTENT)) {
                return ResultConstant.EXIST;
            }
            appInfo.setId(appInfoId);
            appInfo.setStatus(BaseStatus.DISABLED);
            appInfoService.delete(appInfo);
        } catch (Exception e) {
            logger.error("catch Exception deleteAppInfo:[{" + e.getLocalizedMessage() + "}]");
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    /**
     * @Title: queryAllAppInfo
     * @Description: 获取应用名称
     * @return: String
     */
    @RequestMapping(value = "/{organizationId}/getAppInfoNames", method = RequestMethod.POST)
    @ResponseBody
    public List<AppInfo> queryAllAppInfo(@PathVariable long organizationId) {
        return appInfoService.queryAppNamesByOrgId(organizationId);
    }

    /**
     * @Title: queryAllAppInfo
     * @Description: 获取应用名称
     * @return: String
     */
    @RequestMapping(value = "/searchAppByName", method = RequestMethod.GET)
    @ResponseBody
    public String searchAppByName(HttpServletRequest request) {
        String appName = request.getParameter("appName");
        int flag = appInfoService.searchAppByName(appName);
        if (flag != 0) return ResultConstant.EXIST;
        return ResultConstant.INEXISTENT;
    }

    /**
     * @Title: auditedPass
     * @Description: 审核APP 应用
     * @param appId
     * @return: String
     */
    @RequestMapping(value = "/audited", method = RequestMethod.POST)
    @ResponseBody
    public String auditedPass(HttpServletRequest request) {
        try {
            String ids = request.getParameter("ides");
            if(!StringUtils.isEmpty(ids)){
                appInfoService.audited(ids);
            }
        } catch (Exception e) {
            logger.error("catch Exception:[{}]", e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }
    
    @RequestMapping(value = "/{orgId}/createPackageInfoFile", method = RequestMethod.POST)
    @ResponseBody
    public String createPackageInfo(@PathVariable("orgId") String orgId){
    	return appInfoService.createPackageInfoFile(new Long(orgId));
    }

	public String getFileStoragePath() {
		return fileStoragePath;
	}

	public void setFileStoragePath(String fileStoragePath) {
		AppInfoController.fileStoragePath = fileStoragePath;
	}

	public String getAaptPath() {
		return aaptPath;
	}

	public void setAaptPath(String aaptPath) {
		AppInfoController.aaptPath = aaptPath;
	}

}
