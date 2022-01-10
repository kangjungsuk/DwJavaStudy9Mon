package javastudy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class StudyJava0914_3 {
	public static void main(String[] args) {
		StudyJava0914_3_Sub a = new StudyJava0914_3_Sub();
	}
}
class StudyJava0914_3_Sub extends Frame implements FocusListener, ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	//====================================
	//���̾ƿ� ����
	Label lbName = new Label("��   �� =");
	Label lbJumin = new Label("�ֹι�ȣ =");
	Label lbAlrim = new Label("�˸� :  �����..");
	
	TextField tfName = new TextField(30);
	TextField tfJumin1 = new TextField(15);
	TextField tfJumin2 = new TextField(15);
	
	Button btnOk = new Button("Ȯ��");
	Button btnCancel = new Button("���");
	
	StudyJava0914_3_Sub()
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

		lbName.setBounds(100, 150, 70, 20);
		tfName.setBounds(170, 150, 200, 20);
		lbJumin.setBounds(100, 180, 70, 20);
		tfJumin1.setBounds(170, 180, 100, 20);
		tfJumin2.setBounds(270, 180, 100, 20);
		
		btnOk.setBounds(270, 210, 45, 20);
		btnCancel.setBounds(320, 210, 45, 20);
		
		
		lbAlrim.setBounds(100, 310, 250, 20);
		
		
		this.add(lbName);
		this.add(tfName);
		this.add(lbJumin);
		this.add(tfJumin1);
		this.add(tfJumin2);
		this.add(btnOk);
		this.add(btnCancel);
		this.add(lbAlrim);
		
		
	}	
	void start()
	{	
		tfJumin1.addFocusListener(this);
		tfJumin2.addFocusListener(this);
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		
		//������������ X �ݱ� Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==tfJumin1)
		{
			int x = tfName.getText().trim().length();
			if(x == 0) {
				tfName.requestFocus();
				tfJumin1.setText("");
				System.out.println("�̸����Է����ּ���.");
			}
		}else if(e.getSource()==tfJumin2)
		{
			int x = tfJumin1.getText().trim().length();
			if(x != 6) {
				tfJumin1.setText("");
				tfJumin2.setText("");
				tfJumin1.requestFocus();
				
			}
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk)
		{
			
			if(tfName.getText().equals(""))
			{				
				lbAlrim.setText("�˸�  :  �̸��� �Է����ּ���.");
			}
			else if(tfJumin1.getText().equals(""))
			{				
				lbAlrim.setText("�˸�  :  �ֹι�ȣ���ڸ��� �Է����ּ���.");
			}
			else if(tfJumin2.getText().equals(""))
			{				
				lbAlrim.setText("�˸�  :  �ֹι�ȣ���ڸ��� �Է����ּ���.");
			}
			else
			{
				lbAlrim.setText("�˸� :  �����..");
			}
		}else if(e.getSource()==btnCancel)
		{
			System.exit(0);
		}
			
			
		
	}
		

}


