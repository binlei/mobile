/**
  * Copyright©2014 www.jshuabo.com. all rights reserved.
  *
  * @Title: IMobileDataProcessServiceImpl.java
  * @Prject: mobile
  * @Package: com.jshuabo.mobile.server.service.mobile
  * @author: lianghe.yuan
  * @date: May 4, 2014 1:37:40 PM
  * @version: 
  * @Description: 
  */
package com.jshuabo.mobile.server.service.mobile;

import com.jshuabo.frame.server.service.IBaseService;

/**
 * @ClassName: IMobileDataProcessService
 * @Description: 
 * @author: lianghe.yuan
 * @date: May 4, 2014 1:37:40 PM
 */
public interface IMobileDataProcessService extends IBaseService {
    
    /**
      * @Title: process
      * @Description: 整理接口数据
      * @return: void
      */
    void process();
    
    /**
      * @Title: processAppUsage
      * @Description: 统计app使用
      * @return: void
      */
    void processAppUsage();
    
    /**
      * @Title: processDeleteOldRecord
      * @Description: 删除原始表数据
      * @return: void
      */
    void processDeleteOldRecord();
    
    /**
     * @Title: updateChannel
     * @Description: 更新渠道(extendPro4、extendPro5)
     * @return: void
     */
    void updateChannel();
}
