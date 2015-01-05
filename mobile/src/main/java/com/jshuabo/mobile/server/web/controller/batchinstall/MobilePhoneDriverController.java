package com.jshuabo.mobile.server.web.controller.batchinstall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MobilePhoneDriver")
public class MobilePhoneDriverController {

    @RequestMapping("/list")
    public String appInfoList() {
        return "MobilePhoneDriver/list";
    }
}
