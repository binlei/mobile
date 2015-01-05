/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileLocationServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:35:54
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileLocationMapper;
import com.jshuabo.mobile.server.model.mobile.MobileLocation;
import com.jshuabo.mobile.server.service.mobile.IMobileLocationService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileLocationServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:35:54
 */
@Service("mobileLocationService")
public class DefaultMobileLocationServiceImpl implements IMobileLocationService {
    @Autowired
    private IMobileLocationMapper mobileLocationMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileLocation> mobileLocationList = mobileLocationMapper.page(params);
        Long total = mobileLocationMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileLocationList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public String queryLocationsByImei(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileLocation> mobileLocationList = mobileLocationMapper.queryLocationsByImei(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nums", mobileLocationList.size());
        map.put("rows", mobileLocationList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileLocation> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileLocation> list = mobileLocationMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileLocation> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileLocation> list = mobileLocationMapper.exportSelections(ids);
        return list;
    }

}
