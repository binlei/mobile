package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfo;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfoDetail;

public interface IAppPackageInfoDetailMapper extends IBaseMapper<AppPackageInfoDetail> {

    /**
     * @Title: page
     * @Description: 分页
     * @param params
     * @return: List<AppPackageInfoDetail>
     */
    @Transactional(readOnly = true)
    List<AppPackageInfoDetail> page(Map<String, Object> params);

    /**
     * @Title: total
     * @Description: 总数量
     * @param params
     * @return: Long
     */
    @Transactional(readOnly = true)
    Long total(Map<String, Object> params);

    /**
     * @Title: queryByPackageId
     * @Description: 查询包中的APK
     * @param packageId
     * @return: List<AppInfo>
     */
    @Transactional
    List<String> queryByPackageId(Map<String,Object> map);

    /**
     * @Title: checkAppInfoRepetition
     * @Description: 检查同一个包中有相同APK
     * @param appInfoId
     * @return: void
     */
    @Transactional
    String checkAppInfoRepetition(@Param(value = "appInfoId") Long appInfoId,@Param(value = "appPackageId") Long appPackageId);

    /**
     * @Title: queryDetail
     * @Description: 查询应用包中的明细
     * @return: List<AppPackageInfoDetail>
     */
    @Transactional
    Set<AppPackageInfoDetail> queryDetail(Long appPackageId);

    /**
     * @Title: deleteByAppIdPackageId
     * @Description:
     * @param detail
     * @return: void
     */
    @Transactional
    void deleteByAppIdPackageId(AppPackageInfoDetail detail);

    /**
     * @Title: totalAppInfoByPkgId
     * @Description: 获取app明细数量 
     * @param integer
     * @return: int
     */
    @Transactional
    int totalAppInfoByPkgId(Long appPkgInfoId);

    /**
     * @Title: queryAppIsInPackageByAppId
     * @Description: 包中是否包含该app
     * @param appInfoId
     * @return
     * @return: String
     */
    @Transactional
    String queryAppIsInPackageByAppId(long appInfoId);

    /**
     * @Title: queryAppInfoByPgkId
     * @Description: 查询包中的APK
     * @param pgkId
     * @return
     * @return: List<Map<String,Object>>
     */
    @Transactional
    List<Map<String,Object>> queryAppInfoByPgkId(Long pgkId);

    @Transactional
    AppPackageInfoDetail loadByPkgIdAndApkId(@Param("apkPkgId")long apkPkgId, @Param("apkId")long apkId);
    
    @Transactional
    List<AppPackageInfo> queryPackageByApkId(Long apkId);

}
