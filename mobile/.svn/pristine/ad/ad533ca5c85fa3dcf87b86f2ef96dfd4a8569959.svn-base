/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileBasicInfoService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:20:04
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileBasicInfo;

/**
 * @ClassName: IMobileBasicInfoService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:20:04
 */
public interface IMobileBasicInfoService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional(readOnly = true)
    MobileBasicInfo queryoneByImei(String imei);

    @Transactional
    List<MobileBasicInfo> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileBasicInfo> exportSelections(List<Long> ids);
}
