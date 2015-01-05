/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobileBasicInfoController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.controller.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:10:02
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
import com.jshuabo.frame.server.util.json.JacksonUtils;
import com.jshuabo.mobile.server.model.mobile.MobileBasicInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileBasicInfoService;

/**
 * @ClassName: MobileBasicInfoController
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:10:02
 */
@Controller
@RequestMapping("/mobileBasicInfo")
public class MobileBasicInfoController {
    @Autowired
    private IMobileBasicInfoService mobileBasicInfoService;

    @RequestMapping("/list")
    public String list() {
        return "mobileBasicInfo/list";
    }

    @RequestMapping("/infoOfMobile")
    public String infoOfMobile() {
        return "singleStatics/infoOfMobile";
    }

    @RequestMapping(value = "/queryByImei", method = RequestMethod.POST)
    @ResponseBody
    public String queryByImei(HttpServletRequest request) {
        String imei = request.getParameter("imei");
        System.out.println(imei);
        Map<String, Object> map = new HashMap<String, Object>();
        MobileBasicInfo mobileBasicInfo = new MobileBasicInfo();
        mobileBasicInfo = mobileBasicInfoService.queryoneByImei("12");
        map.put("mobileBasicInfo", mobileBasicInfo);
        map.put("status", true);
        return JacksonUtils.object2json(map);
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

        List<MobileBasicInfo> list = new ArrayList<MobileBasicInfo>();

        String ids = request.getParameter("ids");

        if ("".equals(ids)) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            Map<String, Object> map = new HashMap<String, Object>();
            Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
            for (Entry<String, String[]> entry : entrySet) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }

            list = mobileBasicInfoService.exportAll(map);// 获取数据
        } else {
            List<Long> idList = new ArrayList<Long>();
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                idList.add(Long.parseLong(id));
            }
            list = mobileBasicInfoService.exportSelections(idList);// 获取数据
        }

        String title = "基本配置表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID","设备ID","设备IMEI","渠道", "设备MAC", "设备IP", "设备内核", "设备型号", "设备版本号", "Android版本号", "设备ROM名称", "保存时间", "上传日期", "IP地址", "系统版本号"};// 表头数组
        String[] fields =
                new String[] {"id","productionId", "imei","extendProp5", "mac", "ip", "kernel",
                        "model", "release", "sdk", "rom", "storeTime", "uploadTime", "extendProp1", "extendProp2"};// Role对象属性数组
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
