/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobilePushMessageImeiController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.controller.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:12:42
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelBean;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;
import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessage;
import com.jshuabo.mobile.server.model.mobile.MobilePushMessageImei;
import com.jshuabo.mobile.server.service.mobile.IMobilePushMessageImeiService;

/**
 * @ClassName: MobilePushMessageImeiController
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:12:42
 */
@Controller
@RequestMapping("/mobilePushMessageImei")
public class MobilePushMessageImeiController {
    @Autowired
    private IMobilePushMessageImeiService mobilePushMessageImeiService;

    @RequestMapping("/list")
    public String list() {
        return "mobilePushMessageImei/list";
    }

    // 弹出导出窗口
    @RequestMapping("/limitRecords")
    public String limitRecords() {
        return "common/limitRecords";
    }

    /**
     * @Title: preAdd
     * @Description: 跳转到推送消息页面
     * @return
     * @return: String
     */
    @RequestMapping("/preAdd")
    public String preAdd() {
        return "mobilePushMessageImei/add";
    }

    /**
     * @Title: add
     * @Description: 推送消息
     * @param mobilePushMessage
     * @return
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(MobilePushMessageImei mobilePushMessageImei) {
        try {
            mobilePushMessageImeiService.save(mobilePushMessageImei);
        } catch (Exception e) {
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }
    // 普通Excel导出查询结果，获取的数据格式是List<JavaBean>
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/msexcel;charset=UTF-8");

        List<MobilePushMessageImei> list = new ArrayList<MobilePushMessageImei>();

        String ids = request.getParameter("ids");

        if ("".equals(ids)) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            Map<String, Object> map = new HashMap<String, Object>();
            Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
            for (Entry<String, String[]> entry : entrySet) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }

            list = mobilePushMessageImeiService.exportAll(map);// 获取数据
        } else {
            List<Long> idList = new ArrayList<Long>();
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                idList.add(Long.parseLong(id));
            }
            list = mobilePushMessageImeiService.exportSelections(idList);// 获取数据
        }

        String title = "推送表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID","消息ID","设备IMEI", "位置信息ID", "推送时间", "已推送次数", "推送状态", "IP地址", "系统版本号"};// 表头数组
        String[] fields =
                new String[] {"id","pushMessageId", "imei", "mobileLocationId", "pushTime", "pushedCount",
                        "status", "extendProp1", "extendProp2"};// Role对象属性数组
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
}
