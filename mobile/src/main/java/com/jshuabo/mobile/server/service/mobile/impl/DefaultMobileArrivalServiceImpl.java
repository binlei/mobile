/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileArrivalServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:33:27
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileArrivalMapper;
import com.jshuabo.mobile.server.model.mobile.MobileArrival;
import com.jshuabo.mobile.server.service.mobile.IMobileArrivalService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileArrivalServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:33:27
 */
@Service("mobileArrivalService")
public class DefaultMobileArrivalServiceImpl implements IMobileArrivalService {
    @Autowired
    private IMobileArrivalMapper mobileArrivalMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileArrival> mobileArrivalList = mobileArrivalMapper.page(params);
        Long total = mobileArrivalMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileArrivalList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileArrival> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileArrival> list = mobileArrivalMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileArrival> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileArrival> list = mobileArrivalMapper.exportSelections(ids);
        return list;
    }

    @Override
    public List<ChartEntity> dayArrival(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.dayArrival(params);
    }

    @Override
    public List<ChartEntity> dayArrivalTop(Map<String,Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.dayArrivalTop(params);
    }

    @Override
    public List<ChartEntity> monthArrival(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.monthArrival(params);
    }

    @Override
    public List<ChartEntity> monthArrivalTop(Map<String,Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.monthArrivalTop(params);
    }

    @Override
    public List<ChartEntity> seasonArrival(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.seasonArrival(params);
    }

    @Override
    public List<ChartEntity> seasonArrivalTop(Map<String,Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.seasonArrivalTop(params);
    }

    @Override
    public List<ChartEntity> yearArrival(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.yearArrival(params);
    }

    @Override
    public List<ChartEntity> yearArrivalTop(Map<String,Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileArrivalMapper.yearArrivalTop(params);
    }

}
