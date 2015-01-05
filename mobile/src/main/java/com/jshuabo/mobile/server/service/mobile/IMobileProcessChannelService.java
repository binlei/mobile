/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: IMobileProcessChannel.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.mobile
* @author: jing.huang
* @date: 2014年5月29日 下午4:30:48
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.service.mobile;

import java.util.Map;

import com.jshuabo.frame.server.service.IBaseService;

/**
 * @ClassName: IMobileProcessChannelService
 * @Description: 
 * @author: jing.huang
 * @date: 2014年5月29日 下午4:30:48
 */
public interface IMobileProcessChannelService extends IBaseService {
    
    void processChannel(Map<String, Object> params);
}
