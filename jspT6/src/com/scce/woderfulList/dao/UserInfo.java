package com.scce.woderfulList.dao;

//�û���Ϣʵ����
public class UserInfo {
	private	String account;//�˺�
	private String password;//����
	private int type;//�û����ͣ�1Ϊ����Ա��0Ϊ��ͨ�û�
	private int online;//��������״̬��1Ϊ���ߣ�0Ϊ����
	private String sex;//�Ա�
	private String nickname;//�û��ǳ�
	
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
