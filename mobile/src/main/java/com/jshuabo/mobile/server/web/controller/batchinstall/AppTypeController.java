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
import com.jshuabo.mobile.server.model.batchinstall.AppType;
import com.jshuabo.mobile.server.service.batchinstall.IAppInfoService;
import com.jshuabo.mobile.server.service.batchinstall.IAppTypeService;

@Controller
@RequestMapping("/appType")
public class AppTypeController {

    private static final Logger logger = LoggerFactory.getLogger(AppTypeController.class);

    @Autowired
    private IAppTypeService appTypeService;

    @Autowired
    private IAppInfoService appInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String appTypeList() {
        return "appType/list";
    }
    
    @RequestMapping(value = "/listView", method = RequestMethod.GET)
    public String appTypeListView() {
        return "appType/listView";
    }

    @RequestMapping(value = "/getAppType", method = RequestMethod.POST)
    @ResponseBody
    public List<AppType> getAppType() {
        return appTypeService.loadAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String requestAddAppTypePage() {
        return "appType/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addAppType(AppType appType) {
        try {
            appTypeService.save(appType);
        } catch (Exception e) {
            logger.error("catch Exception:[{}]",e.getLocalizedMessage() );
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    @RequestMapping(value = "/edit/{appTypeId}", method = RequestMethod.GET)
    public String requestEditAppTypePage(@PathVariable Long appTypeId, Model model) {
        model.addAttribute(appTypeService.load(appTypeId));
        return "appType/edit";
    }

    @RequestMapping(value = "/edit/{appTypeId}", method = RequestMethod.POST)
    @ResponseBody
    public String editAppType(@PathVariable Long appTypeId, AppType appType) {
        try {
            appType.setId(appTypeId);
            appTypeService.update(appType);
        } catch (Exception e) {
            logger.error("catch Exception:[{}]",e.getLocalizedMessage() );
            return ResultConstant.DEFEATED;
        }
        return ResultConstant.SUCCESSED;
    }

    @RequestMapping(value = "/{appTypeId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAppType(@PathVariable long appTypeId) {
        String result = null;
        try {
            result = appTypeService.deleteById(appTypeId);
        } catch (Exception e) {
            logger.error("catch Exception:[{}]",e.getLocalizedMessage() );
            return ResultConstant.DEFEATED;
        }
        return result;
    }

    @RequestMapping(value = "/searchAppTypeIsPass", method = RequestMethod.GET)
    @ResponseBody
    public String searchAppTypeIsPass(HttpServletRequest request) {
        String appTypeId = request.getParameter("appTypeId");
        return appTypeService.searchAppTypeIsPass(new Long(appTypeId));
    }

    @RequestMapping(value = "/searchAppTypeByName", method = RequestMethod.GET)
    @ResponseBody
    public String searchAppTypeByName(HttpServletRequest request) {
        String appTypeName = request.getParameter("appTypeName");
        int falg = appTypeService.searchAppTypeByName(appTypeName.trim());
        if (falg != 0)  return ResultConstant.EXIST;
        return ResultConstant.INEXISTENT;
    }

}
