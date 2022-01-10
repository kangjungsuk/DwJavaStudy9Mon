package javastudy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudyJava0929_2 {

	public static void main(String[] args) {
		StudyJava0929_2_sub s = new StudyJava0929_2_sub();

	}

}
class StudyJava0929_2_sub extends Frame implements ActionListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Button btnJoin = new Button("가입");
	Button btnCancel = new Button("취소");
	Button btnIdCheck = new Button("중복체크");
	
	TextField tfName = new TextField(15);
	TextField tfHp = new TextField(15);
	TextField tfId = new TextField(15);
	TextField tfPw = new TextField(15);
	TextField tfPw2 = new TextField(15);
	
	Label lbTitle =new Label("[ 회 원 가 입 ]");
	Label lbName =new Label("이  름 :");
	Label lbHp =  new Label("전  번 :");
	Label lbId =  new Label("아이디 :");
	Label lbPw =  new Label("비  번 :");
	Label lbPw2 = new Label("비번확인:");
	
	Label lbAlram = new Label("");
	///////////////////////////////////////
	String name="";
	String hp="";
	String id="";
	String pw="";
	String pw2="";
	
	StudyJava0929_2_sub()
	{
		super("자바공부");
		this.centerXYSet(); // 센터배치를 위해서 메서드로 정리
		
		this.init(); //화면구성 메서드호출
		this.start(); //이벤트및스레드등 호출		
		
		
	}	
	void centerXYSet()
	{
		this.setSize(500, 450);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);		
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}
	void init()
	{
		//앱솔루트 셋팅을 위해 null셋팅
		this.setLayout(null);	
		
		Font font = new Font("궁서", Font.BOLD, 20);
		lbTitle.setBounds(170, 40, 150, 40); this.add(lbTitle);
		lbTitle.setFont(font);
		
		lbName.setBounds(120, 100, 50, 40); this.add(lbName);
		lbHp.setBounds(120, 150, 50, 40); this.add(lbHp);
		lbId.setBounds(120, 200, 50, 40); this.add(lbId);
		lbPw.setBounds(120, 250, 50, 40); this.add(lbPw);
		lbPw2.setBounds(120, 300, 60, 40); this.add(lbPw2);
		
		tfName.setBounds(200, 100, 120, 30); this.add(tfName);
		tfHp.setBounds(200, 150, 120, 30); this.add(tfHp);
		tfId.setBounds(200, 200, 120, 30); this.add(tfId);
		
		btnIdCheck.setBounds(350, 200, 120, 30); this.add(btnIdCheck);
		
		tfPw.setBounds(200, 250, 120, 30); this.add(tfPw);
		tfPw2.setBounds(200, 300, 120, 30); this.add(tfPw2);
		
		
		btnJoin.setBounds(150, 350, 80, 40); this.add(btnJoin);
		btnCancel.setBounds(250, 350, 80, 40); this.add(btnCancel);
		
		lbAlram.setBounds(180, 400, 150, 40); this.add(lbAlram);
		
		
		
		
	}	
	void start()
	{		
		btnJoin.addActionListener(this);
		btnCancel.addActionListener(this);
		btnIdCheck.addActionListener(this);
		//윈도우우측상단 X 닫기 활성화
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	void dialog(String msg)
	{
		final Dialog dlg = new Dialog(this, "확인", true);
		dlg.setLayout(new BorderLayout());		
		dlg.add("Center", new Label(msg, Label.CENTER));
		Button bt = new Button("확인");
		Panel pp = new Panel(new FlowLayout());
		pp.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dlg.setVisible(false);
			}
		});
		dlg.add("South", pp);
		dlg.setSize(300, 100);
		
		//중앙배치
		Dimension dimen, dimen1;
		int xpos, ypos;
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = dlg.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		dlg.setLocation(xpos, ypos);
		
		
		dlg.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin)
		{
			//데이타바인딩처리...
			name = tfName.getText().trim();
			hp = tfHp.getText().trim();
			id = tfId.getText().trim();
			pw = tfPw.getText().trim();
			pw2 = tfPw2.getText().trim();
			
			//공백예외처리
			if(name.equals("")) {
				lbAlram.setText("이름을입력하시오."); 
				dialog("이름 입력하시오.");
				System.out.println("이름 입력하시오.");
				return;
			
			}
			if(hp.equals("")) {
				lbAlram.setText("전화번호를 입력하시오."); 
				dialog("전화번호를 입력하시오.");
				System.out.println("전화번호를 입력하시오.");
				return;
			
			}
			if(id.equals("")) {
				lbAlram.setText("아이디를 입력하시오."); 
				dialog("아이디를 입력하시오.");
				System.out.println("아이디를 입력하시오.");
				return;
			
			}
			if(pw.equals("")) {
				lbAlram.setText("비번을 입력하시오."); 
				dialog("비번을 입력하시오.");
				System.out.println("비번을 입력하시오.");
				return;
			
			}
			
			
			//제어처리하는곳...
			if(!pw.equals(pw2))
			{
				//라벨출력
				lbAlram.setText("비번이 서로 다릅니다. 확인!");
				//콘솔출력
				System.out.println("비번이 서로 다릅니다!");
				//대화상자호출
				dialog("비번이 서로 다릅니다!");
				return;
			}
			
			
			lbAlram.setText("회원가입이 정상적으로 처리완료."); 
			dialog("회원가입이 정상적으로 처리완료.");
			System.out.println("회원가입이 정상적으로 처리완료.");
			
			System.out.println("이름 ="+name);
			System.out.println("전번 ="+hp);
			System.out.println("아이디 ="+id);
			System.out.println("비번 ="+pw);
			System.out.println("비번확인 ="+pw2);
			
			//디비에 삽입
			insert(name,hp,id,pw,pw2);	
		}
		else if(e.getSource()==btnCancel)
		{
			System.exit(-1);
		}else if(e.getSource()==btnIdCheck)
		{
			if(tfId.getText().equals(""))
			{
				lbAlram.setText("아이디를 입력하세요.");
				return;
			}
			
			idCheck(tfId.getText());
			
			
		}
		
	}
	
	void idCheck(String inputId)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가없음. 체크요망");
			System.exit(0);
		}
		
		
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=utf8";		
		String id = "root";
		String pass = "qwer";
		
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {			
			conn = DriverManager.getConnection(url, id, pass);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			boolean idCheck = false; //중복체크를 했냐안했냐 체크...
			while (rs.next()) {				
				
				//아이디를 비교
				if(inputId.equals(rs.getString(4)))
				{
					lbAlram.setText("이미 아이디가 존재합니다.");
					idCheck =false;
					break;
				}
				
				if(!inputId.equals(rs.getString(4)))
				{
					lbAlram.setText("가입가능한 아이디입니다.");
					idCheck =true;
					
				}
			}
			
			if(idCheck == true)
			{
				btnIdCheck.setEnabled(false);
				tfId.setEnabled(false);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	//데이타베이스에 접속후 테이블에 삽입.
	void insert(String name,String hp,String id,String pw,String pw2)
	{
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이브가 있습니당~! ^_^v");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 없음!!");
		}

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=utf8";		
		String user = "root";// ID
		String password = "qwer";// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결되었습니다.");
		} catch (SQLException ee) {
			System.err.println("연결객체 생성실패!!");
		}

		String query = "select * from member";
		Statement stmt = null;
		String pquery = "insert into member values (null, ?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, name);
			pstmt.setString(2, hp);
			pstmt.setString(3, id);
			pstmt.setString(4, pw);
			pstmt.setString(5, pw2);
			
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int num = rs.getInt("idx");
				String tempName = rs.getString("name");
				System.out.println(num + " : " + tempName);
			}
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		// 5. Close 작업
		try {
			rs.close();
			pstmt.close();
			stmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}