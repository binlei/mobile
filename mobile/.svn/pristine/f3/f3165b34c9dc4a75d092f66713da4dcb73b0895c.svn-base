package com.jshuabo.mobile.server.web.controller.batchinstall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshuabo.frame.server.web.controller.constants.ResultConstant;
import com.jshuabo.mobile.server.model.batchinstall.AppPackageType;
import com.jshuabo.mobile.server.service.batchinstall.IAppPackageTypeService;

@Controller
@RequestMapping("/appPackageType")
public class AppPackageTypeController {

    private static final Logger logger = LoggerFactory.getLogger(AppPackageTypeController.class);

    @Autowired
    private IAppPackageTypeService appPackageTypeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String appPackageTypeList() {
        return "appPackageType/list";
    }
    
    @RequestMapping(value = "/listView", method = RequestMethod.GET)
    public String appPackageTypeListView() {
        return "appPackageType/listView";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String appPackageTypeAdd() {
        return "appPackageType/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String doAppPackageTypeAdd(AppPackageType appPackageType) {
        try {
            appPackageTypeService.save(appPackageType);
        } catch (Exception ex) {
            logger.error("catch Exception doAppPackageTypeAdd: [{}]", ex.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    @RequestMapping(value = "/edit/{appPackId}", method = RequestMethod.GET)
    public String appPackageTypeEdit(@PathVariable int appPackId, Model model) {
        model.addAttribute("appPackageType", appPackageTypeService.load(appPackId));
        return "appPackageType/edit";
    }

    @RequestMapping(value = "/edit/{appPackId}", method = RequestMethod.POST)
    @ResponseBody
    public String doAppPackageTypeEdit(@PathVariable long appPackId, AppPackageType appPackageType) {
        try {
            appPackageType.setId(appPackId);
            appPackageTypeService.update(appPackageType);
        } catch (Exception e) {
            logger.error("catch Exception for doAppPackageTypeEdit:[{}]",e.getLocalizedMessage());
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    @RequestMapping(value = "/{appPackTypeId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String appPackageTypeDelete(@PathVariable long appPackTypeId) {
        String result = null;
        try {
            result = appPackageTypeService.deleteByPackTypeId(appPackTypeId);
        } catch (Exception e) {
            logger.error("catch Exception appPackageTypeDelete :[{}]",e.getLocalizedMessage());
            return result;
        }
        return result;
    }
    
    /**
     * @Title: getAppPackageType
     * @Description: 获取 应用包 类型
     * @return
     * @return: List<AppPackageType>
     */
    @RequestMapping(value = "/getAppPackageType", method = RequestMethod.POST)
    @ResponseBody
    public List<AppPackageType> getAppPackageType() {
        List<AppPackageType> appPkgTypes = appPackageTypeService.loadAll();
        return appPkgTypes;
    }
    
    /**
     * @Title: searchPackageTypeNameIsPass
     * @Description: 查询 包类型是否 有效
     * @param request
     * @return
     * @return: String
     */
    @RequestMapping(value = "/searchPackageTypeNameIsPass", method = RequestMethod.GET)
    @ResponseBody
    public String searchPackageTypeNameIsPass(HttpServletRequest request) {
        String packageNameId = request.getParameter("packageTypeName");
        return appPackageTypeService.searchPackageTypeNameIsPass(new Long(packageNameId));
    }
    
}
