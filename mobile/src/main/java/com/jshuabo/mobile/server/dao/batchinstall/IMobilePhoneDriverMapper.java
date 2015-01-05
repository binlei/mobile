package com.jshuabo.mobile.server.dao.batchinstall;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jshuabo.frame.server.dao.IBaseMapper;
import com.jshuabo.mobile.server.model.batchinstall.MobilePhoneDriver;

public interface IMobilePhoneDriverMapper extends IBaseMapper<MobilePhoneDriver> {

    @Transactional(readOnly = true)
    List<MobilePhoneDriver> page(Map<String, Object> params);

    @Transactional(readOnly = true)
    Long total(Map<String, Object> params);

}
