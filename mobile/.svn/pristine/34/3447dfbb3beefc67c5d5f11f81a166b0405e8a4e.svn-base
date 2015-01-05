/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileDataUsageServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:34:44
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileDataUsageMapper;
import com.jshuabo.mobile.server.model.mobile.MobileDataUsage;
import com.jshuabo.mobile.server.service.mobile.IMobileDataUsageService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileDataUsageServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:34:44
 */
@Service("mobileDataUsageService")
public class DefaultMobileDataUsageServiceImpl implements IMobileDataUsageService {
    @Autowired
    private IMobileDataUsageMapper mobileDataUsageMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileDataUsage> mobileDataUsageList = mobileDataUsageMapper.page(params);
        Long total = mobileDataUsageMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileDataUsageList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileDataUsage> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileDataUsage> list = mobileDataUsageMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileDataUsage> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileDataUsage> list = mobileDataUsageMapper.exportSelections(ids);
        return list;
    }

}
