package com.scce.woderfulList.utilts;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库的链接关闭类
public class utilts {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String user = "c##xxx";
	private static final String password = "qwer";
	
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rst = null; 
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("链接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("链接出现异常");
		}
		return conn;
	}
	
	//关闭ResultSet、PreparedStatement、数据库的链接
	public static void close(ResultSet rst,PreparedStatement pst,Connection conn){//关闭数据库
		//先判断链接是否为null，然后在一步一步关闭，出异常的finally内容会正常执行，不会出现链接没有关闭的情况	
		if(rst!=null){
			try {
				rst.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet关闭异常");
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("PreparesStatement关闭异常");
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (Exception e) {
								System.out.println("Connection关闭异常");
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
