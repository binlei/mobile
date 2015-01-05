/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobileImeiUser.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Mar 4, 2014 4:42:25 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import com.jshuabo.frame.server.model.base.REntity;

/**
 * @ClassName: MobileImeiUser
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 4, 2014 4:42:25 PM
 */
public class MobileImeiUser extends REntity {
    private static final long serialVersionUID = 5961651143336599343L;

    private String imei;
    private String userName;
    private String status;
    
    /**
     * @fieldName: extendProp1
     * @fieldType: String
     * @Description: 扩展1
     */
    private String extendProp1;
    
     /**
     * @fieldName: extendProp2
     * @fieldType: String
     * @Description: 扩展2
     */
    private String extendProp2;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the extendProp1
     */
    public String getExtendProp1() {
        return extendProp1;
    }

    /**
     * @param extendProp1 the extendProp1 to set
     */
    public void setExtendProp1(String extendProp1) {
        this.extendProp1 = extendProp1;
    }

    /**
     * @return the extendProp2
     */
    public String getExtendProp2() {
        return extendProp2;
    }

    /**
     * @param extendProp2 the extendProp2 to set
     */
    public void setExtendProp2(String extendProp2) {
        this.extendProp2 = extendProp2;
    }
}
