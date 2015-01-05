/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileAppInstalledServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:32:13
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileAppInstalledMapper;
import com.jshuabo.mobile.server.model.mobile.MobileAppInstalled;
import com.jshuabo.mobile.server.service.mobile.IMobileAppInstalledService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileAppInstalledServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:32:13
 */
@Service("mobileAppInstalledService")
public class DefaultMobileAppInstalledServiceImpl implements IMobileAppInstalledService {
    @Autowired
    private IMobileAppInstalledMapper mobileAppInstalledmapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileAppInstalled> mobileAppInstalledList = mobileAppInstalledmapper.page(params);
        Long total = mobileAppInstalledmapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileAppInstalledList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileAppInstalled> queryByImei(String imei) {
        // TODO Auto-generated method stub
        List<MobileAppInstalled> mobileAppInstalledList =
                mobileAppInstalledmapper.queryByImei(imei);
        return mobileAppInstalledList;
    }

    @Override
    public List<MobileAppInstalled> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileAppInstalled> list = mobileAppInstalledmapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileAppInstalled> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileAppInstalled> list = mobileAppInstalledmapper.exportSelections(ids);
        return list;
    }

}
