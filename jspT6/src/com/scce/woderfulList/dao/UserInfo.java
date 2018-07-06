package com.scce.woderfulList.dao;

//用户信息实体类
public class UserInfo {
	private	String account;//账号
	private String password;//密码
	private int type;//用户类型，1为管理员，0为普通用户
	private int online;//在线离线状态，1为在线，0为离线
	private String sex;//性别
	private String nickname;//用户昵称
	
	public void UserInfoDao(){}
	
	public void UserInfoDao(String account,String password){
		this.account = account;
		this.password = password;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
