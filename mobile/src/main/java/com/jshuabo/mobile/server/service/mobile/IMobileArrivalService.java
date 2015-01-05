/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileArrivalService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:19:27
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileArrival;

/**
 * @ClassName: IMobileArrivalService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:19:27
 */
/**
 * @ClassName: IMobileArrivalService
 * @Description:
 * @author: jing.huang
 * @date: 2014年4月23日 下午7:26:53
 */
/**
 * @ClassName: IMobileArrivalService
 * @Description:
 * @author: jing.huang
 * @date: 2014年4月23日 下午7:26:58
 */
public interface IMobileArrivalService extends IBaseService {

    /**
     * @Title: page
     * @Description: 分页
     * @param params
     * @return
     * @return: String
     */
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    /**
     * @Title: exportAll
     * @Description: 导出所有查询结果
     * @param params
     * @return
     * @return: List<MobileArrival>
     */
    @Transactional
    List<MobileArrival> exportAll(Map<String, Object> params);

    /**
     * @Title: exportSelections
     * @Description: 导出所选
     * @param ids
     * @return
     * @return: List<MobileArrival>
     */
    @Transactional
    List<MobileArrival> exportSelections(List<Long> ids);

    /**
     * @Title: dayArrival
     * @Description: 日到达数据
     * @param params
     * @return
     * @return: Map<String,List<Object>>
     */
    @Transactional
    List<ChartEntity> dayArrival(Map<String, Object> params);
    
    /**
     * @Title: dayArrivalTop
     * @Description: 日到达数据Top N
     * @return
     * @return: Map<String,List<Object>>
     */
    @Transactional
    List<ChartEntity> dayArrivalTop(Map<String,Object> params);
    
    /**
     * @Title: monthArrival
     * @Description: 月到达数据
     * @param params
     * @return
     * @return: Map<String,List<Object>>
     */
    @Transactional
    List<ChartEntity> monthArrival(Map<String, Object> params);
    /**
     * @Title: monthArrivalTop
     * @Description: 月到达数据Top N
     * @return
     * @return: List<ChartEntity>
     */
    @Transactional
    List<ChartEntity> monthArrivalTop(Map<String,Object> params);
    /**
     * @Title: seasonArrival
     * @Description: 季到达数据
     * @param params
     * @return
     * @return: List<ChartEntity>
     */
    @Transactional
    List<ChartEntity> seasonArrival(Map<String, Object> params);
    /**
     * @Title: seasonArrivalTop
     * @Description: 季到达数据Top N
     * @return
     * @return: List<ChartEntity>
     */
    @Transactional
    List<ChartEntity> seasonArrivalTop(Map<String,Object> params);
    /**
     * @Title: yearArrival
     * @Description: 年到达数据
     * @param params
     * @return
     * @return: List<ChartEntity>
     */
    @Transactional
    List<ChartEntity> yearArrival(Map<String, Object> params);
    /**
     * @Title: yearArrivalTop
     * @Description: 年到达数据TopN
     * @return
     * @return: List<ChartEntity>
     */
    @Transactional
    List<ChartEntity> yearArrivalTop(Map<String,Object> params);
    
}
