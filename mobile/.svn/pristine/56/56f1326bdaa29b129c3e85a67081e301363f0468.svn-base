/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobileImeiUserService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:21:31
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobileImeiUser;

/**
 * @ClassName: IMobileImeiUserService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:21:31
 */
public interface IMobileImeiUserService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    @Transactional
    List<MobileImeiUser> exportAll(Map<String, Object> params);

    @Transactional
    List<MobileImeiUser> exportSelections(List<Long> ids);
}
