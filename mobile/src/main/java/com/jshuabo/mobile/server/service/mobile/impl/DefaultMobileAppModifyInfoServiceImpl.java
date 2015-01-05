/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileAppModifyInfoServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:32:48
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileAppModifyInfoMapper;
import com.jshuabo.mobile.server.model.mobile.MobileAppModifyInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileAppModifyInfoService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileAppModifyInfoServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:32:48
 */
@Service("mobileAppModifyInfoService")
public class DefaultMobileAppModifyInfoServiceImpl implements IMobileAppModifyInfoService {
    @Autowired
    private IMobileAppModifyInfoMapper mobileAppModifyInfoMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileAppModifyInfo> mobileAppModifyInfoList = mobileAppModifyInfoMapper.page(params);
        Long total = mobileAppModifyInfoMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileAppModifyInfoList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileAppModifyInfo> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileAppModifyInfo> list = mobileAppModifyInfoMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileAppModifyInfo> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileAppModifyInfo> list = mobileAppModifyInfoMapper.exportSelections(ids);
        return list;
    }

    @Override
    public List<ChartEntity> dayUsage(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.dayUsage(params);
    }

    @Override
    public List<ChartEntity> dayUsageTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.dayUsageTop(params);
    }

    @Override
    public List<ChartEntity> monthUsage(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.monthUsage(params);
    }

    @Override
    public List<ChartEntity> monthUsageTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.monthUsageTop(params);
    }

    @Override
    public List<ChartEntity> seasonUsage(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.seasonUsage(params);
    }

    @Override
    public List<ChartEntity> seasonUsageTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.seasonUsageTop(params);
    }

    @Override
    public List<ChartEntity> yearUsage(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.yearUsage(params);
    }

    @Override
    public List<ChartEntity> yearUsageTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.yearUsageTop(params);
    }

    @Override
    public List<ChartEntity> dayPopularTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.dayPopularTop(params);
    }

    @Override
    public List<ChartEntity> monthPopularTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.monthPopularTop(params);
    }

    @Override
    public List<ChartEntity> seasonPopularTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.seasonPopularTop(params);
    }

    @Override
    public List<ChartEntity> yearPopularTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileAppModifyInfoMapper.yearPopularTop(params);
    }

}
