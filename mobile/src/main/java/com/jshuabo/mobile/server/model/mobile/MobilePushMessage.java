/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: MobilePushMessage.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Mar 2, 2014 5:33:27 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

import com.jshuabo.frame.server.model.base.R2Entity;

/**
 * @ClassName: MobilePushMessage
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 2, 2014 5:33:27 PM
 */
public class MobilePushMessage extends R2Entity{
    private static final long serialVersionUID = 7896918580752144091L;
    
    private transient String imei; /** 设备唯一值 */
    private String dealType; /** 处理类型 1:通知, 2:隐藏广告 */
    private String notiTitle = ""; /** 通知标题 */
    private String notiContent = ""; /** 通知内容 */
    private String notiImgUrl = ""; /** 通知图片 */
    private String openType;  /** 打开网络地址类型 1:浏览器, 2:微信 */
    private String netUrl = ""; /** 网络地址 */
    private String notiFileUrl = ""; /** 文件下载地址 */
    private String packageName = ""; /** 静默激活包名 */
    private String extendsData1 = ""; /** 上报周期调整 */
    private String extendsData2 = ""; /** 应用激活次数 */
    
    /**
     * @fieldName: extendProp1
     * @fieldType: String
     * @Description: APP名称
     */
    private String extendProp1;
    
     /**
     * @fieldName: extendProp2
     * @fieldType: String
     * @Description: 消息主题
     */
    private String extendProp2;
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
     * @return the dealType
     */
    public String getDealType() {
        return dealType;
    }
    /**
     * @param dealType the dealType to set
     */
    public void setDealType(String dealType) {
        this.dealType = dealType;
    }
    /**
     * @return the notiTitle
     */
    public String getNotiTitle() {
        return notiTitle;
    }
    /**
     * @param notiTitle the notiTitle to set
     */
    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }
    /**
     * @return the notiContent
     */
    public String getNotiContent() {
        return notiContent;
    }
    /**
     * @param notiContent the notiContent to set
     */
    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }
    /**
     * @return the notiImgUrl
     */
    public String getNotiImgUrl() {
        return notiImgUrl;
    }
    /**
     * @param notiImgUrl the notiImgUrl to set
     */
    public void setNotiImgUrl(String notiImgUrl) {
        this.notiImgUrl = notiImgUrl;
    }
    /**
     * @return the openType
     */
    public String getOpenType() {
        return openType;
    }
    /**
     * @param openType the openType to set
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }
    /**
     * @return the netUrl
     */
    public String getNetUrl() {
        return netUrl;
    }
    /**
     * @param netUrl the netUrl to set
     */
    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl;
    }
    /**
     * @return the notiFileUrl
     */
    public String getNotiFileUrl() {
        return notiFileUrl;
    }
    /**
     * @param notiFileUrl the notiFileUrl to set
     */
    public void setNotiFileUrl(String notiFileUrl) {
        this.notiFileUrl = notiFileUrl;
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
     * @return the extendsData1
     */
    public String getExtendsData1() {
        return extendsData1;
    }
    /**
     * @param extendsData1 the extendsData1 to set
     */
    public void setExtendsData1(String extendsData1) {
        this.extendsData1 = extendsData1;
    }
    /**
     * @return the extendsData2
     */
    public String getExtendsData2() {
        return extendsData2;
    }
    /**
     * @param extendsData2 the extendsData2 to set
     */
    public void setExtendsData2(String extendsData2) {
        this.extendsData2 = extendsData2;
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