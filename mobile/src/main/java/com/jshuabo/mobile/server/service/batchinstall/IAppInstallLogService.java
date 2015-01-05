package com.jshuabo.mobile.server.service.batchinstall;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;
import com.jshuabo.mobile.server.model.batchinstall.AppInstallLog;

public interface IAppInstallLogService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);
    
    @Transactional(readOnly = true)
    Map<String, List<Object>> appStatistics(Map<String,Object> params);

    @Transactional
    List<AppInstallLog> appDataExportToExcel(Map<String, Object> appMap);

    @Transactional
	List<Map> queryAppListByImei(String imei);

    @Transactional
	List<Map> queryDateData(Map<String, Object> paramMap);

	@Transactional(readOnly = true)
	Long queryMonData(Map<String, Object> paramMap);

	/**
	 * @Title: exprot2Excel
	 * @author: peng.wu
	 * @date: 2014年6月18日 下午8:38:51
	 * @Description: 
	 * @param exprotMap 数据源
	 */
	@Transactional
    void exprot2Excel(Map<String, Object> exprotMap,HttpServletResponse response);

	/**
	 * @Title: exprotExcelSuccess
	 * @author: peng.wu
	 * @date: 2014年6月18日 下午8:39:22
	 * @Description: 
	 * @param exprotMap 数据源
	 */
	@Transactional
    void exprotExcelSuccess(Map<String, Object> exprotMap, HttpServletResponse response); 
	
	/*jing.huang  begin*/
	/**
	 * @Title: dayExceptionInstall
	 * @author: jing.huang
	 * @Description: APP安装异常统计（按天）
	 * @param paramMap
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@Transactional(readOnly = true)
	Map<String, List<Object>> dayExceptionInstall(Map<String, Object> params);
	/**
	 * @Title: monthExceptionInstall
	 * @author: jing.huang
	 * @Description: APP安装异常统计（按月）
	 * @param paramMap
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@Transactional(readOnly = true)
	Map<String, List<Object>> monthExceptionInstall(Map<String, Object> params);
	/**
	 * @Title: seasonExceptionInstall
	 * @author: jing.huang
	 * @Description: APP安装异常统计（按季）
	 * @param paramMap
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@Transactional(readOnly = true)
	Map<String, List<Object>> seasonExceptionInstall(Map<String, Object> params);
	/**
	 * @Title: yearExceptionInstall
	 * @author: jing.huang
	 * @Description: APP安装异常统计（按年）
	 * @param paramMap
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@Transactional(readOnly = true)
	Map<String, List<Object>> yearExceptionInstall(Map<String, Object> params);
	/*jing.huang  end*/
}
