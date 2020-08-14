package com.changgou.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:SysRolePermission构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="sys_role_permission")
public class SysRolePermission implements Serializable{

	@Id
    @Column(name = "RID")
	private Integer RID;//角色编号

    @Column(name = "PID")
	private Integer PID;//权限编号



	//get方法
	public Integer getRID() {
		return RID;
	}

	//set方法
	public void setRID(Integer RID) {
		this.RID = RID;
	}
	//get方法
	public Integer getPID() {
		return PID;
	}

	//set方法
	public void setPID(Integer PID) {
		this.PID = PID;
	}


}
