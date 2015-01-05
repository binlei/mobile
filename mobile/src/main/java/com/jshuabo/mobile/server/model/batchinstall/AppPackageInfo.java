/**
* Copyright©2014 www.jshuabo.com. all rights reserved.
*
* @Title: AppPackageInfo.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.model.batchinstall
* @author: lianghe.yuan
* @date: Apr 1, 2014 4:13:03 PM
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.model.batchinstall;

import java.util.HashSet;
import java.util.Set;

import com.jshuabo.frame.server.model.base.REntity;
import com.jshuabo.frame.server.model.organization.Organization;
import com.jshuabo.frame.server.util.math.DoubleUtils;

/**
 * @ClassName: AppPackageInfo
 * @Description: 
 * @author: peng.wu
 * @date: Apr 1, 2014 4:13:03 PM
 */ 
/**
 * @author UESR
 *
 */
public class AppPackageInfo extends REntity {
    private static final long serialVersionUID = -4021714625016446973L;
    
     /**
     * @fieldName: name
     * @fieldType: String
     * @Description: 应用名称
     */
    private String name;
    
     /**
     * @fieldName: packageType
     * @fieldType: AppPackageType
     * @Description: 应用包类型
     */
    private AppPackageType appPackageType;
    
     /**
     * @fieldName: organization
     * @fieldType: Organization
     * @Description: 渠道
     */
    private Organization organization;
    
     /**
     * @fieldName: size
     * @fieldType: Double
     * @Description: 应用包大小 
     */
    private Double size = 0d;
    
     /**
     * @fieldName: quantity
     * @fieldType: Integer
     * @Description: 应用包中APK数量
     */
    private Integer quantity = 0;
    
     /**
     * @fieldName: description
     * @fieldType: String
     * @Description: 应用包描述 
     */
    private String description;
    
     /**
     * @fieldName: details
     * @fieldType: Set<AppPackageInfoDetail>
     * @Description: 应用包明显
     */
    private Set<AppPackageInfoDetail> details = new HashSet<AppPackageInfoDetail>();
    
     /**
     * @fieldName: status
     * @fieldType: String
     * @Description: 应用包状态
     */
    private String status;
    
    
    /**
     * @Title: addDetail
     * @Description: 添加明细
     * @param detail
     * @return: void
     */
    public void addDetail(AppPackageInfoDetail detail) {
        detail.setAppPackageInfo(this);
        this.details.add(detail);
        refreshQuantity(detail);
    }
    
    /**
     * @Title: addDetail
     * @Description: 删除明细
     * @param detail
     * @return: void
     */
    public void removeDetail(AppPackageInfoDetail detail) {
    	refreshQuantity(detail);
    }
    
    /**
     * @Title: refreshQuantity
     * @Description:  刷新应用包数量
     * @return: void
     */
    public void refreshQuantity(AppPackageInfoDetail det) {
        this.quantity = this.details.size();
        Double totalFileSize = 0d;
        Long maxNumber = 1L;
        for (AppPackageInfoDetail detail : details) {
            totalFileSize = DoubleUtils.add(new Double[]{totalFileSize, detail.getAppInfo().getFileSize()});
            if(detail.getLineNo() != null){
                if(detail.getLineNo() > maxNumber){
                    maxNumber = detail.getLineNo(); 
                }
            }
        }
        ++maxNumber;
        this.size = totalFileSize;
        det.setLineNo(maxNumber);       // LineNo
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public Double getSize() {
    return size;
    }

    public void setSize(Double size) {
    this.size = size;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public Set<AppPackageInfoDetail> getDetails() {
    return details;
    }

    public void setDetails(Set<AppPackageInfoDetail> details) {
    this.details = details;
    }

    public String getStatus() {
    return status;
    }

    public void setStatus(String status) {
    this.status = status;
    }

    public Integer getQuantity() {
    return quantity;
    }

    public void setQuantity(Integer quantity) {
    this.quantity = quantity;
    }

    public AppPackageType getAppPackageType() {
    return appPackageType;
    }

    public void setAppPackageType(AppPackageType appPackageType) {
    this.appPackageType = appPackageType;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
 
}
