/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: ApkUtil.java
 * @Prject: memory-util
 * @Package: com.jshuabo.frame.server.util.apk
 * @author: peng.wu
 * @date: 2014年4月16日 上午10:38:21
 * @version:
 * @Description:
 */
package com.jshuabo.mobile.server.batchinstall.utils.apk;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ApkUtil
 * @Description: 解析apk安装包的工具
 * @author: peng.wu
 * @date: 2014年4月16日 上午10:38:21
 */
public class ApkUtil {

    private static final Logger logger = LoggerFactory.getLogger(ApkUtil.class);

    private static String apkoldName = "";

    public static final String VERSION_CODE = "versionCode";
    public static final String VERSION_NAME = "versionName";
    public static final String SDK_VERSION = "sdkVersion";
    public static final String TARGET_SDK_VERSION = "targetSdkVersion";
    public static final String USES_PERMISSION = "uses-permission";
    public static final String APPLICATION_LABEL = "application-label";
    public static final String APPLICATION_ICON = "application-icon";
    public static final String USES_FEATURE = "uses-feature";
    public static final String USES_IMPLIED_FEATURE = "uses-implied-feature";
    public static final String SUPPORTS_SCREENS = "supports-screens";
    public static final String SUPPORTS_ANY_DENSITY = "supports-any-density";
    public static final String DENSITIES = "densities";
    public static final String PACKAGE = "package";
    public static final String APPLICATION = "application:";
    public static final String LAUNCHABLE_ACTIVITY = "launchable-activity";

    private ProcessBuilder mBuilder;
    private static final String SPLIT_REGEX = "(: )|(=')|(' )|'";
    private static final String FEATURE_SPLIT_REGEX = "(:')|(',')|'";
   
    /** aapt 命令 */
    private static String aaptPath;

    public ApkUtil(String aaptPath) {
        mBuilder = new ProcessBuilder();
        mBuilder.redirectErrorStream(true);
        
        if (StringUtils.isEmpty(ApkUtil.aaptPath))
            ApkUtil.aaptPath = aaptPath;
        logger.info("ApkUtil init out aaptPath value is:[{}] !!!",aaptPath);
    }

    /**
     * 返回一个apk程序的信息。
     * 
     * @param apkPath
     *            apk的路径。
     * @return apkInfo 一个Apk的信息。
     */
    public ApkInfo getApkInfo(String apkPath) {
        Process process = null;
        String tmp = null;
        BufferedReader br = null;
        InputStream is = null;
        try {
            logger.info("执行指令:[{}] start !", aaptPath + "d badging " + apkPath);
            process = mBuilder.command(aaptPath, "d", "badging", apkPath).start();
            is = process.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "utf8"));
            tmp = br.readLine();
            logger.info("执行指令:[{}] end!", aaptPath + "d badging " + apkPath);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("执行指令:[{}]错误!", aaptPath + "d badging " + apkPath);
        }
        try {
            if (tmp == null || !tmp.startsWith("package")) {
                return null;
            }
            ApkInfo apkInfo = new ApkInfo();
            do {
                setApkInfoProperty(apkInfo, tmp);
                logger.info("执行指令setApkInfoProperty(apkInfo, tmp);[{}],[{}]!!!", new Object[]{apkInfo, tmp});
            } while ((tmp = br.readLine()) != null);
            logger.info("apkInfo value is [{}]!",apkInfo);
            return apkInfo;
        } catch (Exception ex) {
            logger.error("close resource when getApkInfo with error: {}", ex.getLocalizedMessage());
            return null;
        } finally {
            try {
                process.destroy();
                closeIO(is);
                closeIO(br);
            } catch(Exception ex) {
                logger.error("close resource when getApkInfo with error: {}", ex.getLocalizedMessage());
            }
        }
    }

    /**
     * 设置APK的属性信息。
     * 
     * @param apkInfo
     * @param source
     */
    private void setApkInfoProperty(ApkInfo apkInfo, String source) {
        if (source.startsWith(PACKAGE)) {
            splitPackageInfo(apkInfo, source);
        } else if(source.startsWith(LAUNCHABLE_ACTIVITY)){
            apkInfo.setLaunchableActivity(getPropertyInQuote(source));
        } else if (source.startsWith(SDK_VERSION)) {
            apkInfo.setSdkVersion(getPropertyInQuote(source));
        } else if (source.startsWith(TARGET_SDK_VERSION)) {
            apkInfo.setTargetSdkVersion(getPropertyInQuote(source));
        } else if (source.startsWith(USES_PERMISSION)) {
            apkInfo.addToUsesPermissions(getPropertyInQuote(source));
        } else if (source.startsWith(APPLICATION_LABEL)) {
            apkInfo.setApplicationLable(getPropertyInQuote(source));
        } else if (source.startsWith(APPLICATION_ICON)) {
            apkInfo.addToApplicationIcons(getKeyBeforeColon(source),getPropertyInQuote(source));
        } else if (source.startsWith(APPLICATION)) {
            String[] rs = source.split("( icon=')|'");
            apkInfo.setApplicationIcon(rs[rs.length - 1]);
        } else if (source.startsWith(USES_FEATURE)) {
            apkInfo.addToFeatures(getPropertyInQuote(source));
        } else if (source.startsWith(USES_IMPLIED_FEATURE)) {
            apkInfo.addToImpliedFeatures(getFeature(source));
        } else {
        }
    }

    private ImpliedFeature getFeature(String source) {
        String[] result = source.split(FEATURE_SPLIT_REGEX);
        ImpliedFeature impliedFeature = new ImpliedFeature(result[1], result[2]);
        return impliedFeature;
    }

    /**
     * 返回出格式为name: 'value'中的value内容。
     * 
     * @param source
     * @return
     */
    private String getPropertyInQuote(String source) {
        int index = source.indexOf("'") + 1;
        return source.substring(index, source.indexOf('\'', index));
    }

    /**
     * 返回冒号前的属性名称
     * 
     * @param source
     * @return
     */
    private String getKeyBeforeColon(String source) {
        return source.substring(0, source.indexOf(':'));
    }

    /**
     * 分离出包名、版本等信息。
     * 
     * @param apkInfo
     * @param packageSource
     */
    private void splitPackageInfo(ApkInfo apkInfo, String packageSource) {
        String[] packageInfo = packageSource.split(SPLIT_REGEX);
        apkInfo.setPackageName(packageInfo[2]);
        apkInfo.setVersionCode(packageInfo[4]);
        apkInfo.setVersionName(packageInfo[6]);
    }

    /**
     * 释放资源。
     * 
     * @param c
     *            将关闭的资源
     */
    private final void closeIO(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getIconName(String apkPath) {
        try {
            Runtime rt = Runtime.getRuntime();
            String order = aaptPath + " d badging \"" + apkPath + "\"";
            System.out.println(order);
            Process proc = rt.exec(order);
            InputStream stderr = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.contains("application:")) {
                    apkoldName = line.substring(line.lastIndexOf("/") + 1, line.lastIndexOf("'")).trim().toLowerCase();
                    break;
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    

    /**
     * @Title: getIcon
     * @Description:
     * @param apktoolPath 工具路径
     * @param apkPath apk应用路径
     * @param iconSaveDir 保存路径
     * @param iconSaveName 图标名称
     * @return
     * @return: String
     */
    public String getIcon(String apkPath, String iconSaveDir, String iconSaveName) {
        getIconName(apkPath);

        FileInputStream in = null;
        FileOutputStream out = null;
        ZipInputStream zipin = null;

        String apknewName = iconSaveName + ".png";
        String iconpath = iconSaveDir + apknewName;
        File apkFile = new File(apkPath);
        try {
            in = new FileInputStream(apkFile);
            zipin = new ZipInputStream(in);
            ZipEntry entry = null;
            while ((entry = zipin.getNextEntry()) != null) {
                String name = entry.getName().toLowerCase();
                if (name.endsWith("/" + apkoldName) && name.contains("drawable") && name.contains("res")) {
                    if (apkoldName.lastIndexOf(".") <= 0) {
                        apknewName = iconSaveName + ".jpg";
                    } else {
                        apknewName = iconSaveName + apkoldName.substring(apkoldName.lastIndexOf("."));
                    }
                    iconpath = iconSaveDir + apknewName;
                    out = new FileOutputStream(new File(iconpath));
                    byte[] buff = new byte[1024];
                    int n = 0;
                    while ((n = zipin.read(buff, 0, buff.length)) != -1) {
                        out.write(buff, 0, n);
                    }
                } else if (name.endsWith("/" + apkoldName) && name.contains("raw") && name.contains("res")) {
                    if (apkoldName.lastIndexOf(".") <= 0) {
                        apknewName = iconSaveName + ".jpg";
                    } else {
                        apknewName = iconSaveName + apkoldName.substring(apkoldName.lastIndexOf("."));
                    }
                    iconpath = iconSaveDir + apknewName;
                    out = new FileOutputStream(new File(iconpath));
                    byte[] buff = new byte[1024];
                    int n = 0;
                    while ((n = zipin.read(buff, 0, buff.length)) != -1) {
                        out.write(buff, 0, n);
                    }
                }
            }
            out = null;
            zipin.closeEntry();
            entry = null;
        } catch (Exception e) {
            logger.error("catch Exception:[{}]", e.getLocalizedMessage());
        } finally {
            try {
                if (zipin != null) {
                    zipin.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("catch Exception:[{}]", e.getLocalizedMessage());
            }
        }
        return apknewName;
    }

    public static String getAaptpath() {
        return aaptPath;
    }
}
