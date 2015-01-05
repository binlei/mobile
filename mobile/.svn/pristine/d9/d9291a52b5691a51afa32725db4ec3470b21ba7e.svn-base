package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;

public interface IAppInfoMapper extends IBaseMapper<AppInfo> {

    /**
     * @Title: page
     * @Description: 分页查询
     * @param params
     * @return
     * @return: List<AppInfo>
     */
    @Transactional(readOnly=true)
    List<AppInfo> page(Map<String, Object> params);

    /**
     * @Title: total
     * @Description: 查询总数量
     * @param params
     * @return
     * @return: Long
     */
    @Transactional(readOnly=true)
    Long total(Map<String, Object> params);

    /**
     * @Title: auditedPass
     * @Description: 审核通过
     * @param appId
     * @return: void
     */
    @Transactional
    void auditedPass(Long appId);
    
    /**
     * @Title: queryAppByTypeId
     * @Description: 查询 类型下的 app
     * @param appTypeId
     * @return: Integer
     */
    @Transactional
    Integer queryAppByTypeId(Long appTypeId);

    /**
     * @Title: searchAppByName
     * @Description: 查询 类型下的 app名
     * @param appName
     * @return
     * @return: int
     */
    @Transactional
    int searchAppByName(String appName);

    /**
     * @Title: queryAppNamesByOrgId
     * @Description: 根据组织Id 查询apk 
     * @param orgId
     * @return
     * @return: List<AppInfo>
     */
    @Transactional
    List<AppInfo> queryAppNamesByOrgId(@Param("orgId")Long orgId,@Param("imagePath")String imagePath);
    
}
