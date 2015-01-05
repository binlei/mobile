/**
* Copyright©2013 www.jshuabo.com. all rights reserved.
*
* @Title: MobileBasicInfo.java
* @Prject: memory-model
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Dec 19, 2013 2:53:30 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobileBasicInfo
 * @Description: 
 * @author: lianghe.yuan
 * @date: Dec 23, 2013 5:05:04 PM
 */
public class MobileBasicInfo extends R2Entity {
    private static final long serialVersionUID = -1463278757000498660L;

     /**
     * @fieldName: produtionId
     * @fieldType: String
     * @Description: 设备ID
     */
    private String productionId;
    
     /**
     * @fieldName: imei
     * @fieldType: String
     * @Description: 设备ID
     */
    private String imei;
    
     /**
     * @fieldName: mac
     * @fieldType: String
     * @Description: 设备MAC
     */
    private String mac;
    
     /**
     * @fieldName: ip
     * @fieldType: String
     * @Description: 设备ip 
     */
    private String ip;
    
     /**
     * @fieldName: kernel
     * @fieldType: String
     * @Description: 设备内核 
     */
    private String kernel;
    
     /**
     * @fieldName: model
     * @fieldType: String
     * @Description: 设备型号
     */
    private String model;
    
     /**
     * @fieldName: release
     * @fieldType: String
     * @Description: 设备版本号
     */
    private String release;
    
     /**
     * @fieldName: sdk
     * @fieldType: String
     * @Description: Android 版本号
     */
    private String sdk;
    
     /**
     * @fieldName: rom
     * @fieldType: String
     * @Description: 设备ROM名称
     */
    private String rom;
    
     /**
     * @fieldName: storeTime
     * @fieldType: Date
     * @Description: 保存时间
     */
    private Date storeTime;
    
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

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKernel() {
        return kernel;
    }

    public void setKernel(String kernel) {
        this.kernel = kernel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getExtendProp1() {
        return extendProp1;
    }

    public void setExtendProp1(String extendProp1) {
        this.extendProp1 = extendProp1;
    }

    public String getExtendProp2() {
        return extendProp2;
    }

    public void setExtendProp2(String extendProp2) {
        this.extendProp2 = extendProp2;
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
