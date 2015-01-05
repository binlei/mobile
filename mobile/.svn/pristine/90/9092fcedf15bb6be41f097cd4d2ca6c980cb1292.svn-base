/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobilePushMessageImei.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Mar 2, 2014 5:37:54 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import java.util.Date;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobilePushMessageImei
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 2, 2014 5:37:54 PM
 */
public class MobilePushMessageImei extends R2Entity{
    private static final long serialVersionUID = -5300204674278662093L;
    
     /**
     * @fieldName: pushMessageId
     * @fieldType: Long
     * @Description: 消息ID
     */
    private Long pushMessageId;
     /**
     * @fieldName: imei
     * @fieldType: String
     * @Description: 串号/MAC
     */
    private String imei;
    
     /**
     * @fieldName: mobileLocationId
     * @fieldType: Long
     * @Description: 发送基于的位置请求
     */
    private Long mobileLocationId;
     /**
     * @fieldName: pushTime
     * @fieldType: Date
     * @Description: 推送时间
     */
    private Date pushTime;
     /**
     * @fieldName: pushedCount
     * @fieldType: Integer
     * @Description: 已推送次数
     */
    private Integer pushedCount = 0;
     /**
     * @fieldName: status
     * @fieldType: String
     * @Description: 推送状态
     */
    private String status = EPushMsgStatus.READY.toString();
    
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
     * @return the pushMessageId
     */
    public Long getPushMessageId() {
        return pushMessageId;
    }

    /**
     * @param pushMessageId the pushMessageId to set
     */
    public void setPushMessageId(Long pushMessageId) {
        this.pushMessageId = pushMessageId;
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
     * @return the pushTime
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     * @param pushTime the pushTime to set
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    /**
     * @return the mobileLocationId
     */
    public Long getMobileLocationId() {
        return mobileLocationId;
    }

    /**
     * @param mobileLocationId the mobileLocationId to set
     */
    public void setMobileLocationId(Long mobileLocationId) {
        this.mobileLocationId = mobileLocationId;
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
     * @return the pushedCount
     */
    public Integer getPushedCount() {
        return pushedCount;
    }

    /**
     * @param pushedCount the pushedCount to set
     */
    public void setPushedCount(Integer pushedCount) {
        this.pushedCount = pushedCount;
    }
}
