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
		//创建一个对象，获取对象的方法传入账号密码比对数据库的账号密码，然后把账号密码所对应的信息封装到创建的对象里
		UserInfoDao userDao = new UserInfoDao();
		UserInfo userInfo = userDao.queryUserInfo(account, password);
		if(userInfo!=null){//如果账号密码正确
			//对比对象的类型是管理员还是普通用户
			if(userInfo.getType()!=1){
				//----------不明白comparetoTime 对比时间方法
				boolean bFlag = GeneralUtils.comparetoTime(Integer.parseInt(GeneralUtils.BEGINTIME), false);
				boolean eFlag = GeneralUtils.comparetoTime(Integer.parseInt(GeneralUtils.ENDTIME), true);
			if(bFlag){
				request.setAttribute("msg", "请在"+GeneralUtils.BEGINHOUR+"点后登陆");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else if(eFlag){
				request.setAttribute("msg", "请在"+GeneralUtils.ENDHOUR+"点前登陆");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				//用户登陆成功后用户在线状态修改为1，表示在线
				
			}
				
			}
		}else{//账号密码错误
			//将错误信息保存至登陆页面
			request.setAttribute("account", account);
			request.setAttribute("msg2", "账号或密码不正确");
			//返回登陆界面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
}
