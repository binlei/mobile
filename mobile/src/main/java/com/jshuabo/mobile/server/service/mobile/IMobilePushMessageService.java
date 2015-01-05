/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: IMobilePushMessageService.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:22:43
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessage;

/**
 * @ClassName: IMobilePushMessageService
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:22:43
 */
public interface IMobilePushMessageService extends IBaseService {

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
     * @Title: exportAll
     * @Description: 导出所有
     * @param params
     * @return
     * @return: List<MobilePushMessage>
     */
    @Transactional
    List<MobilePushMessage> exportAll(Map<String, Object> params);

    /**
     * @Title: exportSelections
     * @Description: 导出所选
     * @param ids
     * @return
     * @return: List<MobilePushMessage>
     */
    @Transactional
    List<MobilePushMessage> exportSelections(List<Long> ids);
    
    /**
     * @Title: save
     * @Description: 新建消息
     * @param mobilePushMessage
     * @return: void
     */
    @Transactional
    void save(MobilePushMessage mobilePushMessage);
    
    /**
     * @Title: loadById
     * @Description: 根据id获取相应的MobilePushMessage对象
     * @param id
     * @return
     * @return: MobilePushMessage
     */
    @Transactional
    MobilePushMessage loadById(Long id);
    
    /**
     * @Title: update
     * @Description: 更新消息
     * @param mobilePushMessage
     * @return: void
     */
    @Transactional
    void update(MobilePushMessage mobilePushMessage);
}
