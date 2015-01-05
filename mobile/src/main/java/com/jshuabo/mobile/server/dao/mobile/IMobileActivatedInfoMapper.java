/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: IMobileActivatedInfoMapper.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.dao.mobile
* @author: lianghe.yuan
* @date: Feb 19, 2014 5:24:07 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileActivatedInfo;
import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.frame.server.model.base.ChartEntity;

/**
 * @ClassName: IMobileActivatedInfoMapper
 * @Description: 
 * @author: lianghe.yuan
 * @date: Feb 19, 2014 5:24:07 PM
 */
public interface IMobileActivatedInfoMapper extends IBaseMapper<MobileActivatedInfo> {
    @Transactional
    List<MobileActivatedInfo> page(Map<String, Object> params);
    
    @Transactional
    Long total(Map<String, Object> params);
    
    @Transactional
    List<MobileActivatedInfo> queryByImei(String imei);
    
    @Transactional(readOnly = true)
    List<MobileActivatedInfo> exportAll(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    List<MobileActivatedInfo> exportSelections(List<Long> ids);
    
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
     
    @Transactional
    Long processRecord(@Param("beginId") Long beginId, @Param("endId") Long endId);
    
    /**
      * @Title: deleteOldRecord
      * @Description: 删除原始表数据(存在于新表)
      * @return: Long
      */
    @Transactional
    Long deleteOldRecord();
    
  //日度
    @Transactional(readOnly=true)
    List<ChartEntity> dayActivated(Map<String,Object> params);

    //日度Top N
    @Transactional(readOnly=true)
    List<ChartEntity> dayActivatedTop(Map<String,Object> params);
    
    //月度
    @Transactional(readOnly=true)
    List<ChartEntity> monthActivated(Map<String,Object> params);
    
    //月度Top N
    @Transactional(readOnly=true)
    List<ChartEntity> monthActivatedTop(Map<String,Object> params);
    
    //季度
    @Transactional(readOnly=true)
    List<ChartEntity> seasonActivated(Map<String,Object> params);
    
    //季度Top N
    @Transactional(readOnly=true)
    List<ChartEntity> seasonActivatedTop(Map<String,Object> params);
    
    //年度
    @Transactional(readOnly=true)
    List<ChartEntity> yearActivated(Map<String,Object> params);
    
    //年度Top N
    @Transactional(readOnly=true)
    List<ChartEntity> yearActivatedTop(Map<String,Object> params);
    
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
