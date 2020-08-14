package com.changgou.user.pojo;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:SysPermission构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="sys_permission")
public class SysPermission implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//编号

    @Column(name = "permission_NAME")
	private String permissionNAME;//菜单名称

    @Column(name = "permission_url")
	private String permissionUrl;//菜单地址

    @Column(name = "parent_id")
	private Integer parentId;//父菜单id



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getPermissionNAME() {
		return permissionNAME;
	}

	//set方法
	public void setPermissionNAME(String permissionNAME) {
		this.permissionNAME = permissionNAME;
	}
	//get方法
	public String getPermissionUrl() {
		return permissionUrl;
	}

	//set方法
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	//get方法
	public Integer getParentId() {
		return parentId;
	}

	//set方法
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


}
