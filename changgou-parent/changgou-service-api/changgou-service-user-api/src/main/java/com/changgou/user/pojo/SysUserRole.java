package com.changgou.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:SysUserRole构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="sys_user_role")
public class SysUserRole implements Serializable{

	@Id
    @Column(name = "UID")
	private Integer UID;//用户编号

    @Column(name = "RID")
	private Integer RID;//角色编号



	//get方法
	public Integer getUID() {
		return UID;
	}

	//set方法
	public void setUID(Integer UID) {
		this.UID = UID;
	}
	//get方法
	public Integer getRID() {
		return RID;
	}

	//set方法
	public void setRID(Integer RID) {
		this.RID = RID;
	}


}
