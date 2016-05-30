package com.hhy.bean;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private String url;
	private String uname;
	private String usign;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int uid,String url, String uname, String usign) {
		this.uid = uid;
		this.url = url;
		this.uname = uname;
		this.usign = usign;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsign() {
		return usign;
	}

	public void setUsign(String usign) {
		this.usign = usign;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"uid=" + uid +
				", url='" + url + '\'' +
				", uname='" + uname + '\'' +
				", usign='" + usign + '\'' +
				", flag='" + flag + '\'' +
				'}';
	}
}
