/**
  * Copyright©2014 www.jshuabo.com. all rights reserved.
  *
  * @Title: MobileAppInstallResult.java
  * @Prject: mobile
  * @Package: com.jshuabo.mobile.server.model.mobile
  * @author: lianghe.yuan
  * @date: Jun 12, 2014 10:45:59 AM
  * @version: 
  * @Description: 
  */
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobileAppInstallResult
 * @Description: 推送安装的结果反馈
 * @author: lianghe.yuan
 * @date: Jun 12, 2014 10:45:59 AM
 */
public class MobileAppInstallResult extends R2Entity {
    private static final long serialVersionUID = -8907251756192399941L;

    /** 设备IMEI */
    private String imei;
    /** 安装时间 */
    private Date installTime;
    /** 是否安装成功 -1表示解析该数据失败 0代表未下载、1代表已下载但未安装、2已安装*/
    private Integer installStatus;
    /**  应用程序名称 */
    private String appName;
    /** 安装包包名 */
    private String packageName;
    /** 远程IP */
    private String extendProp1;
    /** 远程版本 */
    private String extendProp2;
    /** 远程渠道 */
    private String extendProp3;
    /** 装机渠道编码 */
    private String extendProp4;
    /** 装机渠道名称 */
    private String extendProp5;
    
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
     * @return the installTime
     */
    public Date getInstallTime() {
        return installTime;
    }
    /**
     * @param installTime the installTime to set
     */
    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
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
     * @return the installStatus
     */
    public Integer getInstallStatus() {
        return installStatus;
    }
    /**
     * @param installStatus the installStatus to set
     */
    public void setInstallStatus(Integer installStatus) {
        this.installStatus = installStatus;
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
     * @return the extendProp3
     */
    public String getExtendProp3() {
        return extendProp3;
    }
    /**
     * @param extendProp3 the extendProp3 to set
     */
    public void setExtendProp3(String extendProp3) {
        this.extendProp3 = extendProp3;
    }
    /**
     * @return the extendProp4
     */
    public String getExtendProp4() {
        return extendProp4;
    }
    /**
     * @param extendProp4 the extendProp4 to set
     */
    public void setExtendProp4(String extendProp4) {
        this.extendProp4 = extendProp4;
    }
    /**
     * @return the extendProp5
     */
    public String getExtendProp5() {
        return extendProp5;
    }
    /**
     * @param extendProp5 the extendProp5 to set
     */
    public void setExtendProp5(String extendProp5) {
        this.extendProp5 = extendProp5;
    }
}
