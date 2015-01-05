/**
* Copyright©2013 www.jshuabo.com. all rights reserved.
*
* @Title: MobileArrival.java
* @Prject: memory-model
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Dec 19, 2013 2:52:29 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobileArrival
 * @Description: 
 * @author: lianghe.yuan
 * @date: Feb 9, 2014 10:44:33 PM
 */
public class MobileArrival extends R2Entity {
    private static final long serialVersionUID = 2611705759577638586L;

     /**
     * @fieldName: imei
     * @fieldType: String
     * @Description: 设备IMEI
     */
    private String imei;
    
     /**
     * @fieldName: imsi
     * @fieldType: String
     * @Description: 设备IMSI
     */
    private String imsi;
    
     /**
     * @fieldName: uploadTime
     * @fieldType: Date
     * @Description: 上传日期
     */
    private Date uploadTime;
    
     /**
     * @fieldName: arrivalTime
     * @fieldType: Date
     * @Description: 到达时间
     */
    private Date arrivalTime; 
    
     /**
     * @fieldName: simOperator
     * @fieldType: String
     * @Description: 网络运营商
     */
    private String simOperator;
    
     /**
     * @fieldName: phoneNum
     * @fieldType: String
     * @Description: 手机号
     */
    private String phoneNum;
    
    /**
     * @fieldName: kind
     * @fieldType: String
     * @Description: 类别(正式(NORMAL)，测试(TEST)，内部(INNER))
     */
    private String kind = EMobileArrivalKind.NORMAL.toString();
    
     /**
     * @fieldName: extendProp1
     * @fieldType: String
     * @Description: 
     */
    private String extendProp1;
    
     /**
     * @fieldName: extendProp2
     * @fieldType: String
     * @Description: 
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
     * @return the imsi
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * @param imsi the imsi to set
     */
    public void setImsi(String imsi) {
        this.imsi = imsi;
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
     * @return the arrivalTime
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
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
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getExtendProp3() {
        return extendProp3;
    }

    public void setExtendProp3(String extendProp3) {
        this.extendProp3 = extendProp3;
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
