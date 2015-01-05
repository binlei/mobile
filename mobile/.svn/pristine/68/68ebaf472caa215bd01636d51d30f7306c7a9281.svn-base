/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: DefaultMobileAppInstallResultServiceImpl.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.mobile.impl
* @author: jing.huang
* @date: 2014年6月13日 下午5:25:59
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.mobile.IMobileAppInstallResultMapper;
import com.jshuabo.mobile.server.model.mobile.MobileAppInstallResult;
import com.jshuabo.mobile.server.service.mobile.IMobileAppInstallResultService;
import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;

/**
 * @ClassName: DefaultMobileAppInstallResultServiceImpl
 * @Description: 
 * @author: jing.huang
 * @date: 2014年6月13日 下午5:25:59
 */
@Service("mobileAppInstallResultService")
public class DefaultMobileAppInstallResultServiceImpl implements IMobileAppInstallResultService {

    @Autowired
    private IMobileAppInstallResultMapper mobileAppInstallResultMapper;
    @Autowired
    private IMobileProcessChannelService mobileProcessChannelService;
    /* (non Javadoc)
     * @Title: page
     * @Description: 
     * @param params
     * @return
     * @see com.jshuabo.mobile.server.service.mobile.IMobileAppInstallResultService#page(java.util.Map)
     */
    @Override
    public String page(Map<String, Object> params) {
        // TODO Auto-generated method stub
        mobileProcessChannelService.processChannel(params);
        List<MobileAppInstallResult> mobileAppInstallResultList = mobileAppInstallResultMapper.page(params);
        Long total = mobileAppInstallResultMapper.total(params);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", total);
        map.put("rows", mobileAppInstallResultList);
        
          return JacksonUtils.object2json(map);
    }

}
