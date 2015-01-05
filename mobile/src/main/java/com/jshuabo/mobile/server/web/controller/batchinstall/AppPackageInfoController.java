package com.jshuabo.mobile.server.web.controller.batchinstall;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;
import com.jshuabo.mobile.server.service.batchinstall.IAppInfoService;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoDetailService;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoService;

/**
 * @ClassName: AppPackageInfoController
 * @Description:  应用包信息   控制层
 * @author: peng.wu
 * @date: 2014年4月20日 上午10:03:44
 */
@Controller
@RequestMapping("/appPackageInfo")
public class AppPackageInfoController {

    private static final Logger logger = LoggerFactory.getLogger(AppPackageInfoController.class);

    @Autowired
    private IAppPackageInfoService appPkgInfoService;
    
    @Autowired
    private IAppInfoService appInfoService;
    
    @Autowired
    private IAppPackageInfoDetailService appPackageInfoDetailService;

    /**
     * @Title: appPackageInfoList
     * @Description: List 页面
     * @return: String
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String appPackageInfoList() {
        return "appPackageInfo/list";
    }
    
    @RequestMapping(value = "/listView", method = RequestMethod.GET)
    public String appPackageInfoListView() {
        return "appPackageInfo/listView";
    }
    
    @RequestMapping(value="{orgId}/addPackageDetail",method=RequestMethod.GET)
    public String requestAddDetailPage(@PathVariable("orgId") long orgId){
        return "appPackageInfo/addPackageDetail";
    }
    

    /**
     * @Title: addAppPackageInfoDetail
     * @Description: 添加明细
     * @param request
     * @return: String
     */
    @RequestMapping(value = "/{appPackageId}/{appInfoId}/addDetail", method = RequestMethod.POST)
    @ResponseBody
    public String addAppPackageInfoDetail(@PathVariable("appPackageId")long appPackageId, @PathVariable("appInfoId")long appInfoId, HttpServletRequest request) {
        try {
            appPkgInfoService.addDetail(appPackageId, appInfoId);
        } catch (Exception e) {
             logger.error("catch Exception addAppPackageInfoDetail :[{}]",e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    /**
     * @Title: reqeustAppPackageInfoAddPage
     * @Description: 处理添加页面
     * @param appPackageInfo
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String requstAppPackageInfoAddPage(AppPackageInfo appPackageInfo) {
        return "appPackageInfo/add";
    }

    /**
     * @Title: addAppPackageInfo
     * @Description: 添加
     * @param appPackageInfo
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addAppPackageInfo(AppPackageInfo appPackageInfo) {
        try {
            appPkgInfoService.save(appPackageInfo);
        } catch (Exception e) {
            logger.error("catch Exception for add AppPackageInfo :[{}]",e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return "success";
    }

    
    /**
     * @Title: requestAppPackageInfoAddPage
     * @Description: 转向 编辑页面
     * @param appPkgInfoId
     * @param model
     * @return: String
     */
    @RequestMapping(value = "/edit/{appPkgInfoId}", method = RequestMethod.GET)
    public String requestAppPackageInfoAddPage(@PathVariable long appPkgInfoId, Model model) {
        model.addAttribute("appPackageInfo", appPkgInfoService.load(appPkgInfoId));
        return "appPackageInfo/edit";
    }

    /**
     * @Title: editAppPackageInfo
     * @Description: 编辑
     * @param appPkgInfoId
     * @param appPackageInfo
     * @return: String
     */
    @RequestMapping(value = "/edit/{appPkgInfoId}", method = RequestMethod.POST)
    @ResponseBody
    public String editAppPackageInfo(@PathVariable long appPkgInfoId, AppPackageInfo appPackageInfo) {
        try {
            appPkgInfoService.update(appPackageInfo);
        } catch (Exception e) {
            logger.error("catch Exception for editAppPackageInfo:[{}]",e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    /**
     * @Title: deleteAppPackageInfo
     * @Description: 删除
     * @param appPkgInfoId
     * @param appPackageInfo
     * @return: String
     */
    @RequestMapping(value = "/{appPkgInfoId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAppPackageInfo(@PathVariable long appPkgInfoId) {
        String result =null;
        try {
            result = appPkgInfoService.deleteByPackageId(appPkgInfoId);
        } catch (Exception e) {
            logger.error("catch Exception for deleteAppPackageInfo:[{}]",e.getLocalizedMessage());
            return result;
        }
        return result;
    }
    
    /**
     * @Title: queryAppInfoByPackageId
     * @Description: 根据包id 查询属于该包下面的应用
     * @param appPkgInfoId
     * @return: List<AppInfo>
     */
    @RequestMapping(value = "/{pkgId}/queryAppInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryAppInfoByPackageId(@PathVariable long pkgId,HttpServletRequest request) {
        Map<String,Object> map =  new HashMap<String, Object>();
        int page = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        int offset = (page-1)*pageSize;
        int rows = page*pageSize;
        
        map.put("offset", offset);
        map.put("rows", rows);
        map.put("sortOrder", request.getParameter("sort"));
        map.put("appPkgInfoId", pkgId);
        return appPkgInfoService.queryByPackageId(map);
    }
    /**
     * @Title: queryAppInfoByPackageId
     * @Description: 根据包id 查询属于该包下面的应用
     * @param appPkgInfoId
     * @return: List<AppInfo>
     */
    @RequestMapping(value = "/{orgId}/{appPkgInfoId}/queryAppInfo", method = RequestMethod.GET)
    public String requestQueryAppInfoByPackageId(@PathVariable("orgId")long orgId, @PathVariable("appPkgInfoId") long appPkgInfoId,HttpServletRequest request) {
        request.setAttribute("appPkgId", appPkgInfoId);
        request.setAttribute("orgId", orgId); 
        return "appPackageInfo/appPackageDetail";
    }
    /**
     * @Title: queryAppInfoByPackageId
     * @Description: 根据包id 查询属于该包下面的应用
     * @param appPkgInfoId
     * @return: List<AppInfo>
     */
    @RequestMapping(value = "/{orgId}/{appPkgInfoId}/viewQueryAppInfo", method = RequestMethod.GET)
    public String requestViewQueryAppInfoByPackageId(@PathVariable("orgId")long orgId, @PathVariable("appPkgInfoId") long appPkgInfoId,HttpServletRequest request) {
        request.setAttribute("appPkgId", appPkgInfoId);
        request.setAttribute("orgId", orgId); 
        return "appPackageInfo/viewPackageDetail";
    }
   
    /**
     * @Title: queryAppInfoByPackageId
     * @Description: 根据包id 查询属于包名
     * @param appPkgInfoId
     * @return: List<AppInfo>
     */
    @RequestMapping(value = "/searchPackageByName", method = RequestMethod.GET)
    @ResponseBody
    public String searchPackageByName(HttpServletRequest request) {
        String packageName = request.getParameter("packageName");
        int flag = appPkgInfoService.queryAppPackageNameByName(packageName);
        if(flag !=ResultConstant.RESULTED) return ResultConstant.EXIST;
        return ResultConstant.INEXISTENT;
    }

    /**
     * @Title: deleteDetail
     * @Description: 根据appId 删除明细
     * @return: String
     */
    @RequestMapping(value = "/{apkPkgId}/{apkId}/deleteDetail", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDetail(@PathVariable long apkPkgId,@PathVariable long apkId, HttpServletRequest request) {
          return appPkgInfoService.deleteDetailByPkgIdAndApkId(apkPkgId,apkId);
    }
}
