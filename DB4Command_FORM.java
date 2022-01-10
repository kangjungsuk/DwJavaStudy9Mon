package javastudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudyJava1008_1 {

	public static void main(String[] args) {	
		DbCommand dbTest = new DbCommand();
	}
}

class DbCommand{
	
	//��ĳ��
	Scanner sc = new Scanner(System.in);
	
	//================================
	//������� ������
	//================================
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_test?useUnicode=true&characterEncoding=utf8";		
	String id = "root";
	String pass = "qwer";	
	
	
	Statement stmt = null;		
	ResultSet rs = null;
	
	//=================================
	
	DbCommand()
	{
		
		System.out.println("===========================");
		System.out.println("=����Ÿ���̽� ��� �׽�Ʈ���α׷�==");
		System.out.println("===========================");
		
		//����̺�üũ
		dbDriverCheck();
		
		//��������
		int select;		
		while(true)
		{
			System.out.println("1.ȸ���Է�/2.ȸ����ȸ/3.ȸ������/4.ȸ������/5.����");			
			System.out.print("����:");
			select = sc.nextInt();
			if(select == 1) {	
				//db�� ����ó��
				insert();
			}
			else if(select == 2) {
				//db���� ��ȸó��
				select();			
			
			}
			else if(select == 3) {				
				update();				
			}
			else if(select == 4) {				
				//db���� ����ó��;
				delete();				
			}
			else if(select == 5) {
				System.out.println("���α׷� ����.");	
				break;
			}
		}	
	}
	void dbDriverCheck()
	{
		//�ڹ� ���� ����̺� üũ
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡����. üũ���");
			System.exit(0);
		}		

		
	}
	void insert()
	{

		//��� ���Ե� ���� �Է� ����
		System.out.print("ȸ�����̵�:"); 	String inputId = sc.next();
		System.out.print("ȸ���н�����:"); 	String inputPw = sc.next();
		System.out.print("ȸ���̸�:"); 	String inputName = sc.next();
		
		//��������
		String query = "INSERT INTO member (idx, id, pw, name) "
				+ "VALUES (null, '"+inputId+"', '"+inputPw+"', '"+inputName+"')";		
		
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			stmt.executeUpdate(query);			
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void update()
	{

		//���� ����� ���̵� �������� ������ ��ȸ�ؼ� ���� ���� �ľ�
		System.out.println("������ ���̵�:"); String inputId = sc.next(); 
		select_update(inputId);
		
						 	
		System.out.print("������ ��й�ȣ�Է�:");  String inputPw = sc.next();
		System.out.print("������ �̸��Է�:"); 	  String inputName = sc.next();
		
		//��������
		String query = "UPDATE member SET pw ='"+inputPw+"', name = '"+ inputName+"' where id = '" + inputId + "'";						
		
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			stmt.executeUpdate(query);			
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	void select_update(String inputId)
	{
				
		System.out.println("--���� ��� ���� --");	
		//��������
		String query = "select * from member where id='"+inputId+"'";
		
		//���� �� ��ȸ
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//��ȸ
			while (rs.next()) {
				System.out.println("idx:" +rs.getInt("idx"));
				System.out.println("���� ���̵�:" + rs.getString("id"));
				System.out.println("���� ���:" + rs.getString("pw"));				
				System.out.println("���� �̸�:" + rs.getString("name"));
				
			}	
			System.out.println(); //�ٹٲ�ó���ѹ�..
			System.out.println(); //�ٹٲ�ó���ѹ�..
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void select()
	{
				
		System.out.println("--���� ȸ�� ����Ʈ --");	
		//��������
		String query = "select * from member";
		
		//���� �� ��ȸ
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//��ȸ
			while (rs.next()) {
				System.out.print("idx:" +rs.getInt("idx"));
				System.out.print(" / ���̵�:" + rs.getString("id"));
				System.out.print(" / ���:" + rs.getString("pw"));				
				System.out.println(" / �̸�:" + rs.getString("name"));
				
			}	
			System.out.println(); //�ٹٲ�ó���ѹ�..
			System.out.println(); //�ٹٲ�ó���ѹ�..
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	
	void delete()
	{
			
		System.out.print("������ ȸ�� ���̵� : ");			
		String inputId = sc.next();
		
		//��������
		String query = "delete from member where id = '" + inputId +"'";						
		try {			
			conn = DriverManager.getConnection(url, id, pass);
			
			stmt = conn.createStatement();
			stmt.executeUpdate(query);			
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}	
	

}


