/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobileActive.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Feb 19, 2014 3:53:24 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobileActivatedInfo
 * @Description: 设备激活
 * @author: lianghe.yuan
 * @date: Feb 19, 2014 3:53:24 PM
 */
/**
 * @ClassName: MobileActivatedInfo
 * @Description: 
 * @author: jing.huang
 * @date: 2014年5月29日 下午3:57:23
 */
public class MobileActivatedInfo  extends R2Entity {
    private static final long serialVersionUID = 4782872717662361844L;

    /**
     * @fieldName: imei
     * @fieldType: String
     * @Description: 设备IMEI 
     */
    private String imei;
    
     /**
     * @fieldName: appName
     * @fieldType: String
     * @Description: 应用名称
     */
    private String appName;
    
     /**
     * @fieldName: packageName
     * @fieldType: String
     * @Description: 安装包名
     */
    private String packageName;
    
     /**
     * @fieldName: activatedTime
     * @fieldType: Date
     * @Description: 激活时间 
     */
    private Date activatedTime;
    
    /**
     * @fieldName: uploadTime
     * @fieldType: Date
     * @Description: 上传日期
     */
    private Date uploadTime;
    
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
     * @fieldName: extendProp3
     * @fieldType: String
     * @Description: 
     */
    private String extendProp3;
     /**
     * @fieldName: extendProp4
     * @fieldType: String
     * @Description: 
     */
    private String extendProp4;
     /**
     * @fieldName: extendProp5
     * @fieldType: String
     * @Description: 
     */
    private String extendProp5;

    public String getExtendProp3() {
        return extendProp3;
    }

    public void setExtendProp3(String extendProp3) {
        this.extendProp3 = extendProp3;
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
     * @return the appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return the uploadTime
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime the uploadTime to set
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
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

    /**
     * @return the activatedTime
     */
    public Date getActivatedTime() {
        return activatedTime;
    }

    /**
     * @param activatedTime the activatedTime to set
     */
    public void setActivatedTime(Date activatedTime) {
        this.activatedTime = activatedTime;
    }

    public String getExtendProp4() {
        return extendProp4;
    }

    public void setExtendProp4(String extendProp4) {
        this.extendProp4 = extendProp4;
    }

    public String getExtendProp5() {
        return extendProp5;
    }

    public void setExtendProp5(String extendProp5) {
        this.extendProp5 = extendProp5;
    }
}
