/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: NewArrivalController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.web.controller.chart
 * @author: jing.huang
 * @date: 2014年4月21日 下午2:45:59
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.web.controller.chart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;

/**
 * @ClassName: NewArrivalController
 * @Description:
 * @author: jing.huang
 * @date: 2014年4月21日 下午2:45:59
 */
@Controller
@RequestMapping(value = "/newArrival")
public class NewArrivalController {
    @RequestMapping(value = "/day")
    public String day() {
        return "channelStatics/newArrival/day";
    }
    
    @RequestMapping(value = "/week")
    public String week() {
        return "channelStatics/newArrival/week";
    }
    
    @RequestMapping(value = "/month")
    public String month() {
        return "channelStatics/newArrival/month";
    }
    
    @RequestMapping(value = "/season")
    public String season() {
        return "channelStatics/newArrival/season";
    }
    
    @RequestMapping(value = "/year")
    public String year() {
        return "channelStatics/newArrival/year";
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

        

        String title = "手机到达统计表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        TableData td =
                ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), null);
        JsGridReportBase report = new JsGridReportBase(request, response);
        report.exportToExcel(title, user.getName(), td);
    }
}
