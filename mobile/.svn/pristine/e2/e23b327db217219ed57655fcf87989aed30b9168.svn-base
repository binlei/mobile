/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: DefaultMobileProcessChannelImpl.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.service.mobile.impl
* @author: jing.huang
* @date: 2014年5月29日 下午4:32:26
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jshuabo.mobile.server.service.mobile.IMobileProcessChannelService;

/**
 * @ClassName: DefaultMobileProcessChannelServiceImpl
 * @Description: 
 * @author: jing.huang
 * @date: 2014年5月29日 下午4:32:26
 */
@Service
public class DefaultMobileProcessChannelServiceImpl implements IMobileProcessChannelService {

    /* (non Javadoc)
     * @Title: processChannel
     * @Description: 
     * @param params
     * @see com.jshuabo.mobile.server.service.mobile.IMobileProcessChannel#processChannel(java.util.Map)
     */
    @Override
    public void processChannel(Map<String, Object> params) {
        // TODO Auto-generated method stub
        String extendProp4 = (String) params.get("extendProp4"); 
        if(extendProp4 != null) {
            String[] extendProp4Array = extendProp4.split(",");
            List<String> extendProp4List = new ArrayList<String>();
            for(String e : extendProp4Array) {
                extendProp4List.add(e);
            }
            params.remove("extendProp4");
            params.put("extendProp4", extendProp4List);
        }
    }

}
