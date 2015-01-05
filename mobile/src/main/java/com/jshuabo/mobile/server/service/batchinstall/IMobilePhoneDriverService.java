package com.jshuabo.mobile.server.service.batchinstall;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.service.IBaseService;

public interface IMobilePhoneDriverService extends IBaseService {

    @Transactional(readOnly = true)
    String page(Map<String, Object> params);
}
