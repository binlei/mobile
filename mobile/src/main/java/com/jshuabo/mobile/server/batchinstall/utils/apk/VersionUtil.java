/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: VersionUtil.java
 * @Prject: memory-util
 * @Package: com.jshuabo.frame.server.util.apk
 * @author: peng.wu
 * @date: 2014年4月22日 上午8:49:58
 * @version:
 * @Description:
 */
package com.jshuabo.mobile.server.batchinstall.utils.apk;

/**
 * @ClassName: VersionUtil
 * @Description: 返回 APK 的版本
 * @author: peng.wu
 * @date: 2014年4月22日 上午8:49:58
 */
public class VersionUtil {
    /**
     * 返回版本号。
     * 
     * @return
     */
    public static String getVersion() {
        return String.format("%d.%d.%d", getMajorVersion(), getMinorVersion(), getRevisionNumber());
    }

    /**
     * ` 返回主版本号。
     * 
     * @return
     */
    public static int getMajorVersion() {
        return 1;
    }

    /**
     * 返回次版本号。
     * 
     * @return
     */
    public static int getMinorVersion() {
        return 1;
    }

    /**
     * 返回修正版本号。
     * 
     * @return
     */
    public static int getRevisionNumber() {
        return 0;
    }
}
