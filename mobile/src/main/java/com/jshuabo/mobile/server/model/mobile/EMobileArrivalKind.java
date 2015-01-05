/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: EMobileArrivalKind.java
* @Prject: mobile_api
* @Package: com.jshuabo.mobile.server.model.mobile
* @author: lianghe.yuan
* @date: Mar 3, 2014 10:50:41 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.mobile;

/**
 * @ClassName: EMobileArrivalKind
 * @Description: 
 * @author: lianghe.yuan
 * @date: Mar 3, 2014 10:50:41 PM
 */
public enum EMobileArrivalKind {
    NORMAL("NORMAL"),
    TEST("TEST"),
    INNER("INNER");
    
    private String kind;
    
    private EMobileArrivalKind(String kind) {
        this.kind = kind;
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
    
}
