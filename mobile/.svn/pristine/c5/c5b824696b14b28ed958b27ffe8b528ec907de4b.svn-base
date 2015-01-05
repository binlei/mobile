/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobilePushMessageImeiService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:23:35
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessageImei;

/**
 * @ClassName: IMobilePushMessageImeiService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:23:35
 */
public interface IMobilePushMessageImeiService extends IBaseService {
    /**
     * @Title: page
     * @Description: 分页列表
     * @param params
     * @return
     * @return: String
     */
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    /**
     * @Title: queryByImei
     * @Description: 通过IMEI查询单个对象
     * @param imei
     * @return
     * @return: List<MobilePushMessageImei>
     */
    @Transactional
    List<MobilePushMessageImei> queryByImei(String imei);

    /**
     * @Title: exportAll
     * @Description: 导出所有
     * @param params
     * @return
     * @return: List<MobilePushMessageImei>
     */
    @Transactional
    List<MobilePushMessageImei> exportAll(Map<String, Object> params);

    /**
     * @Title: exportSelections
     * @Description: 导出所选
     * @param ids
     * @return
     * @return: List<MobilePushMessageImei>
     */
    @Transactional
    List<MobilePushMessageImei> exportSelections(List<Long> ids);
    
    /**
     * @Title: save
     * @Description: 推送消息
     * @param mobilePushMessageImei
     * @return: void
     */
    @Transactional
    void save(MobilePushMessageImei mobilePushMessageImei);
}
