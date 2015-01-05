/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileAppInstalledService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:17:20
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileAppInstalled;

/**
 * @ClassName: IMobileAppInstalledService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:17:20
 */
public interface IMobileAppInstalledService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileAppInstalled> queryByImei(String imei);

    @Transactional
    List<MobileAppInstalled> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileAppInstalled> exportSelections(List<Long> ids);
}
