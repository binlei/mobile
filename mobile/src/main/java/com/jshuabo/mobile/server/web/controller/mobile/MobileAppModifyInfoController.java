/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobileAppModifyInfoController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.controller.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:07:57
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

import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.util.excelTools.ExcelBean;
import com.jshuabo.frame.server.util.excelTools.ExcelUtils;
import com.jshuabo.frame.server.util.excelTools.JsGridReportBase;
import com.jshuabo.frame.server.util.excelTools.TableData;
import com.jshuabo.mobile.server.model.mobile.MobileAppModifyInfo;
import com.jshuabo.mobile.server.service.mobile.IMobileAppModifyInfoService;

/**
 * @ClassName: MobileAppModifyInfoController
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:07:57
 */
@Controller
@RequestMapping("/mobileAppModifyInfo")
public class MobileAppModifyInfoController {
    @Autowired
    private IMobileAppModifyInfoService mobileAppModifyInfoService;

    @RequestMapping("/list")
    public String list() {
        return "mobileAppModifyInfo/list";
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

        List<MobileAppModifyInfo> list = new ArrayList<MobileAppModifyInfo>();

        String ids = request.getParameter("ids");

        if ("".equals(ids)) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            Map<String, Object> map = new HashMap<String, Object>();
            Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
            for (Entry<String, String[]> entry : entrySet) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }

            list = mobileAppModifyInfoService.exportAll(map);// 获取数据
        } else {
            List<Long> idList = new ArrayList<Long>();
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                idList.add(Long.parseLong(id));
            }
            list = mobileAppModifyInfoService.exportSelections(idList);// 获取数据
        }

        String title = "APP更新表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID","设备IMEI", "APP名称", "安装包包名", "APP本版名","渠道", "APP版本号", "安装路径", "更改类型", "更改时间", "上传日期", "IP地址", "系统版本号"};// 表头数组
        String[] fields =
                new String[] {"id","imei", "appName", "packageName", "versionName", "versionNo","extendProp5",
                        "installedPath", "modifyType", "modifyTime", "uploadTime", "extendProp1", "extendProp2"};// Role对象属性数组
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
