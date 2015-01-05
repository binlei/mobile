/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobilePhoneDriver.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.model.batchinstall
 * @author: lianghe.yuan
 * @date: Apr 1, 2014 4:14:35 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.model.batchinstall;

import com.jshuabo.frame.server.model.base.REntity;

/**
 * @ClassName: MobilePhoneDriver
 * @Description:
 * @author: peng.wu
 * @date: Apr 1, 2014 4:14:35 PM
 */
public class MobilePhoneDriver extends REntity {
 
    private static final long serialVersionUID = -1217602459507164620L;
    /**
     * @fieldName: phoneModel
     * @fieldType: String
     * @Description: 手机型号
     */
    private String phoneModel;
    /**
     * @fieldName: driverPath
     * @fieldType: String
     * @Description: 驱动路径
     */
    private String driverPath;
    /**
     * @fieldName: driverVersion
     * @fieldType: String
     * @Description: 驱动版本
     */
    private String driverVersion;
    /**
     * @fieldName: description
     * @fieldType: String
     * @Description: 描述
     */
    private String description;
    /**
     * @fieldName: status
     * @fieldType: String
     * @Description: 状态
     */
    private String status;

    public String getPhoneModel() {
    return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
    this.phoneModel = phoneModel;
    }

    public String getDriverPath() {
    return driverPath;
    }

    public void setDriverPath(String driverPath) {
    this.driverPath = driverPath;
    }

    public String getDriverVersion() {
    return driverVersion;
    }

    public void setDriverVersion(String driverVersion) {
    this.driverVersion = driverVersion;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public String getStatus() {
    return status;
    }

    public void setStatus(String status) {
    this.status = status;
    }



}
