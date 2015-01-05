package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInfoMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageInfoDetailMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInfo;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageInfoDetail;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageInfoDetailService;

@Service("appPackageInfoDetailService")
public class DefaultAppPackageInfoDetailServiceImpl implements IAppPackageInfoDetailService {

    @Autowired
    private IAppPackageInfoDetailMapper appPackageInfoDetailMapper;
    
    @Autowired
    private IAppInfoMapper appInfoMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<AppPackageInfoDetail> appPackageInfoDetailList =
                appPackageInfoDetailMapper.page(params);
        Long total = appPackageInfoDetailMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", appPackageInfoDetailList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public String checkAppInfoRepetition(String appInfoId,String appPackageId) {
        String flag = appPackageInfoDetailMapper.checkAppInfoRepetition(new Long(appInfoId),new Long(appPackageId));
        if(flag == null){
          AppInfo appInfo = appInfoMapper.load(new Long(appInfoId));
          if(BaseStatus.DISABLED.equals(appInfo.getStatus())){
              return appInfo.getStatus();
          }
        }
       return flag;
    }

    @Override
    public String queryAppIsInPackageByAppId(long appInfoId) {
        String result = appPackageInfoDetailMapper.queryAppIsInPackageByAppId(appInfoId);
        if(StringUtils.isEmpty(result)){
            return ResultConstant.INEXISTENT;
        }
        return ResultConstant.EXIST;
    }

    @Override
    public String totalAppInfoByPkgId(long appInfoId) {
        int apks = appPackageInfoDetailMapper.totalAppInfoByPkgId(appInfoId);
        if(apks != ResultConstant.RESULTED){
            return ResultConstant.NOT_EMPTY;
        }
        return null;
    }
    
    

}
