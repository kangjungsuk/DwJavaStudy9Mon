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
	//��񿡼� �����ͼ� ������ ���̵�/��� ���� ����
	String db_id = "";  String db_pw="";
	
	
	Label lbTitle = new Label("�α���ȭ��");
	Label lbId = new Label("id : ");
	Label lbPw = new Label("pw : ");
	Button btnLogin = new Button("�α���");
	
	TextField tfId = new TextField(10);
	TextField tfPw = new TextField(10);
	
	Label lbResult = new Label("Id/pw�� �Է��ϼ���.");
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	StudyJava0929_1_Sub()
	{
		super("����1");
		this.init(); //ȭ�鱸�� �޼���ȣ��
		this.start(); //�̺�Ʈ�׽������ ȣ��
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
		//������ ���� �ٱ������� ����		
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
		
		
		
		
		//������������ X �ݱ� Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		//���� �Է��� �ؽ�Ʈ�ʵ忡�� �����°�
		String tempId = tfId.getText();
		String tempPw = tfPw.getText();	
	
		//��񿡼� �о���̴� �޼���
		getInfo(tempId, tempPw);
		

		
	}
	
	
	void getInfo(String inputId, String inputPw)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡����. üũ���");
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
				
				//���̵� ��
				if(inputId.equals(rs.getString(4)))
				{
					//�����.
					if(inputPw.equals(rs.getString(5)))
					{
						lbResult.setText("�α��� �Ͽ����ϴ�.");
						System.out.println("�α��εȾ��̵�/��� \n������̵�:"+ rs.getString(4) + " / �����й�ȣ:" + rs.getString(5));
						break;
					}
					else
					{
						lbResult.setText("����� �ٸ��ϴ�.");
						break;
					}
				}
				else
				{
					lbResult.setText("���̵� �������� �ʽ��ϴ�.");
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
