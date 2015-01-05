package com.jshuabo.mobile.server.service.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;

public interface IAppInfoService extends IBaseService {

    /**
     * @Title: page
     * @Description: 分页
     * @param params
     * @return: String
     */
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    /**
     * @Title: save
     * @Description: 添加
     * @param appInfo
     * @return: void
     */
    @Transactional
    void save(AppInfo appInfo);

    /**
     * @Title: load
     * @Description:
     * @param appId
     * @return: void
     */
    @Transactional(readOnly = true)
    AppInfo load(Long appId);

    /**
     * @Title: update
     * @Description: 更新
     * @param appInfo
     * @return: void
     */
    @Transactional
    void update(AppInfo appInfo);

    /**
     * @Title: loadAll
     * @Description: 查询所有
     * @return
     * @return: List<AppInfo>
     */
    @Transactional
    List<AppInfo> loadAll();
    
    /**
     * @Title: audited
     * @Description:  审核app
     * @return: void
     */
    @Transactional
    void audited(String appId);
    
    /**
     * @Title: queryAppByTypeId
     * @Description: 查询 类型下的 app
     * @param appTypeId
     * @return: Integer
     */
    @Transactional(readOnly = true)
    Integer queryAppByTypeId(Long appTypeId);

    /**
     * @Title: searchAppByName
     * @Description: 
     * @param appName
     * @return
     * @return: int
     */
    @Transactional
    int searchAppByName(String appName);

	/**
	 * @Title: delete
	 * @Description: 删除应用
	 * @param appInfo
	 * @return: void
	 */
    @Transactional
	Integer delete(AppInfo appInfo);

    /**
     * @Title: queryAppNamesByOrgId
     * @Description:  根据组织id 查看appInfo name 
     * @param oagId 
     * @return
     * @return: List<AppInfo>
     */
    @Transactional
    List<AppInfo> queryAppNamesByOrgId(Long orgId);

    /**
     * @Title: createPackageInfoFile
     * @Description:  生成tfp 返回文件 
     * @param oagId 
     * @return
     * @return: result
     */
    @Transactional
	String createPackageInfoFile(Long orgId);

}
