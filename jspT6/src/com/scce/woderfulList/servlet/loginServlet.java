package com.scce.woderfulList.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scce.woderfulList.dao.UserInfo;
import com.scce.woderfulList.dao.UserInfoDao;
import com.scce.woderfulList.utilts.GeneralUtils;

public class loginServlet extends HttpServlet {

	public static Map<String,HttpSession> sessionMap=new ConcurrentHashMap<String,HttpSession>();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//����һ�����󣬻�ȡ����ķ��������˺�����ȶ����ݿ���˺����룬Ȼ����˺���������Ӧ����Ϣ��װ�������Ķ�����
		UserInfoDao userDao = new UserInfoDao();
		UserInfo userInfo = userDao.queryUserInfo(account, password);
		if(userInfo!=null){//����˺�������ȷ
			//�Աȶ���������ǹ���Ա������ͨ�û�
			if(userInfo.getType()!=1){
				//----------������comparetoTime �Ա�ʱ�䷽��
				boolean bFlag = GeneralUtils.comparetoTime(Integer.parseInt(GeneralUtils.BEGINTIME), false);
				boolean eFlag = GeneralUtils.comparetoTime(Integer.parseInt(GeneralUtils.ENDTIME), true);
			if(bFlag){
				request.setAttribute("msg", "����"+GeneralUtils.BEGINHOUR+"����½");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else if(eFlag){
				request.setAttribute("msg", "����"+GeneralUtils.ENDHOUR+"��ǰ��½");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				//�û���½�ɹ����û�����״̬�޸�Ϊ1����ʾ����
				
			}
				
			}
		}else{//�˺��������
			//��������Ϣ��������½ҳ��
			request.setAttribute("account", account);
			request.setAttribute("msg2", "�˺Ż����벻��ȷ");
			//���ص�½����
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
}
