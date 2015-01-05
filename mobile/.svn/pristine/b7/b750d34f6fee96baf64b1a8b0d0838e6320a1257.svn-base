/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileActivatedInfoService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:05:17
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileActivatedInfo;

/**
 * @ClassName: IMobileActivatedInfoService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:05:17
 */
public interface IMobileActivatedInfoService extends IBaseService {
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileActivatedInfo> queryByImei(String imei);

    @Transactional
    List<MobileActivatedInfo> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileActivatedInfo> exportSelections(List<Long> ids);

    // 日度
    @Transactional(readOnly = true)
    List<ChartEntity> dayActivated(Map<String, Object> params);

    // 日度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> dayActivatedTop(Map<String, Object> params);

    // 月度
    @Transactional(readOnly = true)
    List<ChartEntity> monthActivated(Map<String, Object> params);

    // 月度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> monthActivatedTop(Map<String, Object> params);

    // 季度
    @Transactional(readOnly = true)
    List<ChartEntity> seasonActivated(Map<String, Object> params);

    // 季度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> seasonActivatedTop(Map<String, Object> params);

    // 年度
    @Transactional(readOnly = true)
    List<ChartEntity> yearActivated(Map<String, Object> params);

    // 年度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> yearActivatedTop(Map<String, Object> params);
}
