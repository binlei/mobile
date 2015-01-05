/**
 * Copyright©2013 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileBasicInfoMapper.java
 * @Prject: memory-persist
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:06:46 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileBasicInfo;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobileBasicInfoMapper
 * @Description:
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:06:46 PM
 */
public interface IMobileBasicInfoMapper extends IBaseMapper<MobileBasicInfo> {
    @Transactional
    List<MobileBasicInfo> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);

    @Transactional
    MobileBasicInfo queryoneByImei(String imei);

    @Transactional(readOnly = true)
    List<MobileBasicInfo> exportAll(Map<String, Object> params);

    @Transactional(readOnly = true)
    List<MobileBasicInfo> exportSelections(List<Long> ids);

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
