/**
 * Copyright©2013 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileAppInstalledMapper.java
 * @Prject: memory-persist
 * @Package: com.jshuabo.mobile.server.dao.mobile
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:07:27 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileAppInstalled;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobileAppInstalledMapper
 * @Description:
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 4:07:27 PM
 */
public interface IMobileAppInstalledMapper extends IBaseMapper<MobileAppInstalled> {
    @Transactional
    List<MobileAppInstalled> page(Map<String, Object> params);

    @Transactional
    Long total(Map<String, Object> params);
    
    @Transactional
    List<MobileAppInstalled> queryByImei(String imei);
    
    @Transactional(readOnly = true)
    List<MobileAppInstalled> exportAll(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    List<MobileAppInstalled> exportSelections(List<Long> ids);
    
    /**
     * @Title: getProcessRecordIds
     * @Description: 获取待处理数据的初始ID和结束ID
     * @param beginTime
     * @param endTime
     * @return
     * @return: Map<String, Long>
     */
     @Transactional
     Map<String, Long> getProcessRecordIds(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

     /**
      * @Title: getProcessedRecordIds
      * @Description: 获取已处理过的数据初始ID和结束ID， 用于统计app usage
      * @param beginTime
      * @param endTime
      * @return
      * @return: Map<String,Long>
      */
     Map<String, Long> getProcessedRecordIds(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
     
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
