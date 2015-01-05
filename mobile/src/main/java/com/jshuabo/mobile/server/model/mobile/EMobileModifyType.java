/**
* Copyright©2013 www.yuanlianghe.cn. all rights reserved.
*
* @Title: EnumMobileModifyType.java
* @Prject: memory-model
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Dec 19, 2013 3:47:42 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

/**
 * @ClassName: EMobileModifyType
 * @Description: 
 * @author: lianghe.yuan
 * @date: Dec 19, 2013 3:47:42 PM
 */
public enum EMobileModifyType {
    INSTALL(1, "INSTALL"), UNINSTALL(2, "UNINSTALL");
    
    private int key;
    private String value;
    
    private EMobileModifyType(int key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
