/**
 * Copyright©2013 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileLocationMapper.java
 * @Prject: memory-persist
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:08:01 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileLocation;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobileLocationMapper
 * @Description:
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:08:01 PM
 */
public interface IMobileLocationMapper extends IBaseMapper<MobileLocation> {
    @Transactional
    List<MobileLocation> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);

    @Transactional
    List<MobileLocation> queryLocationsByImei(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileLocation> exportAll(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileLocation> exportSelections(List<Long> ids);

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
