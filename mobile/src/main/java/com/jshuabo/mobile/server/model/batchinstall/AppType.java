/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: AppType.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.model.batchinstall
 * @author: lianghe.yuan
 * @date: Apr 1, 2014 4:13:22 PM
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.model.batchinstall;

import com.jshuabo.frame.server.model.base.BaseStatus;
import com.jshuabo.frame.server.model.base.REntity;

/**
 * @ClassName: AppType
 * @Description:
 * @author: peng.wu
 * @date: Apr 1, 2014 4:13:22 PM
 */
public class AppType extends REntity {
    private static final long serialVersionUID = 3997560270499292506L;

    /**
     * @fieldName: code
     * @fieldType: String
     * @Description: code
     */
    private String code;
    /**
     * @fieldName: name
     * @fieldType: String
     * @Description: 应用类型名称
     */
    private String name;

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
    private String status = BaseStatus.ENABLED;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
