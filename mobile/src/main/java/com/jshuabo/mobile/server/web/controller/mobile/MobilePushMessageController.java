/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobilePushMessageController.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.controller.mobile
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:12:07
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
import org.springframework.ui.Model;
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
import com.jshuabo.mobile.server.service.mobile.IMobilePushMessageService;

/**
 * @ClassName: MobilePushMessageController
 * @Description:
 * @author: jing.huang
 * @date: 2014年3月12日 上午11:12:07
 */
@Controller
@RequestMapping("/mobilePushMessage")
public class MobilePushMessageController {
    @Autowired
    private IMobilePushMessageService mobilePushMessageService;

    @RequestMapping("/list")
    public String list() {
        return "mobilePushMessage/list";
    }
    
    
    /**
     * @Title: preAdd
     * @Description: 跳转到添加页面
     * @return
     * @return: String
     */
    @RequestMapping("/preAdd")
    public String preAdd() {
        return "mobilePushMessage/add";
    }

    /**
     * @Title: add
     * @Description: 新建消息
     * @param mobilePushMessage
     * @return
     * @return: String
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(MobilePushMessage mobilePushMessage) {
        try {
            mobilePushMessageService.save(mobilePushMessage);
        } catch (Exception e) {
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }
    
    /**
     * @Title: preEdit
     * @Description:  跳转到编辑页面
     * @param id
     * @param model
     * @return
     * @return: String
     */
    @RequestMapping("/preEdit")
    public String preEdit(String id,Model model) {
        model.addAttribute("mobilePushMessage", mobilePushMessageService.loadById(Long.parseLong(id)));
        return "mobilePushMessage/edit";
    }
    
    /**
     * @Title: edit
     * @Description: 编辑消息
     * @param mobilePushMessage
     * @return
     * @return: String
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public String edit(MobilePushMessage mobilePushMessage) {
        try {
            mobilePushMessageService.update(mobilePushMessage);
        } catch (Exception e) {
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
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

        List<MobilePushMessage> list = new ArrayList<MobilePushMessage>();

        String ids = request.getParameter("ids");

        if ("".equals(ids)) {
            Map<String, String[]> paramsMap = request.getParameterMap();
            Map<String, Object> map = new HashMap<String, Object>();
            Set<Entry<String, String[]>> entrySet = paramsMap.entrySet();
            for (Entry<String, String[]> entry : entrySet) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }

            list = mobilePushMessageService.exportAll(map);// 获取数据
        } else {
            List<Long> idList = new ArrayList<Long>();
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                idList.add(Long.parseLong(id));
            }
            list = mobilePushMessageService.exportSelections(idList);// 获取数据
        }

        String title = "消息表";
        User user = (User) SecurityUtils.getSubject().getPrincipal();// 获取当前用户
        String[] hearders =
                new String[] {"ID","处理类型","通知标题", "通知内容", "通知图片", "打开网址类型", "网络地址", "文件下载地址", "激活包包名", "IP地址", "系统版本号"};// 表头数组
        String[] fields =
                new String[] {"id","dealType", "notiTitle", "notiContent", "notiImgUrl", "openType",
                              "netUrl", "notiFileUrl", "packageName", "extendProp1", "extendProp2"};// Role对象属性数组
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
