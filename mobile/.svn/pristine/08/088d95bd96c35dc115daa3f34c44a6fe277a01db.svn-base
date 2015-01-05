package com.jshuabo.mobile.server.service.batchinstall;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;

public interface IAppPackageInfoService extends IBaseService {

    @Transactional
    String page(Map<String, Object> params);

    /**
     * @Title: save
     * @Description: 保存
     * @param appPackageInfo
     * @return: void
     */
    @Transactional
    void save(AppPackageInfo appPackageInfo);
    
    /**
     * @Title: addDetail
     * @Description: 对包进行添加明细
     * @param packageInfoId
     * @param appInfoId
     * @return: void
     */
    @Transactional
    void addDetail(Long packageInfoId, Long appInfoId);

    /**
     * @Title: load
     * @Description: 查询
     * @param appPkgInfoId
     * @return: void
     */
    @Transactional(readOnly = true)
    AppPackageInfo load(Long appPkgInfoId);

    /**
     * @Title: update
     * @Description: 更新
     * @param appPackageInfo
     * @return: void
     */
    @Transactional
    void update(AppPackageInfo appPackageInfo);
    
    /**
     * @Title: queryByPackageId
     * @Description:pass packageId query belong to AppInfo List
     * @return
     * @return: List<AppInfo>
     */
    Map<String, Object> queryByPackageId(Map<String,Object> map);

    /**
     * @Title: deleteDetailById
     * @Description:  删除明细
     * @param detailId
     * @return: void
     */
    @Transactional
    String deleteDetailByPkgIdAndApkId(long apkPkgId, long apkId);
    
    /**
     * @Title: queryAppPackageNameByName
     * @Description:  查询应用包名称
     * @param appPackageName
     * @return: Integer
     */
    @Transactional
    Integer queryAppPackageNameByName(String appPackageName);

    /**
     * @Title: deleteByPackageId
     * @Description: 根据id 删除
     * @param appPkgInfoId
     * @return: void
     */
    @Transactional
    String deleteByPackageId(long appPkgInfoId);

}
