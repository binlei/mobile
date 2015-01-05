/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: MobileAppInstallResultController.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.web.controller.mobile
* @author: jing.huang
* @date: 2014年6月13日 下午5:02:06
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.web.controller.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MobileAppInstallResultController
 * @Description: 
 * @author: jing.huang
 * @date: 2014年6月13日 下午5:02:06
 */
@Controller
@RequestMapping(value="/mobileAppInstallResult")
public class MobileAppInstallResultController {
    @RequestMapping(value="/list")
    public String list() {
        return "/mobileAppInstallResult/list";
    }
}
