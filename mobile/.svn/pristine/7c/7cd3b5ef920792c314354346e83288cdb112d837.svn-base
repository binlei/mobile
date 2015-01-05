/**
 * Copyright©2013 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileAppModifyInfoMapper.java
 * @Prject: memory-persist
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:08:34 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileAppModifyInfo;
import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.frame.server.model.base.ChartEntity;

/**
 * @ClassName: IMobileAppModifyInfoMapper
 * @Description:
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:08:34 PM
 */
public interface IMobileAppModifyInfoMapper extends IBaseMapper<MobileAppModifyInfo> {
    @Transactional
    List<MobileAppModifyInfo> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileAppModifyInfo> exportAll(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileAppModifyInfo> exportSelections(List<Long> ids);

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
     * @Title: getProcessedRecordIds
     * @Description: 获取已处理过的数据初始ID和结束ID， 用于统计app usage
     * @param beginTime
     * @param endTime
     * @return
     * @return: Map<String,Long>
     */
    @Transactional
    Map<String, Long> getProcessedRecordIds(@Param("beginTime") Date beginTime,
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
     * @Title: processAppUsageRecord
     * @Description: 处理appUsage数据
     * @param beginId
     * @param endId
     * @return
     * @return: Long
     */
    @Transactional
    Long processAppUsageRecord(@Param("beginId") Long beginId, @Param("endId") Long endId);

    @Transactional
    List<ChartEntity> dayUsage(Map<String, Object> params);

    @Transactional
    List<ChartEntity> dayUsageTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> monthUsage(Map<String, Object> params);

    @Transactional
    List<ChartEntity> monthUsageTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> seasonUsage(Map<String, Object> params);

    @Transactional
    List<ChartEntity> seasonUsageTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> yearUsage(Map<String, Object> params);

    @Transactional
    List<ChartEntity> yearUsageTop(Map<String, Object> params);


    @Transactional
    List<ChartEntity> dayPopularTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> monthPopularTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> seasonPopularTop(Map<String, Object> params);

    @Transactional
    List<ChartEntity> yearPopularTop(Map<String, Object> params);

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
    
    /**
     * @Title: updateAppUsageChannel
     * @Description: 更新t_mobile_app_update_total_processed渠道
     * @param beginTime
     * @param endTime
     * @return
     * @return: Long
     */
    @Transactional
    Long updateAppUsageChannel(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
