/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileDataUsageMapper.java
 * @Prject: mobile_api
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Feb 19, 2014 5:23:29 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileDataUsage;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobileDataUsageMapper
 * @Description:
 * @author: lianghe.yuan
 * @date: Feb 19, 2014 5:23:29 PM
 */
public interface IMobileDataUsageMapper extends IBaseMapper<MobileDataUsage> {
    @Transactional
    List<MobileDataUsage> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileDataUsage> exportAll(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileDataUsage> exportSelections(List<Long> ids);

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
