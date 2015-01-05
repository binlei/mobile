/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: AppActivatedController.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.web.controller.chart
* @author: jing.huang
* @date: 2014年5月8日 上午11:55:38
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.web.controller.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.model.base.ChartEntity;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;
import com.jshuabo.mobile.server.service.mobile.IMobileActivatedInfoService;

/**
 * @ClassName: AppActivatedController
 * @Description: 
 * @author: jing.huang
 * @date: 2014年5月8日 上午11:55:38
 */
@Controller
@RequestMapping(value = "/appActivated")
public class AppActivatedController {
    @Autowired
    private IMobileActivatedInfoService mobileActivatedInfoService;
    
    @RequestMapping(value = "/day")
    public String day() {
        return "channelStatics/appActivated/day";
    }
    
    @RequestMapping(value = "/week")
    public String week() {
        return "channelStatics/appActivated/week";
    }
    
    @RequestMapping(value = "/month")
    public String month() {
        return "channelStatics/appActivated/month";
    }
    
    @RequestMapping(value = "/season")
    public String season() {
        return "channelStatics/appActivated/season";
    }
    
    @RequestMapping(value = "/year")
    public String year() {
        return "channelStatics/appActivated/year";
    }
    
  //日到达数据
    @RequestMapping(value = "/dayActivated", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayActivated(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.dayActivated(params);
    }
    
    //日到达数据Top N
    @RequestMapping(value = "/dayActivatedTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayActivatedTop(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.dayActivatedTop(params);
    }
    
    //月到达数据
    @RequestMapping(value = "/monthActivated", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthActivated(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.monthActivated(params);
    }
    
    //月到达数据Top N
    @RequestMapping(value = "/monthActivatedTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthActivatedTop(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.monthActivatedTop(params);
    }
    
    //季到达数据
    @RequestMapping(value = "/seasonActivated", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonActivated(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.seasonActivated(params);
    }
    
    //季到达数据Top N
    @RequestMapping(value = "/seasonActivatedTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonActivatedTop(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.seasonActivatedTop(params);
    }
    
    //年到达数据
    @RequestMapping(value = "/yearActivated", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearActivated(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.yearActivated(params);
    }
    
    //年到达数据Top N
    @RequestMapping(value = "/yearActivatedTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearActivatedTop(@RequestBody Map<String, Object> params) {
        return mobileActivatedInfoService.yearActivatedTop(params);
    }
    
    @RequestMapping(value = "/exp2excel")
    public void exp2excel(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/msexcel;charset=UTF-8");
       
        String head = request.getParameter("head");
        String field = request.getParameter("field");

        String[] hearders = head.split(",");
        String[] fields = field.split(",");
        List<String[]> list = new ArrayList<String[]>();
        list.add(fields);
        
        String title = "APP激活统计表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        TableData td =
                ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), null);
        JsGridReportBase report = new JsGridReportBase(request, response);
        report.exportToExcel(title, user.getName(), td);
    }
}
