/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: MobileLocationModel.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.web.controller.mobile
 * @author: jing.huang
 * @date: 2014年4月2日 下午6:55:11
 * @version: v1.0
 * @Description:
 */
package com.jshuabo.mobile.server.web.controller.mobile;

/**
 * @ClassName: MobileLocationModel
 * @Description:
 * @author: jing.huang
 * @date: 2014年4月2日 下午6:55:11
 */
public class MobileLocationModel {
    private String imei;
    private String locationTime;
    private String locationNums;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public String getLocationNums() {
        return locationNums;
    }

    public void setLocationNums(String locationNums) {
        this.locationNums = locationNums;
    }

}
