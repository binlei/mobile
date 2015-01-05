package com.jshuabo.mobile.server.web.controller.batchinstall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelBean;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.model.batchinstall.AppInstallLog;
import com.jshuabo.mobile.server.service.batchinstall.IAppInstallLogService;

/**
 * @ClassName: AppInstallLogController
 * @Description: 
 * @author: peng.wu
 * @date: 2014年6月2日 下午1:30:27
 */
@Controller
@RequestMapping("/appInstallLog")
public class AppInstallLogController {
    
    private static final Logger logger = LoggerFactory.getLogger(AppInstallLogController.class);

    @Autowired
    private IAppInstallLogService IAppInstallLogService;

    @RequestMapping("/list")
    public String appInstallLogList() {
        return "appInstallLog/list";
    }
    
    @RequestMapping("/installLogList")
    public String appInstallLogs() {
        return "appInstallLog/installLogList";
    }

    /**
     * 装机明细柱状图数据查询
     * 
     * @param params
     * @return
     */
    @RequestMapping(value = "/appStatistics", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Object>> appStatistics(@RequestBody Map<String, Object> params) {
        // 获取前台请求参数
        Map<String, Object> appMap = dealParamsForQuery(params);

        return IAppInstallLogService.appStatistics(appMap);

    }


    private Map<String, Object> dealParamsForQuery(Map<String, Object> params) {
        String[] reqList =
                {"model", "imei", "userName", "appPackageName", "appName", "organizationId",
                        "installStatus", "installStartTime", "installEndTime"};
        Map<String, Object> appMap = new HashMap<String, Object>();
        for (int i = 0; i < reqList.length; i++) {
            Object obj = params.get(reqList[i]);
            appMap.put(reqList[i], obj);
        }
        return appMap;
    }

    /**
     * 将list页面的数据导出excel
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/appDataExportToExcel", method = RequestMethod.GET)
    @ResponseBody
    public void appDataExportToExcel(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/msexcel;charset=UTF-8");
        // 获取前台请求参数
        String paramInfo = request.getParameter("param");
        @SuppressWarnings("unchecked")
		Map<String, Object> paramMap = (Map<String, Object>) JacksonUtils.json2map(paramInfo);

        List<AppInstallLog> list = IAppInstallLogService.appDataExportToExcel(paramMap);

        String title = "装机明细表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID", " 设备IMEI ", "品牌", "手机型号  ", "渠道", "操作员工号", " 安装包名称 ",
                        "  应用名称  ", "  装机时间   ", "   IP   ", "装机结果"};// 表头数组
        String[] fields =
                new String[] {"id", "imei", "bland", "model", "orgName", "userId",
                        "appPackageInfoName", "appName", "installTime", "ip", "installStatus"};// Role对象属性数组
        try {
            if (list.size() <= 50000) {
                TableData td =
                        ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders),
                                fields);
                JsGridReportBase report = new JsGridReportBase(request, response);

                report.exportToExcel(title, user.getName(), td);
            } else {
                ZipOutputStream zout = ExcelUtils.createZipStream(response, title); // 创建压缩输出流
                ExcelBean bean = new ExcelBean(title, user.getName(), list, hearders, fields);

                try {
                    JsGridReportBase report = new JsGridReportBase(request, response);
                    report.exportToExcel(zout, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    zout.close();// 关闭压缩输出流
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.debug("将list页面的数据导出excel 异常：[{}]",e.getLocalizedMessage());
        }

    }

    /**
     * 查询当前串号所安装的应用
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/showAppListByImei", method = RequestMethod.POST)
    @ResponseBody
    public Map appStatistsics(HttpServletRequest request) {
        // 获取前台请求参数
        String imei = request.getParameter("imei");
        System.out.println(imei);

        HashMap<String, String> map = new HashMap<String, String>();
        if (!StringUtils.isEmpty(imei)) {
            map.put("imei", imei);
            StringBuilder sb = new StringBuilder();
            List<Map> imeiList = IAppInstallLogService.queryAppListByImei(imei);
            for (Map info : imeiList) {
                sb.append(info.get("APP_NAME"));
                sb.append("    ");
            }
            map.put("listApp", sb.toString());
        }
        map.put("status", "SUCCESS");
        return map;

    }

    /**
     * 查询出没日的安装明细
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryDateData", method = RequestMethod.POST)
    @ResponseBody
    public List<Object> queryDateData(HttpServletRequest request) {
        // response.setContentType("application/msexcel;charset=UTF-8");
        // // 获取前台请求参数
        String dayNum = request.getParameter("dayNum");
        String paramInfo = request.getParameter("param");

        // 返回结果集
        List<Object> resultList = new ArrayList<Object>();

        if (StringUtils.isEmpty(dayNum)) {
            resultList.add("ERROR");
        } else {
            // 获取数据，并构建返回列表
            Map<String, Object> paramMap = (Map<String, Object>) JacksonUtils.json2map(paramInfo);
            paramMap.put("dayNum", dayNum);
            List<Map> dateDataList = IAppInstallLogService.queryDateData(paramMap);
            resultList.add("SUCCESS");
            resultList.add("软件预装" + dayNum + "报表");
            resultList.add("合计");
            resultList.add("本月合计");
            List<Object> tipList = new ArrayList<Object>();
            tipList.add("分类");
            tipList.add("品牌");
            tipList.add("型号");
            tipList.add("数量(台)");
            resultList.add(tipList);
            int total = 0;
            for (int i = 0; i < dateDataList.size(); i++) {
                List<Object> appList = new ArrayList<Object>();
                appList.add(dateDataList.get(i).get("ORG_NAME"));
                appList.add(dateDataList.get(i).get("BLAND"));
                appList.add(dateDataList.get(i).get("MODEL"));
                appList.add(dateDataList.get(i).get("AMOUNT"));
                if (null != dateDataList.get(i).get("AMOUNT")) {
                    Integer k = Integer.valueOf(dateDataList.get(i).get("AMOUNT").toString());
                    total += k;
                }
                resultList.add(appList);
            }
            resultList.set(2, total);
            Long monData = IAppInstallLogService.queryMonData(paramMap);
            resultList.set(3, monData);
        }
        return resultList;
    }


    /**
     * 将list页面的数据导出excel
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/dateDataExportToExcel", method = RequestMethod.GET)
    @ResponseBody
    public void dateDataExportToExcel(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/msexcel;charset=UTF-8");
        // 获取前台请求参数
        String param = request.getParameter("param");
        String[] sp = param.split("\\|");
        if (sp.length > 0) {
            List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
            for (int i = 4; i < sp.length; i++) {
                HashMap<String, Object> hm = new HashMap<String, Object>();
                String[] str = sp[i].split(",");
                hm.put("org", str[0]);
                hm.put("bland", str[1]);
                hm.put("model", str[2]);
                hm.put("count", str[3]);
                list.add(hm);
            }

            HashMap<String, Object> dayAll = new HashMap<String, Object>();
            dayAll.put("org", "合计");
            dayAll.put("count", sp[1]);
            list.add(dayAll);

            HashMap<String, Object> monAll = new HashMap<String, Object>();
            monAll.put("org", "本月合计");
            monAll.put("count", sp[2]);
            list.add(monAll);

            String title = sp[0];
            User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
            String[] hearders = new String[] {"   分类   ", "    品牌    ", "    型号    ", "数量(台)"};// 表头数组
            String[] fields = new String[] {"org", "bland", "model", "count"};// Role对象属性数组
            TableData td =
                    ExcelUtils
                            .createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
            JsGridReportBase report;
            try {
                report = new JsGridReportBase(request, response);
                report.exportToExcel(title, user.getName(), td);
            } catch (Exception e) {
                logger.debug("dateDataExportToExcel 异常：[{}]",e.getLocalizedMessage());
            }
        }
    }

    /**
     * @Title: exportExcel
     * @author: peng.wu
     * @date: 2014年6月18日 下午8:38:01
     * @Description: 导出数据
     */
    @RequestMapping(value = "/exportExcel",method=RequestMethod.POST)
    public void exportExcel(AppInstallLog log, HttpServletRequest request,HttpServletResponse response) {
//        Map<String, String[]> paramsMap = request.getParameterMap();
//        
//        Map<String, String> exprotMap = new HashMap<String, String>();
//        Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
//        for (Entry<String, String[]> entry : entrySet) {
//            exprotMap.put(entry.getKey(), entry.getValue()[0]);
//        }
        Map<String, Object> exprotMap = new HashMap<String, Object>();
        exprotMap.put("appName",request.getParameter("appName")); 
        exprotMap.put("model",request.getParameter("model")); 
        exprotMap.put("imei",request.getParameter("imei")); 
        exprotMap.put("userName",request.getParameter("userName")); 
        exprotMap.put("bland",request.getParameter("bland")); 
        exprotMap.put("appPackageName",request.getParameter("appPackageName")); 
        exprotMap.put("installStartTime",request.getParameter("installStartTime")); 
        exprotMap.put("installEndTime",request.getParameter("installEndTime")); 
        exprotMap.put("installStatus",request.getParameter("installStatus"));
        exprotMap.put("organizationId",request.getParameter("organizationId"));
        // 获得要导出的数据集
        IAppInstallLogService.exprot2Excel(exprotMap,response);
    }
    
    /**
     * @Title: exportExcelSuccess
     * @author: peng.wu
     * @date: 2014年6月18日 下午8:38:24
     * @Description: 导出数据处理
     */
    @RequestMapping(value = "/exportExcelSuccess",method=RequestMethod.POST)
    public void exportExcelSuccess(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> exprotMap = new HashMap<String, Object>();
        exprotMap.put("appName",request.getParameter("appName")); 
        exprotMap.put("model",request.getParameter("model")); 
        exprotMap.put("imei",request.getParameter("imei")); 
        exprotMap.put("userName",request.getParameter("userName")); 
        exprotMap.put("bland",request.getParameter("bland")); 
        exprotMap.put("appPackageName",request.getParameter("appPackageName")); 
        exprotMap.put("installStartTime",request.getParameter("installStartTime")); 
        exprotMap.put("installEndTime",request.getParameter("installEndTime")); 
        exprotMap.put("installStatus",request.getParameter("installStatus"));
        exprotMap.put("organizationId",request.getParameter("organizationId"));
        // 获得要导出的数据集
        IAppInstallLogService.exprotExcelSuccess(exprotMap,response);
    }
    
    /*jing.huang begin*/
        /*转页begin*/
    @RequestMapping(value = "/exceptionInstallStatics")
    public String exceptionInstallStatics() {
        return "exceptionInstallStatics/exceptionInstallMain";
    }
    @RequestMapping(value = "/day")
    public String day() {
        return "exceptionInstallStatics/day";
    }
    @RequestMapping(value = "/month")
    public String month() {
        return "exceptionInstallStatics/month";
    }
    @RequestMapping(value = "/season")
    public String season() {
        return "exceptionInstallStatics/season";
    }
    @RequestMapping(value = "/year")
    public String year() {
        return "exceptionInstallStatics/year";
    }
        /*转页end*/
    
        /*获取数据 begin*/
    @RequestMapping(value = "/dayExceptionInstall", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<Object>> dayExceptionInstall(@RequestBody Map<String, Object> params) {
        return IAppInstallLogService.dayExceptionInstall(params);
    }
    @RequestMapping(value = "/monthExceptionInstall", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<Object>> monthExceptionInstall(@RequestBody Map<String, Object> params) {
        return IAppInstallLogService.monthExceptionInstall(params);
    }
    @RequestMapping(value = "/seasonExceptionInstall", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<Object>> seasonExceptionInstall(@RequestBody Map<String, Object> params) {
        return IAppInstallLogService.seasonExceptionInstall(params);
    }
    @RequestMapping(value = "/yearExceptionInstall", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<Object>> yearExceptionInstall(@RequestBody Map<String, Object> params) {
        return IAppInstallLogService.yearExceptionInstall(params);
    }
        /*获取数据end*/
    
        /*导出数据begin*/
        /*导出数据end*/
    /*jing.huang end*/
}
