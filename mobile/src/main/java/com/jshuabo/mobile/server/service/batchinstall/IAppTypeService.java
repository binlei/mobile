package com.jshuabo.mobile.server.service.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.batchinstall.AppType;

public interface IAppTypeService extends IBaseService {

    /**
     * @Title: page
     * @Description: 
     * @param params
     * @return
     * @return: String
     */
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    /**
     * @Title: loadAll
     * @Description: 
     * @return
     * @return: List<AppType>
     */
    @Transactional(readOnly = true)
    List<AppType> loadAll();

    /**
     * @Title: load
     * @Description: 
     * @param appTypeId
     * @return
     * @return: AppType
     */
    @Transactional(readOnly = true)
    AppType load(Long appTypeId);

    /**
     * @Title: save
     * @Description: 
     * @param appType
     * @return: void
     */
    @Transactional
    void save(AppType appType);

    /**
     * @Title: update
     * @Description: 
     * @param appType
     * @return: void
     */
    @Transactional
    void update(AppType appType);

    /**
     * @Title: searchAppTypeIsPass
     * @Description: 检查应用类型是否失效
     * @param appTypeId
     * @return: void
     */
    @Transactional
    String  searchAppTypeIsPass(Long appTypeId);

    /**
     * @Title: searchAppTypeByName
     * @Description: 
     * @param appTypeName
     * @return
     * @return: String
     */
    @Transactional
    int searchAppTypeByName(String appTypeName);

    /**
     * @Title: deleteById
     * @Description: 删除
     * @param appTypeId
     * @return: String
     */
    @Transactional
    String deleteById(Long appTypeId); 
    
    
}
