/**
  * Copyright©2014 www.jshuabo.com. all rights reserved.
  *
  * @Title: IMobileAppInstallResultMapper.java
  * @Prject: mobile
  * @Package: com.jshuabo.mobile.server.dao.mobile
  * @author: lianghe.yuan
  * @date: Jun 12, 2014 11:09:41 AM
  * @version: 
  * @Description: 
  */
package com.jshuabo.mobile.server.dao.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.mobile.MobileAppInstallResult;

/**
 * @ClassName: IMobileAppInstallResultMapper
 * @Description: 
 * @author: lianghe.yuan
 * @date: Jun 12, 2014 11:09:41 AM
 */
public interface IMobileAppInstallResultMapper extends IBaseMapper<MobileAppInstallResult> {
    @Transactional
    List<MobileAppInstallResult> page(Map<String, Object> params);
    
    @Transactional
    Long total(Map<String, Object> params);
}
