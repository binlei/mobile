/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: IMobileImeiUserMapper.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.dao.mobile
* @author: lianghe.yuan
* @date: Mar 4, 2014 4:55:43 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.dao.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.mobile.server.model.mobile.MobileImeiUser;
import com.jshuabo.frame.server.dao.IBaseMapper;

/**
 * @ClassName: IMobileImeiUserMapper
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 4, 2014 4:55:43 PM
 */
public interface IMobileImeiUserMapper extends IBaseMapper<MobileImeiUser>{
  @Transactional
  List<MobileImeiUser> page(Map<String, Object> params);
  
  @Transactional
  Long total(Map<String, Object> params);
  
  @Transactional(readOnly = true)
  List<MobileImeiUser> exportAll(Map<String, Object> params);
  
  @Transactional(readOnly = true)
  List<MobileImeiUser> exportSelections(List<Long> ids);
}
