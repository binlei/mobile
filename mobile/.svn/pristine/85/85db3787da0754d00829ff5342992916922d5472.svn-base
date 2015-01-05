/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileImeiUserServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:35:22
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.dao.mobile.IMobileImeiUserMapper;
import com.jshuabo.mobile.server.model.mobile.MobileImeiUser;
import com.jshuabo.mobile.server.service.mobile.IMobileImeiUserService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: DefaultMobileImeiUserServiceImpl
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 下午1:35:22
 */
@Service("mobileImeiUserService")
public class DefaultMobileImeiUserServiceImpl implements IMobileImeiUserService {
    @Autowired
    private IMobileImeiUserMapper mobileImeiUserMapper;

    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobileImeiUser> mobileImeiUserList = mobileImeiUserMapper.page(params);
        Long total = mobileImeiUserMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobileImeiUserList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<MobileImeiUser> exportAll(Map<String, Object> params) {
        // TODO Auto-generated method stub
        List<MobileImeiUser> list = mobileImeiUserMapper.exportAll(params);
        return list;
    }

    @Override
    public List<MobileImeiUser> exportSelections(List<Long> ids) {
        // TODO Auto-generated method stub
        List<MobileImeiUser> list = mobileImeiUserMapper.exportSelections(ids);
        return list;
    }

}
