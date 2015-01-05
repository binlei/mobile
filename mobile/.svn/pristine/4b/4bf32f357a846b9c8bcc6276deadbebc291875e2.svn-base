/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileAppModifyInfoService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:18:18
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileAppModifyInfo;

/**
 * @ClassName: IMobileAppModifyInfoService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:18:18
 */
public interface IMobileAppModifyInfoService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional
    List<MobileAppModifyInfo> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileAppModifyInfo> exportSelections(List<Long> ids);
    
    @Transactional
    List<ChartEntity> dayUsage(Map<String, Object> params);
    
    @Transactional
    List<ChartEntity> dayUsageTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> monthUsage(Map<String, Object> params);
    
    @Transactional
    List<ChartEntity> monthUsageTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> seasonUsage(Map<String, Object> params);
    
    @Transactional
    List<ChartEntity> seasonUsageTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> yearUsage(Map<String, Object> params);
    
    @Transactional
    List<ChartEntity> yearUsageTop(Map<String,Object> params);
    
    
    @Transactional
    List<ChartEntity> dayPopularTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> monthPopularTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> seasonPopularTop(Map<String,Object> params);
    
    @Transactional
    List<ChartEntity> yearPopularTop(Map<String,Object> params);
}
