package com.changgou.user.pojo;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:SysRole构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="sys_role")
public class SysRole implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//编号

    @Column(name = "ROLE_NAME")
	private String ROLENAME;//角色名称

    @Column(name = "ROLE_DESC")
	private String ROLEDESC;//角色描述



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getROLENAME() {
		return ROLENAME;
	}

	//set方法
	public void setROLENAME(String ROLENAME) {
		this.ROLENAME = ROLENAME;
	}
	//get方法
	public String getROLEDESC() {
		return ROLEDESC;
	}

	//set方法
	public void setROLEDESC(String ROLEDESC) {
		this.ROLEDESC = ROLEDESC;
	}


}
