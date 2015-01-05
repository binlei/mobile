package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.batchinstall.IMobilePhoneDriverMapper;
import com.jshuabo.mobile.server.model.batchinstall.MobilePhoneDriver;
import com.jshuabo.mobile.server.service.batchinstall.IMobilePhoneDriverService;

@Service("mobilePhoneDriverService")
public class DefaultMobilePhoneDriverServiceImpl implements IMobilePhoneDriverService {
    @Autowired
    private IMobilePhoneDriverMapper mobilePhoneDriverMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<MobilePhoneDriver> mobilePhoneDriverList = mobilePhoneDriverMapper.page(params);
        Long total = mobilePhoneDriverMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", mobilePhoneDriverList);

        return JacksonUtils.object2json(map);
    }

}
