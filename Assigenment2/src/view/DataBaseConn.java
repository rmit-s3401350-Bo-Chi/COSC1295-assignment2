package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConn {
	public static void Connect() {
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		
	try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/testyahoo1216?serverTimezone=UTC","root","1234");
	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
	      Statement stmt = connect.createStatement();
           ResultSet rs = stmt.executeQuery("create table Person");
	                                                              //user Ϊ��������
           connect.close();
	}
	catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	      }
	}
}
