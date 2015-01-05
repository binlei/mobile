package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.dao.batchinstall.IAppPackageTypeMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageType;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageTypeService;

@Service("appPackageTypeService")
public class DefaultAppPackageTypeServiceImpl implements IAppPackageTypeService {

    @Autowired
    private IAppPackageTypeMapper appPackageTypeMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<AppPackageType> appPackageType = appPackageTypeMapper.page(params);
        Long total = appPackageTypeMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", appPackageType);

        return JacksonUtils.object2json(map);
    }

    @Override
    public void save(AppPackageType appPackageType) {
        appPackageType.setStatus(BaseStatus.ENABLED);
        appPackageTypeMapper.save(appPackageType);
    }

    @Override
    public AppPackageType load(int appPackId) {
        return appPackageTypeMapper.load(new Long(appPackId));
    }

    @Override
    public void update(AppPackageType appPackageType) {
        appPackageTypeMapper.update(appPackageType);
    }

    @Override
    public void delete(AppPackageType appPackageType) {
        appPackageType.setStatus(BaseStatus.DISABLED);
        appPackageTypeMapper.update(appPackageType);
    }

    @Override
    public List<AppPackageType> loadAll() {
        return appPackageTypeMapper.loadAll();
    }

    @Override
    public String searchPackageTypeNameIsPass(Long packageTypeId) {
        return appPackageTypeMapper.searchPackageTypeNameIsPass(packageTypeId);
    }

    @Override
    public String deleteByPackTypeId(Long appPackTypeId) {
        Integer result = appPackageTypeMapper.checkPackageType(appPackTypeId);
        if(result != ResultConstant.RESULTED){
            return ResultConstant.NOT_EMPTY;
        }else{
            result = appPackageTypeMapper.deleteById(appPackTypeId);
            if(result != null){
                return ResultConstant.SUCCESSED;
            }
        }
        return ResultConstant.UNAUDITED;
    }


}
