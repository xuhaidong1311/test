package com.scce.woderfulList.dao;

//������Ϣʵ����
public class UserChat {
	private String id;//��Ϣ��ID
	private String info;//������Ϣ������
	private String time;//������Ϣ��ʱ��
	private String sender;//������
	private String color;//��Ϣ���ֵ���ɫ
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
