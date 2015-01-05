package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageType;

public interface IAppPackageTypeMapper extends IBaseMapper<AppPackageType> {

    @Transactional(readOnly = true)
    List<AppPackageType> page(Map<String, Object> params);

    @Transactional(readOnly = true)
    Long total(Map<String, Object> params);

    @Transactional
    void save(AppPackageType appPackageType);
    
    @Transactional(readOnly = true)
    Integer queryAppPackageNameByName(String appPackageName);

    /**
     * @Title: searchPackageTypeNameIsPass
     * @Description: 查询 包类型是否 有效
     * @param packageTypeName
     * @return
     * @return: String
     */
    @Transactional
    String searchPackageTypeNameIsPass(Long packageTypeId);

    /**
     * @Title: deleteById
     * @Description: 查询 包类型 是否关联其它应用
     * @param appPackId
     * @return
     * @return: List<String>
     */
    @Transactional
    Integer checkPackageType(Long appPackTypeId);
    /**
     * @Title: getAppPkgTypeByUserOrgId
     * @Description: 根据用户Id   读取该渠道包类型
     * @param userOrgId
     * @return: Map<String,Object>
     */
    @Transactional
    List<Map<String, Object>> getAppPkgTypeByUserOrgId(@Param("userOrgId") Long userOrgId);

}
