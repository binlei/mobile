/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: DefaultMobileActivatedInfoServiceImpl.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.mobile.impl
* @author: jing.huang
* @date: 2014年3月12日 下午1:31:13
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.mobile.IMobileActivatedInfoMapper;
import com.jshuabo.mobile.server.model.mobile.MobileActivatedInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileActivatedInfoService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;

/**
 * @ClassName: DefaultMobileActivatedInfoServiceImpl
 * @Description: 
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:31:13
 */
@Service("mobileActivatedInfoService")
public class DefaultMobileActivatedInfoServiceImpl implements IMobileActivatedInfoService {
    @Autowired
    private IMobileActivatedInfoMapper mobileActivatedInfoMapper;
    
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;

    @Override
    public String page(Map<String, Object> params) {
      mobileProcessChannelService.processChannel(params);
      List<MobileActivatedInfo> mobileActivatedInfoList = mobileActivatedInfoMapper.page(params);
      Long total = mobileActivatedInfoMapper.total(params);
      
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("total", total);
      map.put("rows", mobileActivatedInfoList);
      
        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileActivatedInfo> queryByImei(String imei) {
        // TODO Auto-generated method stub
        List<MobileActivatedInfo> mobileActivatedInfoList = mobileActivatedInfoMapper.queryByImei(imei);
        return mobileActivatedInfoList;
    }

    @Override
    public List<MobileActivatedInfo> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileActivatedInfo> list = mobileActivatedInfoMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileActivatedInfo> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileActivatedInfo> list = mobileActivatedInfoMapper.exportSelections(ids);
        return list;
    }

    @Override
    public List<ChartEntity> dayActivated(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.dayActivated(params);
    }

    @Override
    public List<ChartEntity> dayActivatedTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.dayActivatedTop(params);
    }

    @Override
    public List<ChartEntity> monthActivated(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.monthActivated(params);
    }

    @Override
    public List<ChartEntity> monthActivatedTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.monthActivatedTop(params);
    }

    @Override
    public List<ChartEntity> seasonActivated(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.seasonActivated(params);
    }

    @Override
    public List<ChartEntity> seasonActivatedTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.seasonActivatedTop(params);
    }

    @Override
    public List<ChartEntity> yearActivated(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.yearActivated(params);
    }

    @Override
    public List<ChartEntity> yearActivatedTop(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        return mobileActivatedInfoMapper.yearActivatedTop(params);
    }

}
