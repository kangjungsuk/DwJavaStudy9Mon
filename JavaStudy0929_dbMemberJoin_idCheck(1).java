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
	
	Button btnJoin = new Button("����");
	Button btnCancel = new Button("���");
	Button btnIdCheck = new Button("�ߺ�üũ");
	
	TextField tfName = new TextField(15);
	TextField tfHp = new TextField(15);
	TextField tfId = new TextField(15);
	TextField tfPw = new TextField(15);
	TextField tfPw2 = new TextField(15);
	
	Label lbTitle =new Label("[ ȸ �� �� �� ]");
	Label lbName =new Label("��  �� :");
	Label lbHp =  new Label("��  �� :");
	Label lbId =  new Label("���̵� :");
	Label lbPw =  new Label("��  �� :");
	Label lbPw2 = new Label("���Ȯ��:");
	
	Label lbAlram = new Label("");
	///////////////////////////////////////
	String name="";
	String hp="";
	String id="";
	String pw="";
	String pw2="";
	
	StudyJava0929_2_sub()
	{
		super("�ڹٰ���");
		this.centerXYSet(); // ���͹�ġ�� ���ؼ� �޼���� ����
		
		this.init(); //ȭ�鱸�� �޼���ȣ��
		this.start(); //�̺�Ʈ�׽������ ȣ��		
		
		
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
		//�ۼַ�Ʈ ������ ���� null����
		this.setLayout(null);	
		
		Font font = new Font("�ü�", Font.BOLD, 20);
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
		//������������ X �ݱ� Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	void dialog(String msg)
	{
		final Dialog dlg = new Dialog(this, "Ȯ��", true);
		dlg.setLayout(new BorderLayout());		
		dlg.add("Center", new Label(msg, Label.CENTER));
		Button bt = new Button("Ȯ��");
		Panel pp = new Panel(new FlowLayout());
		pp.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dlg.setVisible(false);
			}
		});
		dlg.add("South", pp);
		dlg.setSize(300, 100);
		
		//�߾ӹ�ġ
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
			//����Ÿ���ε�ó��...
			name = tfName.getText().trim();
			hp = tfHp.getText().trim();
			id = tfId.getText().trim();
			pw = tfPw.getText().trim();
			pw2 = tfPw2.getText().trim();
			
			//���鿹��ó��
			if(name.equals("")) {
				lbAlram.setText("�̸����Է��Ͻÿ�."); 
				dialog("�̸� �Է��Ͻÿ�.");
				System.out.println("�̸� �Է��Ͻÿ�.");
				return;
			
			}
			if(hp.equals("")) {
				lbAlram.setText("��ȭ��ȣ�� �Է��Ͻÿ�."); 
				dialog("��ȭ��ȣ�� �Է��Ͻÿ�.");
				System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�.");
				return;
			
			}
			if(id.equals("")) {
				lbAlram.setText("���̵� �Է��Ͻÿ�."); 
				dialog("���̵� �Է��Ͻÿ�.");
				System.out.println("���̵� �Է��Ͻÿ�.");
				return;
			
			}
			if(pw.equals("")) {
				lbAlram.setText("����� �Է��Ͻÿ�."); 
				dialog("����� �Է��Ͻÿ�.");
				System.out.println("����� �Է��Ͻÿ�.");
				return;
			
			}
			
			
			//����ó���ϴ°�...
			if(!pw.equals(pw2))
			{
				//�����
				lbAlram.setText("����� ���� �ٸ��ϴ�. Ȯ��!");
				//�ܼ����
				System.out.println("����� ���� �ٸ��ϴ�!");
				//��ȭ����ȣ��
				dialog("����� ���� �ٸ��ϴ�!");
				return;
			}
			
			
			lbAlram.setText("ȸ�������� ���������� ó���Ϸ�."); 
			dialog("ȸ�������� ���������� ó���Ϸ�.");
			System.out.println("ȸ�������� ���������� ó���Ϸ�.");
			
			System.out.println("�̸� ="+name);
			System.out.println("���� ="+hp);
			System.out.println("���̵� ="+id);
			System.out.println("��� ="+pw);
			System.out.println("���Ȯ�� ="+pw2);
			
			//��� ����
			insert(name,hp,id,pw,pw2);	
		}
		else if(e.getSource()==btnCancel)
		{
			System.exit(-1);
		}else if(e.getSource()==btnIdCheck)
		{
			if(tfId.getText().equals(""))
			{
				lbAlram.setText("���̵� �Է��ϼ���.");
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
			boolean idCheck = false; //�ߺ�üũ�� �߳ľ��߳� üũ...
			while (rs.next()) {				
				
				//���̵� ��
				if(inputId.equals(rs.getString(4)))
				{
					lbAlram.setText("�̹� ���̵� �����մϴ�.");
					idCheck =false;
					break;
				}
				
				if(!inputId.equals(rs.getString(4)))
				{
					lbAlram.setText("���԰����� ���̵��Դϴ�.");
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
	
	//����Ÿ���̽��� ������ ���̺� ����.
	void insert(String name,String hp,String id,String pw,String pw2)
	{
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("����̺갡 �ֽ��ϴ�~! ^_^v");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺� ����!!");
		}

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=utf8";		
		String user = "root";// ID
		String password = "qwer";// ��й�ȣ
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("����Ǿ����ϴ�.");
		} catch (SQLException ee) {
			System.err.println("���ᰴü ��������!!");
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
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
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
			System.err.println("������ ȹ�����!!");
		}
		// 5. Close �۾�
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
			System.err.println("�ݱ� ����~!!");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}