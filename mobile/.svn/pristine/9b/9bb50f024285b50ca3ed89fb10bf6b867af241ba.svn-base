/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: IMobilePushMessageImeiMapper.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.dao.mobile
* @author: lianghe.yuan
* @date: Mar 2, 2014 6:10:23 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.dao.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobilePushMessageImei;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobilePushMessageImeiMapper
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 2, 2014 6:10:23 PM
 */
public interface IMobilePushMessageImeiMapper extends IBaseMapper<MobilePushMessageImei> {
    @Transactional
    void updatePushedMsgStatus(@Param("id") Long id, @Param("locationId") Long locationId, 
                               @Param("pushTime") Date pushTime, @Param("status") String status, @Param("version") String version);
    @Transactional
    List<MobilePushMessageImei> page(Map<String, Object> params);
    
    @Transactional
    Long total(Map<String, Object> params);
    
    @Transactional
    List<MobilePushMessageImei> queryByImei(String imei);
    
    @Transactional(readOnly = true)
    List<MobilePushMessageImei> exportAll(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    List<MobilePushMessageImei> exportSelections(List<Long> ids);
}
