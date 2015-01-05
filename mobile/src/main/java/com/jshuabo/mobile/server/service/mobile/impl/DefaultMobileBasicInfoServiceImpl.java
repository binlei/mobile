/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileBasicInfoServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:34:11
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileBasicInfoMapper;
import com.jshuabo.mobile.server.model.mobile.MobileBasicInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileBasicInfoService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileBasicInfoServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:34:11
 */
@Service("mobileBasicInfoService")
public class DefaultMobileBasicInfoServiceImpl implements IMobileBasicInfoService {
    @Autowired
    private IMobileBasicInfoMapper mobileBasicInfoMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileBasicInfo> mobileBasicInfoList = mobileBasicInfoMapper.page(params);
        Long total = mobileBasicInfoMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileBasicInfoList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public MobileBasicInfo queryoneByImei(String imei) {
        // TODO Auto-generated method stub
        MobileBasicInfo mobileBasicInfo = mobileBasicInfoMapper.queryoneByImei(imei);
        return mobileBasicInfo;
    }

    @Override
    public List<MobileBasicInfo> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileBasicInfo> list = mobileBasicInfoMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileBasicInfo> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileBasicInfo> list = mobileBasicInfoMapper.exportSelections(ids);
        return list;
    }

}
