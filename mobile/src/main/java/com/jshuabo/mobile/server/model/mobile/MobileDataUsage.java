/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobileDataUsage.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Feb 19, 2014 3:40:12 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobileDataUsage
 * @Description: 网络流量统计
 * @author: lianghe.yuan
 * @date: Feb 19, 2014 3:40:12 PM
 */
public class MobileDataUsage extends R2Entity {
    private static final long serialVersionUID = 2372410382849798450L;

     /**
     * @fieldName: imei
     * @fieldType: String
     * @Description: 设备IMEI 
     */
    private String imei;
    
     /**
     * @fieldName: simOperator
     * @fieldType: String
     * @Description:  网络运营商
     */
    private String simOperator;
    
     /**
     * @fieldName: g23Time
     * @fieldType: Long
     * @Description: 2g/3g 网络使用时长(minute)
     */
    private Long g23Time = (long) 0;
    
     /**
     * @fieldName: g23Usage
     * @fieldType: Long
     * @Description: 2g/3g 网络使用流量大小(KB)
     */
    private Long g23Usage = (long) 0;
    
     /**
     * @fieldName: wifiTime
     * @fieldType: Long
     * @Description: wifi 使用时长(minute)
     */
    private Long wifiTime = (long) 0;
    
     /**
     * @fieldName: wifiUsage
     * @fieldType: Long
     * @Description: wifi 适用流量大小(KB)
     */
    private Long wifiUsage = (long) 0;
    
     /**
     * @fieldName: statisticalTime
     * @fieldType: Date
     * @Description: 统计日期
     */
    private Date statisticalTime;
    
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
     * @return the simOperator
     */
    public String getSimOperator() {
        return simOperator;
    }

    /**
     * @param simOperator the simOperator to set
     */
    public void setSimOperator(String simOperator) {
        this.simOperator = simOperator;
    }

    /**
     * @return the g23Time
     */
    public Long getG23Time() {
        return g23Time;
    }

    /**
     * @param g23Time the g23Time to set
     */
    public void setG23Time(Long g23Time) {
        this.g23Time = g23Time;
    }

    /**
     * @return the g23Usage
     */
    public Long getG23Usage() {
        return g23Usage;
    }

    /**
     * @param g23Usage the g23Usage to set
     */
    public void setG23Usage(Long g23Usage) {
        this.g23Usage = g23Usage;
    }

    /**
     * @return the wifiTime
     */
    public Long getWifiTime() {
        return wifiTime;
    }

    /**
     * @param wifiTime the wifiTime to set
     */
    public void setWifiTime(Long wifiTime) {
        this.wifiTime = wifiTime;
    }

    /**
     * @return the wifiUsage
     */
    public Long getWifiUsage() {
        return wifiUsage;
    }

    /**
     * @param wifiUsage the wifiUsage to set
     */
    public void setWifiUsage(Long wifiUsage) {
        this.wifiUsage = wifiUsage;
    }

    /**
     * @return the statisticalTime
     */
    public Date getStatisticalTime() {
        return statisticalTime;
    }

    /**
     * @param statisticalTime the statisticalTime to set
     */
    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
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
