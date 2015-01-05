package com.jshuabo.mobile.server.service.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageType;

public interface IAppPackageTypeService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);
    
    /**
     * @Title: load
     * @Description: loadById
     * @param appPackId
     * @return: void
     */
    @Transactional
    AppPackageType load(int appPackId);

    /**
     * @Title: save
     * @Description: 
     * @param appPackageType
     * @return: void
     */
    @Transactional
    void save(AppPackageType appPackageType);

    /**
     * @Title: update
     * @Description: 
     * @param appPackageType
     * @return: void
     */
    @Transactional
    void update(AppPackageType appPackageType);

    /**
     * @Title: delete
     * @Description: 
     * @param appPackageType
     * @return: void
     */
    @Transactional
    void delete(AppPackageType appPackageType);

    /**
     * @Title: loadAll
     * @Description: 
     * @return
     * @return: List<AppPackageType>
     */
    @Transactional
    List<AppPackageType> loadAll();

    /**
     * @Title: searchPackageTypeNameIsPass
     * @Description: 是否有效
     * @param packageTypeName
     * @return
     * @return: String
     */
    @Transactional
    String searchPackageTypeNameIsPass(Long packageTypeName);

    /**
     * @Title: deleteByPackTypeId
     * @Description:根据 类型 id 删除包类型
     * @param appPackTypeId
     * @return
     * @return: String
     */
    @Transactional
    String deleteByPackTypeId(Long appPackTypeId);

}
