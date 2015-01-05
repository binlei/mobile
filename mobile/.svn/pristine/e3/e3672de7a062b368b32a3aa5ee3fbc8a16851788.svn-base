/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobileArrivalController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.controller.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:09:40
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.web.controller.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelBean;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;
import com.jshuabo.mobile.server.model.mobile.MobileArrival;
import com.jshuabo.mobile.server.service.mobile.IMobileArrivalService;

/**
 * @ClassName: MobileArrivalController
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:09:40
 */
@Controller
@RequestMapping("/mobileArrival")
public class MobileArrivalController {
    @Autowired
    private IMobileArrivalService mobileArrivalService;

    @RequestMapping("/list")
    public String list() {
        return "mobileArrival/list";
    }

    // 弹出导出窗口
    @RequestMapping("/limitRecords")
    public String limitRecords() {
        return "common/limitRecords";
    }


    // 普通Excel导出查询结果，获取的数据格式是List<JavaBean>
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/msexcel;charset=UTF-8");

        List<MobileArrival> list = new ArrayList<MobileArrival>();

        String ids = request.getParameter("ids");

        if ("".equals(ids)) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            Map<String, Object> map = new HashMap<String, Object>();
            Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
            for (Entry<String, String[]> entry : entrySet) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }

            list = mobileArrivalService.exportAll(map);// 获取数据
        } else {
            List<Long> idList = new ArrayList<Long>();
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                idList.add(Long.parseLong(id));
            }
            list = mobileArrivalService.exportSelections(idList);// 获取数据
        }

        String title = "手机到达表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID","设备IMEI", "用户IMSI", "上传日期", "到达时间", "渠道", "网络运营商", "手机号", "到达类型", "IP地址", "系统版本号"};// 表头数组
        String[] fields =
                new String[] {"id","imei", "imsi", "uploadTime", "arrivalTime", "extendProp5",
                        "simOperator", "phoneNum", "kind", "extendProp1", "extendProp2"};// Role对象属性数组
        if(list.size()<=50000) {
            TableData td =
                    ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
            JsGridReportBase report = new JsGridReportBase(request, response);
            report.exportToExcel(title, user.getName(), td);
        } else{
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
    }
    //日到达数据
    @RequestMapping(value = "/dayArrival", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayArrival(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.dayArrival(params);
    }
    
    //日到达数据Top N
    @RequestMapping(value = "/dayArrivalTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayArrivalTop(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.dayArrivalTop(params);
    }
    
    //月到达数据
    @RequestMapping(value = "/monthArrival", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthArrival(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.monthArrival(params);
    }
    
    //月到达数据Top N
    @RequestMapping(value = "/monthArrivalTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthArrivalTop(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.monthArrivalTop(params);
    }
    
    //季到达数据
    @RequestMapping(value = "/seasonArrival", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonArrival(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.seasonArrival(params);
    }
    
    //季到达数据Top N
    @RequestMapping(value = "/seasonArrivalTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonArrivalTop(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.seasonArrivalTop(params);
    }
    
    //年到达数据
    @RequestMapping(value = "/yearArrival", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearArrival(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.yearArrival(params);
    }
    
    //年到达数据Top N
    @RequestMapping(value = "/yearArrivalTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearArrivalTop(@RequestBody Map<String, Object> params) {
        return mobileArrivalService.yearArrivalTop(params);
    }
    
}
