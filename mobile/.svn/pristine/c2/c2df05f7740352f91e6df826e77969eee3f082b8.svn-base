package com.jshuabo.mobile.server.web.controller.batchinstall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.mobile.server.service.batchinstall.IAppInfoService;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoDetailService;

@Controller
@RequestMapping("/appPackageInfoDetail")
public class AppPackageInfoDetailController {

    @Autowired
    private IAppPackageInfoDetailService appPackageInfoDetailService;
    
    @Autowired
    private IAppInfoService appInfoService;
    
    /**
     * @Title: appPackageInfoDetailList
     * @Description:
     * @return
     * @return: String
     */
    @RequestMapping("/list")
    public String appPackageInfoDetailList() {
        return "appPackageInfoDetail/list";
    }

    /**
     * @Title: checkAppInfoRepetition
     * @Description:
     * @param appInfoId
     * @return: String
     */
    @RequestMapping(value = "/searchRepAppInfo", method = RequestMethod.GET)
    @ResponseBody
    public String checkAppInfoRepetition(HttpServletRequest request) {
        String appInfoId = request.getParameter("appInfoId");
        String appPackageId = request.getParameter("appPackageId");
        return appPackageInfoDetailService.checkAppInfoRepetition(appInfoId, appPackageId);
    }

}
