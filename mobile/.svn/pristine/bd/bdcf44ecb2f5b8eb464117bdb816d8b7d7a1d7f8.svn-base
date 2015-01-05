/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileLocationService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:22:08
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileLocation;

/**
 * @ClassName: IMobileLocationService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:22:08
 */
public interface IMobileLocationService extends IBaseService {
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional(readOnly = true)
    String queryLocationsByImei(Map<String, Object> params);

    @Transactional
    List<MobileLocation> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileLocation> exportSelections(List<Long> ids);
}
