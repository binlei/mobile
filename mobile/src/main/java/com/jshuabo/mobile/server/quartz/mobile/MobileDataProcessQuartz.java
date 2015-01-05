/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobileDataProcessQuartz.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.quartz.mobile
* @author: lianghe.yuan
* @date: Apr 29, 2014 2:23:41 PM
* @version: 
* @Description: 
*/
package com.jshuabo.mobile.server.quartz.mobile;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jshuabo.mobile.server.service.mobile.IMobileDataProcessService;

/**
 * @ClassName: MobileDataProcessQuartz
 * @Description: 
 * @author: lianghe.yuan
 * @date: Apr 29, 2014 2:23:41 PM
 */
public class MobileDataProcessQuartz {
    Logger logger = LoggerFactory.getLogger(MobileDataProcessQuartz.class);
    
    @Autowired
    private IMobileDataProcessService mobileDataProcessService;
    
    /**
      * @Title: process
      * @Description: 整理接口数据
      * @return: void
      */
    public void process() {
        try {
            mobileDataProcessService.process();
        } catch (Exception ex) {
            logger.error("process mobile data error: {}", ex.getLocalizedMessage());
        }
    }
    
    /**
     * @Title: processAppUsage
     * @Description: 统计app使用
     * @return: void
     */
    public void processAppUsage() {
        try {
            mobileDataProcessService.processAppUsage();
        } catch (Exception ex) {
            logger.error("process mobile appusage error: {}", ex.getLocalizedMessage());
        }
    }

    /**
     * @Title: processDeleteOldRecord
     * @Description: 删除原表数据
     * @return: void
     */
    public void processDeleteOldRecord() {
        try {
            mobileDataProcessService.processDeleteOldRecord();
        } catch (Exception ex) {
            logger.error("process mobile appusage error: {}", ex.getLocalizedMessage());
        }
    }
    
    /**
     * @Title: updateChannel
     * @Description: 更新渠道(extendPro4、extendPro5)
     * @return: void
     */
    public void updateChannel() {
        try {
            mobileDataProcessService.updateChannel();
        } catch (Exception e) {
            logger.error("process update channel error: {}", e.getLocalizedMessage());
        }
    }
}
