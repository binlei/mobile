/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileDataUsageService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:20:48
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileDataUsage;

/**
 * @ClassName: IMobileDataUsageService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:20:48
 */
public interface IMobileDataUsageService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional
    List<MobileDataUsage> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileDataUsage> exportSelections(List<Long> ids);
}
