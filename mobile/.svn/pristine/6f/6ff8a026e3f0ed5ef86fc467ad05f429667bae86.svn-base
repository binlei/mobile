/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobilePushMessageImeiServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:36:32
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobilePushMessageImeiMapper;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessageImei;
import com.jshuabo.mobile.server.service.mobile.IMobilePushMessageImeiService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobilePushMessageImeiServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:36:32
 */
@Service("mobilePushMessageImeiService")
public class DefaultMobilePushMessageImeiServiceImpl implements IMobilePushMessageImeiService {
    @Autowired
    private IMobilePushMessageImeiMapper mobilePushMessageImeiMapper;

    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobilePushMessageImei> mobilePushMessageImeiList =
                mobilePushMessageImeiMapper.page(params);
        Long total = mobilePushMessageImeiMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobilePushMessageImeiList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobilePushMessageImei> queryByImei(String imei) {
        // TODO Auto-generated method stub
        List<MobilePushMessageImei> mobilePushMessageImeiList =
                mobilePushMessageImeiMapper.queryByImei(imei);
        return mobilePushMessageImeiList;
    }

    @Override
    public List<MobilePushMessageImei> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobilePushMessageImei> list = mobilePushMessageImeiMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobilePushMessageImei> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobilePushMessageImei> list = mobilePushMessageImeiMapper.exportSelections(ids);
        return list;
    }

    @Override
    public void save(MobilePushMessageImei mobilePushMessageImei) {
        // TODO Auto-generated method stub
        mobilePushMessageImeiMapper.save(mobilePushMessageImei);
    }

}
