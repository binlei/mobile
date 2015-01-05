package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;

public interface IAppPackageInfoMapper extends IBaseMapper<AppPackageInfo> {

    /**
     * @Title: page
     * @Description: 分页
     * @param params
     * @return: List<AppPackageInfo>
     */
    @Transactional(readOnly=true)
    List<AppPackageInfo> page(Map<String, Object> params);

    /**
     * @Title: total
     * @Description: 总数量
     * @param params
     * @return: Long
     */
    @Transactional(readOnly=true)
    Long total(Map<String, Object> params);
    
    /**
     * @Title: updateAppQuantity
     * @Description:  更新安装包app数量
     * @return: void
     */
    @Transactional
    void updateQty(AppPackageInfo packageInfo);

    /**
     * @Title: queryAppPackageNameByName
     * @Description:  查询应用包名称
     * @param appPackageName
     * @return: Integer
     */
    @Transactional
    Integer queryAppPackageNameByName(String appPackageName);

    /**
     * @Title: updateAppByPackageId
     * @Description: 更新appPackage 数量
     * @param id 
     * @return: void
     */
    @Transactional
    void updateAppByPackageId(); 
    
    /**
     * @Title: deleteByPackageId
     * @Description: 根据id 删除
     * @param appPkgInfoId
     * @return: void
     */
    @Transactional
    Integer deleteByPackageId(long appPkgInfoId);
    
    /**
     * @Title: queryAppPgkInfoByPgkTypeId
     * @Description:  根据包类型ID 查询包
     * @param pgkId
     * @return: List<AppPackageInfo>
     */
    @Transactional
    List<Map<String,Object>> queryAppPgkInfoByPgkTypeId(Long pgkId,Long orgId);
    
    /**
     * @Title: queryAppInfoByPgkId
     * @Description: 查询包中的APK
     * @param pgkId
     * @return
     * @return: List<Map<String,Object>>
     */
    @Transactional
    List<Map<String,Object>> queryAppInfoByPgkId(Long pgkId);
    
}