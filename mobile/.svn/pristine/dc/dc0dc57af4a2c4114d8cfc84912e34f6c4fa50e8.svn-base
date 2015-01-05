/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobilePushMessageServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:37:03
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.mobile.IMobilePushMessageMapper;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessage;
import com.jshuabo.mobile.server.service.mobile.IMobilePushMessageService;

/**
 * @ClassName: DefaultMobilePushMessageServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:37:03
 */
@Service("mobilePushMessageService")
public class DefaultMobilePushMessageServiceImpl implements IMobilePushMessageService {
    @Autowired
    private IMobilePushMessageMapper mobilePushMessageMapper;

    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobilePushMessage> mobilePushMessageList = mobilePushMessageMapper.page(params);
        Long total = mobilePushMessageMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobilePushMessageList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobilePushMessage> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobilePushMessage> list = mobilePushMessageMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobilePushMessage> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobilePushMessage> list = mobilePushMessageMapper.exportSelections(ids);
        return list;
    }

    @Override
    public void save(MobilePushMessage mobilePushMessage) {
        // TODO Auto-generated method stub
        mobilePushMessageMapper.save(mobilePushMessage);
    }

    @Override
    public MobilePushMessage loadById(Long id) {
        // TODO Auto-generated method stub
        return mobilePushMessageMapper.load(id);
    }

    @Override
    public void update(MobilePushMessage mobilePushMessage) {
        // TODO Auto-generated method stub
        mobilePushMessageMapper.update(mobilePushMessage);
    }

}
