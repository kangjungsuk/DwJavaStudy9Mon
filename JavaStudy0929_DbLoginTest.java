package javastudy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StudyJava0929_1 {
	public static void main(String[] args) {
		StudyJava0929_1_Sub a = new StudyJava0929_1_Sub();

	}
}
class StudyJava0929_1_Sub extends Frame implements ActionListener{
	//디비에서 가져와서 저장할 아이디/비번 변수 선언
	String db_id = "";  String db_pw="";
	
	
	Label lbTitle = new Label("로그인화면");
	Label lbId = new Label("id : ");
	Label lbPw = new Label("pw : ");
	Button btnLogin = new Button("로그인");
	
	TextField tfId = new TextField(10);
	TextField tfPw = new TextField(10);
	
	Label lbResult = new Label("Id/pw를 입력하세요.");
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	StudyJava0929_1_Sub()
	{
		super("과제1");
		this.init(); //화면구성 메서드호출
		this.start(); //이벤트및스레드등 호출
		this.setSize(300, 250);
		this.centerXYSet();
		this.setVisible(true);
	}	
	void centerXYSet()
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()
	{
		//윈도우 가장 바깥프레임 셋팅		
		this.setLayout(null);
		
		lbTitle.setBounds(120, 50, 70, 20);
		lbId.setBounds(70, 100, 30, 20);
		lbPw.setBounds(70, 130, 30, 20);
		
		tfId.setBounds(100, 100, 120, 20);
		tfPw.setBounds(100, 130, 120, 20);
		
		lbResult.setBounds(100, 170, 150, 20);
		btnLogin.setBounds(120, 200, 80, 20);
		
		
		
		this.add(lbTitle);
		this.add(lbId);
		this.add(lbPw);
		this.add(tfId);
		this.add(tfPw);
		this.add(lbResult);
		this.add(btnLogin);
		
		
		
		
	}
	
	void start()
	{
		
		btnLogin.addActionListener(this);
		
		
		
		
		//윈도우우측상단 X 닫기 활성화
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		//내가 입력한 텍스트필드에서 가져온값
		String tempId = tfId.getText();
		String tempPw = tfPw.getText();	
	
		//디비에서 읽어들이는 메서드
		getInfo(tempId, tempPw);
		

		
	}
	
	
	void getInfo(String inputId, String inputPw)
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
			while (rs.next()) {				
				
				//아이디를 비교
				if(inputId.equals(rs.getString(4)))
				{
					//비번비교.
					if(inputPw.equals(rs.getString(5)))
					{
						lbResult.setText("로그인 하였습니다.");
						System.out.println("로그인된아이디/비번 \n현재아이디:"+ rs.getString(4) + " / 현대비밀번호:" + rs.getString(5));
						break;
					}
					else
					{
						lbResult.setText("비번이 다릅니다.");
						break;
					}
				}
				else
				{
					lbResult.setText("아이디가 존재하지 않습니다.");
				}
				

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	
	
	

}
