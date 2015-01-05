package com.jshuabo.mobile.server.service.batchinstall.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.dao.batchinstall.IAppInstallLogMapper;
import com.jshuabo.mobile.server.model.batchinstall.AppInstallLog;
import com.jshuabo.mobile.server.service.batchinstall.IAppInstallLogService;

@Service("appInstallLogService")
public class DefaultAppInstallLogServiceImpl implements IAppInstallLogService {
    private static final Logger logger = LoggerFactory
            .getLogger(DefaultAppInstallLogServiceImpl.class);
    @Autowired
    private IAppInstallLogMapper appInstallLogMapper;

    @Override
    public String page(Map<String, Object> params) {
        List<AppInstallLog> result = appInstallLogMapper.page(dataHandle(params));
        Long total = appInstallLogMapper.total(params);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", result);

        return JacksonUtils.object2json(map);
    }
    
    /**
     * @Title: dataHandle
     * @author: peng.wu
     * @date: 2014年7月5日 上午8:52:44
     * @Description: 
     * @param params  
     * @return: Map<String,Object>
     */
    private Map<String,Object> dataHandle(Map<String,Object> params){
    	User user = (User) SecurityUtils.getSubject().getPrincipal();
        Long orgId = user.getOrganization().getId();
        List<Long> list = new ArrayList<Long>();
        if (params.get("organizationId") != null) {
            String[] str = ((String) params.get("organizationId")).split(",");
            if (str.length > 1) {
                for (int i = 0; i < str.length; i++) {
                    list.add(new Long(str[i]));
                }
                params.put("orgIds", list);
                params.put("organizationId", null);
            } 
        }else{
        	 params.put("organizationId", orgId);
        }
        	
        return params;
    }

    @Override
    public Map<String, List<Object>> appStatistics(Map<String, Object> params) {

        List<Map> appStatisticsTest = appInstallLogMapper.appStatisticsTest(dataHandle(params));

        // 轴显示数据
        List<Object> xName = new ArrayList<Object>();
        // 轴显示数据
        List<Object> yData = new ArrayList<Object>();
        for (int i = 0; i < appStatisticsTest.size(); i++) {
            xName.add(appStatisticsTest.get(i).get("yu"));
            yData.add(appStatisticsTest.get(i).get("count"));
        }

        // name统计内容，目前只统计总的装机量
        // child统计个内容的数据
        List<Object> name = new ArrayList<Object>();
        List<Object> child = new ArrayList<Object>();
        child.add("装机量");
        child.add(yData);
        name.add(child);

        Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        map.put("xName", xName);
        map.put("name", name);

        return map;

    }

    @Override
    public List<AppInstallLog> appDataExportToExcel(Map<String, Object> params) {
        List<AppInstallLog> result = appInstallLogMapper.queryAll(dataHandle(params));
        return result;
    }

    @Override
    public List<Map> queryAppListByImei(String imei) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("imei", imei);
        List<Map> appListByImei = appInstallLogMapper.queryAppListByImei(map);
        return appListByImei;
    }

    @Override
    public List<Map> queryDateData(Map<String, Object> params) {
        List<Map> dateDataList = appInstallLogMapper.queryDateData(dataHandle(params));
        return dateDataList;
    }

    @Override
    public Long queryMonData(Map<String, Object> params) {
        Long queryMonData = appInstallLogMapper.queryMonData(params);
        return queryMonData;
    }

    /**
     * @Title: setCellStyle
     * @author: peng.wu
     * @date: 2014年6月18日 下午8:48:22
     * @Description: 设置样式
     */
    private CellStyle[] setCellStyle(Workbook wb) {
        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();
        // DataFormat df = wb.createDataFormat();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.RED.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());
        f2.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 设置第一种单元格的样式
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        // cs.setDataFormat(df.getFormat("#,##0.0"));

        // 设置第二种单元格的样式
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        // cs2.setDataFormat(df.getFormat("text"));
        return new CellStyle[] {cs, cs2};
    }

    /**
     * @Title: setHeard
     * @author: peng.wu
     * @date: 2014年6月18日 下午8:39:55
     * @Description: 设置标题
     */
    private void setHeard(CellStyle[] cs, Sheet sh, Row row, Cell cell) {
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for (int i = 0; i < 10; i++) {
            sh.setColumnWidth((short) i, (short) (35.7 * 120));
        }
        String[] title =
                new String[] {"设备IMEI","设备号", "品牌", "手机型号  ", "渠道", "操作员工号", "安装包名称 ", "应用名称", "装机时间   ",
                        "IP", "装机结果"};
        for (int i = 0; i < title.length; i++) {
            // 创建列（每行里的单元格）
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(cs[0]);
        }
    }

    @Override
    public void exprot2Excel(Map<String, Object> exprotMap, HttpServletResponse response) {
        
    	Map<String, Object> pageData = appInstallLogMapper.exprotPageData(dataHandle(exprotMap));

        SXSSFWorkbook wb = new SXSSFWorkbook(200000); // keep 100 rows in memory, exceeding rows

        int flag = 1;       // 标记
        int rowCount = 150000; // 每个sheet 显示行数
        int cellCount = 11; // 显示10 列
        
        long count = (Long) pageData.get("COUNT");
        long pageSize = rowCount; // 每页大小
        long page = 1;
        if(rowCount < count){
            if (count % pageSize == 0) {} else {
                page = count / pageSize + 1;
            } // 页数
        }

        try {
                // 设置字体和单元格样式
                CellStyle[] cs = setCellStyle(wb);
                // flushed to disk 创建第一个sheet（页），并命名
                String sheetName = "装机明细";      // shett / 文件名称
                Sheet sh = wb.createSheet(sheetName + System.currentTimeMillis());
                // 创建第一行
                Row row = sh.createRow((short) 0);
                Cell cell = null;
                setHeard(cs, sh, row, cell); // 设置样式
            for (int i = 1; i <= page; i++) {
                long offset = (i - 1) * pageSize;
                long rows = pageSize;
                exprotMap.put("offset", Long.valueOf(offset));
                exprotMap.put("rows", Long.valueOf(rows));
                // 获得要导出的数据集
                List<AppInstallLog> logs = appInstallLogMapper.exprot2Excel(exprotMap);
                if (logs.isEmpty()) {
                    PrintWriter write;
                    try {
                        write = response.getWriter();
                        write.println("<html>");
                        write.println("<head><title>导出</title></head>");
                        write.println("<body bgcolor=\"#ffffff\">");
                        write.println("<script>alert('对不起，暂时没有数据！');window.close();</script>");
                        write.println("<script>window.location.href='list';</script>");
                        write.println("</body></html>");
                        return;
                    } catch (IOException e) {
                        logger.debug("exportExcel Writer Exception: [{}]", e.getLocalizedMessage());
                    }
                }
                for (int rownum = 0; rownum < logs.size(); rownum++) {
                    String[] str =
                            new String[] {logs.get(rownum).getImei(),logs.get(rownum).getDevSerial(), logs.get(rownum).getBland(),
                                    logs.get(rownum).getModel(), logs.get(rownum).getOrgName(),
                                    logs.get(rownum).getUserName(),
                                    logs.get(rownum).getAppPackageInfoName(),
                                    logs.get(rownum).getAppName(),
                                    logs.get(rownum).getInstallTime(), logs.get(rownum).getIp(),
                                    "1".equals(logs.get(rownum).getInstallStatus()) ? "成功" : "失败"};
                    // 小于 每个sheet 最大值
                    if (flag <= rowCount) {
                        row = sh.createRow(flag);
                        for (int cellnum = 0; cellnum < cellCount; cellnum++) {
                            for (int j = 0; j < str.length; j++) {
                                cell = row.createCell(j);
                                cell.setCellValue(str[j]);
                                cell.setCellStyle(cs[1]);
                            }
                        }
                        flag++;
                    }
                    // 大于 没个sheet 最大值
                    if (flag > rowCount) {
                        flag = 1;
                        sh = wb.createSheet(sheetName + System.currentTimeMillis());
                        row = sh.createRow((short) 0);
                        setHeard(cs, sh, row, cell);
                        row = sh.createRow(flag);
                        for (int cellnum = 0; cellnum < 10; cellnum++) {
                            for (int j = 0; j < str.length; j++) {
                                cell = row.createCell(j);
                                cell.setCellValue(str[j]);
                                cell.setCellStyle(cs[1]);
                            }
                        }
                    }
                }
            }
            String targetFileName = sheetName+".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String
                    .valueOf(URLEncoder.encode(targetFileName, "UTF-8"))));
            // response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel");

            wb.write(response.getOutputStream());
        } catch (IOException e) {
            logger.debug("exportExcel IOException: [{}]", e.getLocalizedMessage());
        }
    }

    @Override
    public void exprotExcelSuccess(Map<String, Object> exprotMap, HttpServletResponse response) {
    	
        Map<String, Object> pageData = appInstallLogMapper.exprotPageData(dataHandle(exprotMap));

        SXSSFWorkbook wb = new SXSSFWorkbook(200000); // keep 100 rows in memory, exceeding rows

        int flag = 1;       // 标记
        int rowCount = 150000; // 每个sheet 显示行数
        int cellCount = 11; // 显示10 列
        
        long count = (Long) pageData.get("COUNT");
        long pageSize = rowCount; // 每页大小
        long page = 1;
        if(rowCount < count){
            if(count % pageSize == 0){}else{
                page = count / pageSize + 1; // 页数
            }
        }

        try {
                // 设置字体和单元格样式
                CellStyle[] cs = setCellStyle(wb);
                // flushed to disk 创建第一个sheet（页），并命名
                String sheetName = "装机明细";      // shett / 文件名称
                Sheet sh = wb.createSheet(sheetName + System.currentTimeMillis());
                // 创建第一行
                Row row = sh.createRow((short) 0);
                Cell cell = null;
                setHeard(cs, sh, row, cell); // 设置样式
            for (int i = 1; i <= page; i++) {
                long offset = (i - 1) * pageSize;
                long rows = i * pageSize;
                exprotMap.put("offset", Long.valueOf(offset));
                exprotMap.put("rows", Long.valueOf(rows));
                // 获得要导出的数据集
                List<AppInstallLog> logs = appInstallLogMapper.exprot2Excel(exprotMap);
                if (logs.isEmpty()) {
                    PrintWriter write;
                    try {
                        write = response.getWriter();
                        write.println("<html>");
                        write.println("<head><title>导出</title></head>");
                        write.println("<body bgcolor=\"#ffffff\">");
                        write.println("<script>alert('对不起，暂时没有数据！');window.close();</script>");
                        write.println("<script>window.location.href='list';</script>");
                        write.println("</body></html>");
                        return;
                    } catch (IOException e) {
                        logger.debug("exportExcel Writer Exception: [{}]", e.getLocalizedMessage());
                    }
                }
                for (int rownum = 0; rownum < logs.size(); rownum++) {
                    String[] str =
                            new String[] {logs.get(rownum).getImei(),logs.get(rownum).getDevSerial(), logs.get(rownum).getBland(),
                                    logs.get(rownum).getModel(), logs.get(rownum).getOrgName(),
                                    logs.get(rownum).getUserName(),
                                    logs.get(rownum).getAppPackageInfoName(),
                                    logs.get(rownum).getAppName(),
                                    logs.get(rownum).getInstallTime(), logs.get(rownum).getIp(),"成功"};      // TODO 处理数据 /其他渠道显示 成功
                    // 小于 每个sheet 最大值
                    if (flag <= rowCount) {
                        row = sh.createRow(flag);
                        for (int cellnum = 0; cellnum < cellCount; cellnum++) {
                            for (int j = 0; j < str.length; j++) {
                                cell = row.createCell(j);
                                cell.setCellValue(str[j]);
                                cell.setCellStyle(cs[1]);
                            }
                        }
                        flag++;
                    }
                    // 大于 每个sheet 最大值
                    if (flag > rowCount) {
                        flag = 1;
                        sh = wb.createSheet(sheetName + System.currentTimeMillis());
                        row = sh.createRow((short) 0);
                        setHeard(cs, sh, row, cell);
                        row = sh.createRow(flag);
                        for (int cellnum = 0; cellnum < 10; cellnum++) {
                            for (int j = 0; j < str.length; j++) {
                                cell = row.createCell(j);
                                cell.setCellValue(str[j]);
                                cell.setCellStyle(cs[1]);
                            }
                        }
                    }
                }
            }
            String targetFileName = sheetName+".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(targetFileName, "UTF-8"))));
            // response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel");

            wb.write(response.getOutputStream());
        } catch (IOException e) {
            logger.debug("exportExcel IOException: [{}]", e.getLocalizedMessage());
        }
    }

    
    /*jing.huang  begin*/
    public Map<String, List<Object>> exceptionInstallUtil(List<ChartEntity> installTotalData,List<ChartEntity> installImeiNullData,List<ChartEntity> installFailData) {
        Map<String, List<Object>> resultMap = new HashMap<String, List<Object>>();
        List<Object> installTimeList = new ArrayList<Object>();
        List<Object> installTotalList = new ArrayList<Object>();
        List<Object> imeiNullList = new ArrayList<Object>();
        List<Object> installFailList = new ArrayList<Object>();
        
        if(installTotalData != null && !installTotalData.isEmpty()) {
            for(int i = 0;i<installTotalData.size();i++) {
                installTimeList.add(installTotalData.get(i).getxAxis());
                installTotalList.add(installTotalData.get(i).getyData());
                Long aa = 0l;
                if(installImeiNullData != null && !installImeiNullData.isEmpty()) {
                    for(int j = 0;j<installImeiNullData.size();j++) {
                        if(installImeiNullData.get(j).getxAxis().equals(installTotalData.get(i).getxAxis())) {
                            aa = installImeiNullData.get(j).getyData();
                            break;
                        }
                    }
                } 
                imeiNullList.add(aa);
                Long bb = 0l;
                if(installFailData != null && !installFailData.isEmpty()) {
                    for(int z = 0;z<installFailData.size();z++) {
                        if(installFailData.get(z).getxAxis().equals(installTotalData.get(i).getxAxis())) {
                            bb = installFailData.get(z).getyData();
                        }
                    }
                }
                installFailList.add(bb);
            }
        }
        resultMap.put("installTime", installTimeList);
        resultMap.put("installTotal", installTotalList);
        resultMap.put("imeiNull", imeiNullList);
        resultMap.put("installFail", installFailList);
        
        return resultMap;
    }
    
    public void processChannel(Map<String, Object> params,String key) {
        // TODO Auto-generated method stub
        String value = (String) params.get(key); 
        if(value != null) {
            String[] valueArray = value.split(",");
            List<String> valueList = new ArrayList<String>();
            for(String e : valueArray) {
                valueList.add(e);
            }
            params.remove(key);
            params.put(key, valueList);
        }
    }
    
    @Override
    public Map<String, List<Object>> dayExceptionInstall(Map<String, Object> params) {
        // TODO Auto-generated method stub
        processChannel(params,"org_id");
        
        List<ChartEntity> dayInstallTotalData = appInstallLogMapper.dayInstallTotal(params);
        List<ChartEntity> dayInstallImeiNullData = appInstallLogMapper.dayInstallImeiNull(params);
        List<ChartEntity> dayInstallFailData = appInstallLogMapper.dayInstallFail(params);
        
        return exceptionInstallUtil(dayInstallTotalData,dayInstallImeiNullData,dayInstallFailData);
    }

    @Override
    public Map<String, List<Object>> monthExceptionInstall(Map<String, Object> params) {
        // TODO Auto-generated method stub
        processChannel(params,"org_id");
        
        List<ChartEntity> monthInstallTotalData = appInstallLogMapper.monthInstallTotal(params);
        List<ChartEntity> monthInstallImeiNullData = appInstallLogMapper.monthInstallImeiNull(params);
        List<ChartEntity> monthInstallFailData = appInstallLogMapper.monthInstallFail(params);
        
        return exceptionInstallUtil(monthInstallTotalData,monthInstallImeiNullData,monthInstallFailData);
    }

    @Override
    public Map<String, List<Object>> seasonExceptionInstall(Map<String, Object> params) {
        // TODO Auto-generated method stub
        processChannel(params,"org_id");
        
        List<ChartEntity> seasonInstallTotalData = appInstallLogMapper.seasonInstallTotal(params);
        List<ChartEntity> seasonInstallImeiNullData = appInstallLogMapper.seasonInstallImeiNull(params);
        List<ChartEntity> seasonInstallFailData = appInstallLogMapper.seasonInstallFail(params);
        
        return exceptionInstallUtil(seasonInstallTotalData,seasonInstallImeiNullData,seasonInstallFailData);
    }

    @Override
    public Map<String, List<Object>> yearExceptionInstall(Map<String, Object> params) {
        // TODO Auto-generated method stub
        processChannel(params,"org_id");
        
        List<ChartEntity> yearInstallTotalData = appInstallLogMapper.yearInstallTotal(params);
        List<ChartEntity> yearInstallImeiNullData = appInstallLogMapper.yearInstallImeiNull(params);
        List<ChartEntity> yearInstallFailData = appInstallLogMapper.yearInstallFail(params);
        
        return exceptionInstallUtil(yearInstallTotalData,yearInstallImeiNullData,yearInstallFailData);
    }
    /*jing.huang  end*/
}
