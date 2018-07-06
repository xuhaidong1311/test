package com.scce.woderfulList.dao;

//发送信息实体类
public class UserChat {
	private String id;//信息的ID
	private String info;//发送信息的内容
	private String time;//发送信息的时间
	private String sender;//发送人
	private String color;//信息文字的颜色
	
	
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
