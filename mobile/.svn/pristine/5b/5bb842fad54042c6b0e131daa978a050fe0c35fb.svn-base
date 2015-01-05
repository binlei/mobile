/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: AppUsage.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.web.controller.chart
 * @author: jing.huang
 * @date: 2014年4月30日 上午10:07:25
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
import com.jshuabo.mobile.server.service.mobile.IMobileAppModifyInfoService;

/**
 * @ClassName: AppUsageController
 * @Description:
 * @author: jing.huang
 * @date: 2014年4月30日 上午10:07:25
 */
@Controller
@RequestMapping(value = "/appUsage")
public class AppUsageController {
    @Autowired
    private IMobileAppModifyInfoService mobileAppModifyInfoService;

    @RequestMapping(value = "/day")
    public String day() {
        return "channelStatics/appUsage/day";
    }

    @RequestMapping(value = "/month")
    public String month() {
        return "channelStatics/appUsage/month";
    }

    @RequestMapping(value = "/season")
    public String season() {
        return "channelStatics/appUsage/season";
    }

    @RequestMapping(value = "/year")
    public String year() {
        return "channelStatics/appUsage/year";
    }
    //最受欢迎APP
    @RequestMapping(value = "/dayPopular")
    public String dayPopular() {
        return "channelStatics/popularApp/day";
    }
    
    @RequestMapping(value = "/monthPopular")
    public String monthPopular() {
        return "channelStatics/popularApp/month";
    }
    
    @RequestMapping(value = "/seasonPopular")
    public String seasonPopular() {
        return "channelStatics/popularApp/season";
    }
    
    @RequestMapping(value = "/yearPopular")
    public String yearPopular() {
        return "channelStatics/popularApp/year";
    }

    // 日使用数据
    @RequestMapping(value = "/dayUsage", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayUsage(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.dayUsage(params);
    }

    // 日使用数据Top N
    @RequestMapping(value = "/dayUsageTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayUsageTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.dayUsageTop(params);
    }
    // 月使用数据
    @RequestMapping(value = "/monthUsage", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthUsage(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.monthUsage(params);
    }
    
    // 月使用数据Top N
    @RequestMapping(value = "/monthUsageTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthUsageTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.monthUsageTop(params);
    }
    // 季使用数据
    @RequestMapping(value = "/seasonUsage", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonUsage(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.seasonUsage(params);
    }
    
    // 季使用数据Top N
    @RequestMapping(value = "/seasonUsageTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonUsageTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.seasonUsageTop(params);
    }
    // 年使用数据
    @RequestMapping(value = "/yearUsage", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearUsage(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.yearUsage(params);
    }
    
    // 年使用数据Top N
    @RequestMapping(value = "/yearUsageTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearUsageTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.yearUsageTop(params);
    }
    
    // 每日最受欢迎Top N
    @RequestMapping(value = "/dayPopularTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> dayPopularTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.dayPopularTop(params);
    }
    
    // 每月最受欢迎Top N
    @RequestMapping(value = "/monthPopularTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> monthPopularTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.monthPopularTop(params);
    }
    
    // 每季最受欢迎Top N
    @RequestMapping(value = "/seasonPopularTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> seasonPopularTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.seasonPopularTop(params);
    }
    
    // 每年最受欢迎Top N
    @RequestMapping(value = "/yearPopularTop", method = RequestMethod.POST)
    @ResponseBody
    public List<ChartEntity> yearPopularTop(@RequestBody Map<String, Object> params) {
        return mobileAppModifyInfoService.yearPopularTop(params);
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

        

        String title = "APP使用情况表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        TableData td =
                ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), null);
        JsGridReportBase report = new JsGridReportBase(request, response);
        report.exportToExcel(title, user.getName(), td);
    }
}
