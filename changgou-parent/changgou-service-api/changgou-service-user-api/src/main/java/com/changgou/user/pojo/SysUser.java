package com.changgou.user.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:SysUser构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="sys_user")
public class SysUser implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

    @Column(name = "username")
	private String username;//用户名称

    @Column(name = "password")
	private String password;//密码

    @Column(name = "status")
	private Integer status;//1开启0关闭

	private List<SysRole> roles;


	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}
	//get方法
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
}
