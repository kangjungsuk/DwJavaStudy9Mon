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
	
	//스캐너
	Scanner sc = new Scanner(System.in);
	
	//================================
	//디비전용 변수들
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
		System.out.println("=데이타베이스 명령 테스트프로그램==");
		System.out.println("===========================");
		
		//드라이브체크
		dbDriverCheck();
		
		//변수선언
		int select;		
		while(true)
		{
			System.out.println("1.회원입력/2.회원조회/3.회원수정/4.회원삭제/5.종료");			
			System.out.print("선택:");
			select = sc.nextInt();
			if(select == 1) {	
				//db에 삽입처리
				insert();
			}
			else if(select == 2) {
				//db에서 조회처리
				select();			
			
			}
			else if(select == 3) {				
				update();				
			}
			else if(select == 4) {				
				//db에서 삭제처리;
				delete();				
			}
			else if(select == 5) {
				System.out.println("프로그램 종료.");	
				break;
			}
		}	
	}
	void dbDriverCheck()
	{
		//자바 연동 드라이브 체크
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가없음. 체크요망");
			System.exit(0);
		}		

		
	}
	void insert()
	{

		//디비에 삽입될 정보 입력 구간
		System.out.print("회원아이디:"); 	String inputId = sc.next();
		System.out.print("회원패스워드:"); 	String inputPw = sc.next();
		System.out.print("회원이름:"); 	String inputName = sc.next();
		
		//쿼리생성
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

		//수정 대상의 아이디를 기준으로 정보를 조회해서 현재 정보 파악
		System.out.println("수정할 아이디:"); String inputId = sc.next(); 
		select_update(inputId);
		
						 	
		System.out.print("수정할 비밀번호입력:");  String inputPw = sc.next();
		System.out.print("수정할 이름입력:"); 	  String inputName = sc.next();
		
		//쿼리생성
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
				
		System.out.println("--수정 대상 정보 --");	
		//쿼리생성
		String query = "select * from member where id='"+inputId+"'";
		
		//접속 및 조회
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//조회
			while (rs.next()) {
				System.out.println("idx:" +rs.getInt("idx"));
				System.out.println("현재 아이디:" + rs.getString("id"));
				System.out.println("현재 비번:" + rs.getString("pw"));				
				System.out.println("현재 이름:" + rs.getString("name"));
				
			}	
			System.out.println(); //줄바꿈처리한번..
			System.out.println(); //줄바꿈처리한번..
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void select()
	{
				
		System.out.println("--현재 회원 리스트 --");	
		//쿼리생성
		String query = "select * from member";
		
		//접속 및 조회
		try {			
			conn = DriverManager.getConnection(url, id, pass);			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//조회
			while (rs.next()) {
				System.out.print("idx:" +rs.getInt("idx"));
				System.out.print(" / 아이디:" + rs.getString("id"));
				System.out.print(" / 비번:" + rs.getString("pw"));				
				System.out.println(" / 이름:" + rs.getString("name"));
				
			}	
			System.out.println(); //줄바꿈처리한번..
			System.out.println(); //줄바꿈처리한번..
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	
	void delete()
	{
			
		System.out.print("삭제할 회원 아이디 : ");			
		String inputId = sc.next();
		
		//쿼리생성
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


