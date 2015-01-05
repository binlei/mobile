package com.jshuabo.mobile.server.service.batchinstall;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;

public interface IAppPackageInfoDetailService extends IBaseService {

    /**
     * @Title: page
     * @Description: 分页
     * @param params
     * @return: String
     */
    @Transactional(readOnly = true)
    String page(Map<String, Object> params);

    /**
     * @Title: checkAppInfoRepetition
     * @Description: 判断是否相同的apk
     * @param appInfoId
     * @return: String
     */
    @Transactional
    String checkAppInfoRepetition(String appInfoId,String appPackageId);

    /**
     * @Title: queryAppIsInPackageByAppId
     * @Description: 
     * @param appInfoId
     * @return
     * @return: String
     */
    @Transactional
    String queryAppIsInPackageByAppId(long appInfoId);
    
    /**
     * @Title: totalAppInfoByPkgId
     * @Description: package info is empty
     * @param appInfoId
     * @return: int
     */
    @Transactional
    String totalAppInfoByPkgId(long appInfoId);
}
