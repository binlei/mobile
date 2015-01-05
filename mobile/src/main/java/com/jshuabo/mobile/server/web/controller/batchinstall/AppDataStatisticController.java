package com.jshuabo.mobile.server.web.controller.batchinstall;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jshuabo.mobile.server.service.batchinstall.IAppDataStatisticService;

@Controller
public class AppDataStatisticController {

    @Autowired
    private IAppDataStatisticService appDataStatisticService;

    @RequestMapping("/appInstallDetail/list")
    public String appInstallDetail() {
        return "appDataCount/appInstallDetailList";
    }

}
