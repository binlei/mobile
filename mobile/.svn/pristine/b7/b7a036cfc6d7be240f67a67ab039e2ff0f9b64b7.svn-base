/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: BaseMobile.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.web.controller.chart
* @author: jing.huang
* @date: 2014年3月27日 下午4:10:55
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.web.controller.chart;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jshuabo.mobile.server.model.mobile.MobileActivatedInfo;
import com.jshuabo.mobile.server.model.mobile.MobileBasicInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileActivatedInfoService;
import com.jshuabo.mobile.server.service.mobile.IMobileAppInstalledService;
import com.jshuabo.mobile.server.service.mobile.IMobileBasicInfoService;
import com.jshuabo.mobile.server.service.mobile.IMobileLocationService;
import com.jshuabo.mobile.server.service.mobile.IMobilePushMessageImeiService;

/**
 * @ClassName: BaseMobile
 * @Description: 
 * @author: jing.huang
 * @date: 2014年3月27日 下午4:10:55
 */
@Controller
@RequestMapping(value = "/baseMobile")
public class BaseMobileController {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(BaseMobileController.class);
    @Autowired
    private IMobileBasicInfoService mobileBasicInfoService;
    @Autowired
    private IMobileAppInstalledService mobileAppInstalledService;
    @Autowired
    private IMobileActivatedInfoService mobileActivatedInfoService;
    @Autowired
    private IMobilePushMessageImeiService mobilePushMessageImeiService;
    @Autowired
    private IMobileLocationService mobileLocationService;
    
    @RequestMapping(value = "infoOfMobile")
    public String infoOfMobile() {
        return "singleStatics/infoOfMobile";
    }
    
    @RequestMapping(value = "/mobileBasicInfo/{imei}",method=RequestMethod.GET)
    public String mobileBasicInfo(@PathVariable String imei, Model model) { 
        MobileBasicInfo mobileBasicInfo = mobileBasicInfoService.queryoneByImei(imei);
        List<MobileActivatedInfo> listMobileActivatedInfo = mobileActivatedInfoService.queryByImei(imei);
        model.addAttribute("mobileBasicInfo", mobileBasicInfo);
        model.addAttribute("listMobileActivatedInfo", listMobileActivatedInfo);
        return "singleStatics/mobileData";
    }
}
