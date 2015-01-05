package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppType;

public interface IAppTypeMapper extends IBaseMapper<AppType> {

    @Transactional(readOnly = true)
    List<AppType> page(Map<String, Object> params);

    @Transactional(readOnly = true)
    Long total(Map<String, Object> params);

    /**
     * @Title: searchAppTypeIsPass
     * @Description: 
     * @param appTypeId
     * @return
     * @return: String
     */
    @Transactional(readOnly = true)
    String searchAppTypeIsPass(long appTypeId);

    /**
     * @Title: searchAppTypeByName
     * @Description: 查询应用类型是否相同
     * @param appTypeName
     * @return
     * @return: String
     */
    int searchAppTypeByName(String appTypeName);

}
