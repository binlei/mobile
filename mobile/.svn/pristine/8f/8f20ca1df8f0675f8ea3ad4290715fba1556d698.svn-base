/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: IMobilePushMessageMapper.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.dao.mobile
* @author: lianghe.yuan
* @date: Mar 2, 2014 5:55:02 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.dao.mobile;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobilePushMessage;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobilePushMessageMapper
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 2, 2014 5:55:02 PM
 */
public interface IMobilePushMessageMapper extends IBaseMapper<MobilePushMessage> {
    @Transactional(readOnly = true)
    Map<String, Object> queryMessageByImei(@Param("status") String status, @Param("imei") String imei);
    
    @Transactional
    List<MobilePushMessage> page(Map<String, Object> params);
    
    @Transactional
    Long total(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    List<MobilePushMessage> exportAll(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    List<MobilePushMessage> exportSelections(List<Long> ids);
    
    @Transactional
    void save(MobilePushMessage mobilePushMessage);
}
