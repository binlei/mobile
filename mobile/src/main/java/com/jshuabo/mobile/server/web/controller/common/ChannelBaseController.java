/**
* Copyright©2014 www.yuanlianghe.cn. all rights reserved.
*
* @Title: ChannelBaseController.java
* @Prject: mobile
* @Package: com.jshuabo.mobile.server.web.controller.common
* @author: jing.huang
* @date: 2014年5月27日 下午5:33:54
* @version: v1.0
* @Description: 
*/
package com.jshuabo.mobile.server.web.controller.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jshuabo.frame.server.model.base.EasyuiTreeNode;
import com.jshuabo.frame.server.model.organization.Organization;
import com.jshuabo.frame.server.model.security.User;
import com.jshuabo.frame.server.service.organization.IOrganizationService;
import com.jshuabo.frame.server.util.json.JacksonUtils;

/**
 * @ClassName: ChannelBaseController
 * @Description: 
 * @author: jing.huang
 * @date: 2014年5月27日 下午5:33:54
 */
@Controller
@RequestMapping(value = "/channelBase")
public class ChannelBaseController {
    @Autowired
    private IOrganizationService organizationService;
  //获取当前用户合法渠道
    @RequestMapping(value = "/getLegalChannel", method = RequestMethod.GET)
    //@ResponseBody
    public void getLegalChannel(HttpServletRequest request, HttpServletResponse response) {
        String flag = request.getParameter("flag");
        List<EasyuiTreeNode> tree=new ArrayList<EasyuiTreeNode>();//树节点集合
        List<Organization> showOrganization = new ArrayList<Organization>();//渠道集合
        String id = request.getParameter("id");
        User user = (User) SecurityUtils.getSubject().getPrincipal();//获取当前用户
        Organization org = user.getOrganization();//当前用户所在渠道
        if("install".equals(flag)) {//装机 
            if("".equals(id)||id == null) {
                showOrganization.add(org);
                
                for(Organization o : showOrganization) {//将渠道集合包装成树集合
                    EasyuiTreeNode t=new EasyuiTreeNode();
                    t.setId(o.getId().toString());//渠道ID作为树节点id
                    t.setText(o.getName());//渠道名称作为树节点名称
                    if(organizationService.getChildOrganizations(o.getCode()).size() > 0) {//如果有下级渠道，将该节点状态设为折叠
                        t.setState("closed");
                    }
                    tree.add(t);
                }
            } else {
                Organization organization = organizationService.load(Long.parseLong(id));//根据id获取组织对象
                showOrganization = organizationService.getChildOrganizations(organization.getCode());
                for(Organization o : showOrganization) {
                    EasyuiTreeNode t=new EasyuiTreeNode();
                    t.setId(o.getId().toString());
                    t.setText(o.getName());
                    if(organizationService.getChildOrganizations(o.getCode()).size()>0) {
                        t.setState("closed");
                    }
                    tree.add(t);
                }
            }
        } else {//统计
            if("".equals(id)||id == null) {
                showOrganization.add(org);
                
                for(Organization o : showOrganization) {//将渠道集合包装成树集合
                    EasyuiTreeNode t=new EasyuiTreeNode();
                    t.setId(o.getCode());//渠道代码作为树节点id
                    t.setText(o.getName());//渠道名称作为树节点名称
                    if(organizationService.getChildOrganizations(o.getCode()).size() > 0) {//如果有下级渠道，将该节点状态设为折叠
                        t.setState("closed");
                    }
                    tree.add(t);
                }
            } else {
                showOrganization = organizationService.getChildOrganizations(id);
                for(Organization o : showOrganization) {
                    EasyuiTreeNode t=new EasyuiTreeNode();
                    t.setId(o.getCode());
                    t.setText(o.getName());
                    if(organizationService.getChildOrganizations(o.getCode()).size()>0) {
                        t.setState("closed");
                    }
                    tree.add(t);
                }
            }
        }
        try {
            response.getWriter().print(JacksonUtils.object2json(tree));//以json字符串返回
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
}
