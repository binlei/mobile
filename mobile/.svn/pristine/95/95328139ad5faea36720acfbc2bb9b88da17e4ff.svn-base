/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: IconUtil.java
* @Prject: memory-util
* @Package: com.jshuabo.frame.server.util.apk
* @author: peng.wu
* @date: 2014年4月22日 上午9:21:49
* @version:
* @Description: 
*/
package com.jshuabo.mobile.server.batchinstall.utils.apk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: IconUtil
 * @Description: 
 * @author: peng.wu
 * @date: 2014年4月22日 上午9:21:49
 */
public class IconUtil {

    private static final Logger logger = LoggerFactory.getLogger(IconUtil.class);

    /**
     * 从指定的apk文件里获取指定file的流
     * @param apkpath
     * @param fileName
     * @return
     */
    public static InputStream extractFileFromApk(String apkpath, String fileName) {
        try {
            logger.info("从指定的apk文件里获取指定file的流 start apkpath value is :[{}]",apkpath);
            ZipFile zFile = new ZipFile(apkpath);
            logger.info("zFile value is :[{}]",zFile);
            logger.info("ZipEntry entry value is :[{}]",zFile.getEntry(fileName));
            ZipEntry entry = zFile.getEntry(fileName);
            entry.getComment();
            entry.getCompressedSize();
            entry.getCrc();
            entry.isDirectory();
            entry.getSize();
            entry.getMethod();
            logger.info("ZipEntry InputStream entry is :[{}]",entry);
            InputStream stream = zFile.getInputStream(entry);
            return stream;
        } catch (IOException e) {
            logger.error("IconUtil catch 异常[{}]",e.getLocalizedMessage());
        }
        return null;
    }
    
    public static void extractFileFromApk(String apkpath, String fileName, String outputPath){
        logger.info("parse apk ico start !");
        InputStream is = extractFileFromApk(apkpath, fileName);
        logger.info("从指定的apk文件里获取指定file的流 end !"); 
        File file = new File(outputPath);
        logger.info("file value is :[{}]",file); 
        BufferedOutputStream bos=null;
        BufferedInputStream bis = null;
        byte[] b = new byte[1024];

        try {
            logger.info("BufferedOutputStream and BufferedInputStream start  !");
            bos = new BufferedOutputStream(new FileOutputStream(file), 1024);
            bis = new BufferedInputStream(is, 1024);
            
            while(bis.read(b) != -1){
                bos.write(b);
            }
            logger.info("BufferedOutputStream and BufferedInputStream end  !");
        } catch (IOException e) {
            logger.error("IconUtil catch 异常[{}]",e.getLocalizedMessage());
        } finally{
            try {
                bos.flush();
                is.close();
                bis.close();
                bos.close();
            } catch (IOException e) {
                logger.error("IconUtil catch 关闭流异常[{}]",e.getLocalizedMessage());
            }
           
        }
       
    }

    /**
     * demo 获取apk文件的icon并写入磁盘指定位置
     * @param args
     */
    public static void main(String[] args) {
        try {
            String apkpath = "D:\\360Downloads\\Apk\\tencentmanager.apk";
            if (args.length > 0) {
                apkpath = args[0];
            }
            ApkInfo apkInfo = new ApkUtil("D:\\aapt").getApkInfo(apkpath);
            System.out.println(apkInfo);
            apkInfo.addToApplicationIcons("90", "90");
            new HashMap<String,String>().put("90", "90");
            extractFileFromApk(apkpath, apkInfo.getApplicationIcon(), "D:\\360Downloads\\Apk\\tencentmanager.png");
            System.out.println(apkInfo.getApplicationIcon());
        } catch (Exception e) {
            logger.error("IconUtil catch 异常[{}]",e.getLocalizedMessage());
        }
    }
}
