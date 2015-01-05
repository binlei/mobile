/**
 * Copyright©2013 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileArrivalMapper.java
 * @Prject: memory-persist
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:05:46 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileArrival;
import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.frame.server.model.base.ChartEntity;

/**
 * @ClassName: IMobileArrival
 * @Description:
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:05:46 PM
 */
public interface IMobileArrivalMapper extends IBaseMapper<MobileArrival> {
    @Transactional
    List<MobileArrival> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);

    // 导出
    @Transactional(readOnly = true)
    List<MobileArrival> exportAll(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileArrival> exportSelections(List<Long> ids);

    // 日度
    @Transactional(readOnly = true)
    List<ChartEntity> dayArrival(Map<String, Object> params);

    // 日度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> dayArrivalTop(Map<String, Object> params);

    // 月度
    @Transactional(readOnly = true)
    List<ChartEntity> monthArrival(Map<String, Object> params);

    // 月度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> monthArrivalTop(Map<String, Object> params);

    // 季度
    @Transactional(readOnly = true)
    List<ChartEntity> seasonArrival(Map<String, Object> params);

    // 季度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> seasonArrivalTop(Map<String, Object> params);

    // 年度
    @Transactional(readOnly = true)
    List<ChartEntity> yearArrival(Map<String, Object> params);

    // 年度Top N
    @Transactional(readOnly = true)
    List<ChartEntity> yearArrivalTop(Map<String, Object> params);

    /**
     * @Title: getProcessRecordIds
     * @Description: 获取待处理数据的初始ID和结束ID
     * @param beginTime
     * @param endTime
     * @return
     * @return: Map<String, Long>
     */
    @Transactional
    Map<String, Long> getProcessRecordIds(@Param("beginTime") Date beginTime,
            @Param("endTime") Date endTime);

    /**
     * @Title: processRecord
     * @Description:
     * @param beginTime
     * @param endTime
     * @return
     * @return: Long
     */
    @Transactional
    Long processRecord(@Param("beginId") Long beginId, @Param("endId") Long endId);

    /**
     * @Title: deleteOldRecord
     * @Description: 删除原始表数据(存在于新表)
     * @return: Long
     */
    @Transactional
    Long deleteOldRecord();

    /**
     * @Title: updateChannel
     * @Description: 更新渠道
     * @param beginTime
     * @param endTime
     * @return
     * @return: Long
     */
    @Transactional
    Long updateChannel(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
