package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.mobile.server.model.batchinstall.AppInstallLog;

public interface IAppInstallLogMapper extends IBaseMapper<AppInstallLog> {

    @Transactional(readOnly=true)
    List<AppInstallLog> page(Map<String, Object> params);

    @Transactional(readOnly=true)
    Long total(Map<String, Object> params);

    @Transactional(readOnly=true)
	List<Map> appStatisticsTest(Map<String, Object> params);
    
    @Transactional(readOnly=true)
    List<AppInstallLog> queryAll(Map<String, Object> params);
    
    @Transactional(readOnly=true)
	List<Map> queryAppListByImei(Map<String, Object> map);

    @Transactional(readOnly=true)
	List<Map> queryDateData(Map<String, Object> paramMap);

    @Transactional(readOnly=true)
    Long queryMonData(Map<String, Object> paramMap);

    @Transactional(readOnly=true)
    List<AppInstallLog> exprot2Excel(Map<String,Object> exprotMap);

    @Transactional
    List<AppInstallLog> exprotExcelSuccess(Map<String, Object> exprotMap);

    @Transactional
    Map<String,Object> exprotPageData(Map<String, Object> exprotMap);
    
    
    /*jing.huang  begin*/
    //按天统计
        //APP安装总数
    @Transactional(readOnly = true)
    List<ChartEntity> dayInstallTotal(Map<String, Object> params);
        //IMEI为空的记录数
    @Transactional(readOnly = true)
    List<ChartEntity> dayInstallImeiNull(Map<String, Object> params);
        //安装失败的记录数
    @Transactional(readOnly = true)
    List<ChartEntity> dayInstallFail(Map<String, Object> params);
    
    //按月统计
    @Transactional(readOnly = true)
    List<ChartEntity> monthInstallTotal(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> monthInstallImeiNull(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> monthInstallFail(Map<String, Object> params);
    
    //按季统计
    @Transactional(readOnly = true)
    List<ChartEntity> seasonInstallTotal(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> seasonInstallImeiNull(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> seasonInstallFail(Map<String, Object> params);
    
    //按年统计
    @Transactional(readOnly = true)
    List<ChartEntity> yearInstallTotal(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> yearInstallImeiNull(Map<String, Object> params);
    @Transactional(readOnly = true)
    List<ChartEntity> yearInstallFail(Map<String, Object> params);
    /*jing.huang  end*/
    
}
