/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: AppDataStatisticServiceImpl.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.batchinstall.impl
* @author: peng.wu
* @date: 2014年4月11日 上午6:40:37
* @version:
* @Description: 
*/
package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInstallLogMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInstallLog;
import com.jshuabo.mobile.server.service.batchinstall.IAppDataStatisticService;

/**
 * @ClassName: AppDataStatisticServiceImpl
 * @Description: 
 * @author: peng.wu
 * @date: 2014年4月11日 上午6:40:37
 */
@Service("appDataStatisticService")
public class DefaultAppDataStatisticServiceImpl implements IAppDataStatisticService {
    
    @Autowired
    private IAppInstallLogMapper appInstallLogMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<AppInstallLog> result = appInstallLogMapper.page(params);
        Long total = appInstallLogMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", result);

        return JacksonUtils.object2json(map);
    }
}
