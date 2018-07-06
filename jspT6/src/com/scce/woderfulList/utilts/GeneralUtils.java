package com.scce.woderfulList.utilts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralUtils {
	//Ĭ��ʱ���ת����ʽ
	private static final String FORMART_DATE = "yyyy-MM-dd HH:mm:ss";
	public static String BEGINTIME;
	public static String ENDTIME;
	public static String BEGINHOUR;
	public static String ENDHOUR;
	
	public static String formartDateToString(Date date){
		//ʵ����SimpleDateFormart ��������ת������
		SimpleDateFormat sdf = new SimpleDateFormat(FORMART_DATE);
		//������ת��Ϊ�ַ���
		String result = sdf.format(date);
		return result;
	}
	
	//�Ƚϵ�ǰϵͳʱ���Ƿ���ڵ��������ҽ���ʱ��
	public static boolean comparetoTime(int time,boolean target){
		Date currentTime = new Date();
		String strTime = formartDateToString(currentTime);
		//����""�ָ��ַ�������ȡʱ���ʽΪHH��mm��ss
		strTime = strTime.split(" ")[1];
		//���ַ���ת��Ϊ����
		String[] times = strTime.split(":");
		String cTime = "";
		//��ʱ����ƴ�ӳ�HHmmss��ʽ���ַ���
		for(int i=0;i<times.length;i++){
			cTime+=times[i];
		}
		int intTime = Integer.parseInt(cTime);
		//�Ƚϵ�ǰʱ����������ͣ��ʱ��
		if(target){
			//����ֵ�����������ǰ�ߣ�����������򷵻غ���
			return (intTime>=time)?true:false;
		}else{
			//�Ƚϵ�ǰʱ���������ҿ���ʱ��
			return (intTime<=time)?true:false;
		}
	}
}
