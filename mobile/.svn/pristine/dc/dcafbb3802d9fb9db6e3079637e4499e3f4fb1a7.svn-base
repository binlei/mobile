package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInfoMapper;
import com.jshuabo.mobile.server.dao.batchinstall.IAppTypeMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppType;
import com.jshuabo.mobile.server.service.batchinstall.IAppTypeService;

@Service("appTypeService")
public class DefaultAppTypeServiceImpl implements IAppTypeService {
    
    @Autowired
    private IAppTypeMapper appTypeMapper;
    
    @Autowired
    private IAppInfoMapper appInfoMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<AppType> appTypeList = appTypeMapper.page(params);
        Long total = appTypeMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", appTypeList);

        return JacksonUtils.object2json(map);
    }

    @Override
    public List<AppType> loadAll() {
        return appTypeMapper.loadAll();
    }

    @Override
    public AppType load(Long appTypeId) {
        return appTypeMapper.load(appTypeId);
    }


    @Override
    public void save(AppType appType) {
        appTypeMapper.save(appType);
    }

    @Override
    public void update(AppType appType) {
        appTypeMapper.update(appType);
    }

    @Override
    public String searchAppTypeIsPass(Long appTypeId) {
        return appTypeMapper.searchAppTypeIsPass(appTypeId);
    }

    /* (non Javadoc)
     * @Title: searchAppTypeByName
     * @Description: 
     * @param appTypeName
     * @return
     * @see com.jshuabo.mobile.server.service.batchinstall.IAppTypeService#searchAppTypeByName(java.lang.String)
     */
    @Override
    public int searchAppTypeByName(String appTypeName) {
        return appTypeMapper.searchAppTypeByName(appTypeName);
    }

    @Override
    public String deleteById(Long appTypeId) {
        int result = appInfoMapper.queryAppByTypeId(appTypeId);
        if (result != ResultConstant.RESULTED) {
            return ResultConstant.NOT_EMPTY;
        }else{
           int flag = appTypeMapper.deleteById(appTypeId);
           if(flag != ResultConstant.RESULTED){
               return ResultConstant.SUCCESSED;
           }
        }
        return null;
    }
}
