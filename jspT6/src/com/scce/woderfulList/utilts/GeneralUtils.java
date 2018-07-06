package com.scce.woderfulList.utilts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralUtils {
	//默认时间的转换格式
	private static final String FORMART_DATE = "yyyy-MM-dd HH:mm:ss";
	public static String BEGINTIME;
	public static String ENDTIME;
	public static String BEGINHOUR;
	public static String ENDHOUR;
	
	public static String formartDateToString(Date date){
		//实例化SimpleDateFormart 对象，用于转换日期
		SimpleDateFormat sdf = new SimpleDateFormat(FORMART_DATE);
		//将日期转换为字符串
		String result = sdf.format(date);
		return result;
	}
	
	//比较当前系统时间是否大于等于聊天室结束时间
	public static boolean comparetoTime(int time,boolean target){
		Date currentTime = new Date();
		String strTime = formartDateToString(currentTime);
		//按照""分割字符串，获取时间格式为HH：mm：ss
		strTime = strTime.split(" ")[1];
		//将字符串转换为数字
		String[] times = strTime.split(":");
		String cTime = "";
		//将时分秒拼接成HHmmss格式的字符串
		for(int i=0;i<times.length;i++){
			cTime+=times[i];
		}
		int intTime = Integer.parseInt(cTime);
		//比较当前时间于聊天室停播时间
		if(target){
			//返回值如果成立返回前者，如果不成立则返回后者
			return (intTime>=time)?true:false;
		}else{
			//比较当前时间与聊天室开放时间
			return (intTime<=time)?true:false;
		}
	}
}
