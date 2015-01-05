/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: IMobileAppInstallResultService.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.mobile
* @author: jing.huang
* @date: 2014年6月13日 下午5:23:43
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.service.mobile;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;

/**
 * @ClassName: IMobileAppInstallResultService
 * @Description: 
 * @author: jing.huang
 * @date: 2014年6月13日 下午5:23:43
 */
public interface IMobileAppInstallResultService extends IBaseService {
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);
}
