package com.scce.woderfulList.utilts;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//���ݿ�����ӹر���
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
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ӳ����쳣");
		}
		return conn;
	}
	
	//�ر�ResultSet��PreparedStatement�����ݿ������
	public static void close(ResultSet rst,PreparedStatement pst,Connection conn){//�ر����ݿ�
		//���ж������Ƿ�Ϊnull��Ȼ����һ��һ���رգ����쳣��finally���ݻ�����ִ�У������������û�йرյ����	
		if(rst!=null){
			try {
				rst.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet�ر��쳣");
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("PreparesStatement�ر��쳣");
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (Exception e) {
								System.out.println("Connection�ر��쳣");
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
