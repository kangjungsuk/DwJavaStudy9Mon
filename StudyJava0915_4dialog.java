package javastudy;

import java.awt.*;
import java.awt.event.*;

public class StudyJava0915_4 {

	public static void main(String[] args) {
		StudyJava0915_4_sub ss = new StudyJava0915_4_sub();

	}

}

class StudyJava0915_4_sub extends Frame implements MouseMotionListener, ActionListener  {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	//���̾ƿ�
	Button btn	= new Button("��ø");
	Label lbRight = new Label("�������");
	Label lbLeft = new Label("�������");
	Label lbJumin = new Label("�ֹι�ȣ :");
	Label lbDasi = new Label(" - ");
	
	TextField tfJumin1 = new TextField (10);
	TextField tfJumin2 = new TextField (10);
	
	
	StudyJava0915_4_sub()
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
		lbJumin.setBounds(80, 250, 70, 20); 	this.add(lbJumin);
		tfJumin1.setBounds(160, 250, 100, 20); 	this.add(tfJumin1);
		lbDasi.setBounds(270, 250, 30, 20); 	this.add(lbDasi);
		tfJumin2.setBounds(300, 250, 100, 20); 	this.add(tfJumin2);
		btn.setBounds(410, 250, 50, 20); 	this.add(btn);
		
		
		lbRight.setBounds(400, 30, 100, 20); 	this.add(lbRight);
		lbLeft.setBounds(30, 420, 100, 20); 	this.add(lbLeft);
		
	}	
	void start()
	{		
		this.addMouseMotionListener(this);
		btn.addActionListener(this);
		//������������ X �ݱ� Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int xpos = e.getX();
		int ypos = e.getY();
		lbRight.setText("x = " + xpos + ", y = " + ypos);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int xpos = e.getX();
		int ypos = e.getY();
		lbLeft.setText("x = " + xpos + ", y = " + ypos);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final Dialog dlg = new Dialog(this, "OK", true);
		dlg.setLayout(new BorderLayout());
		String sss = "ȸ�����԰���";
		dlg.add("Center", new Label(sss, Label.CENTER));		
		
		
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
		
		//�߾ӹ�ġ...
		Dimension dimen, dimen1;
		int xpos, ypos;
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = dlg.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);		
		dlg.setLocation(xpos, ypos);
		
		
		dlg.setVisible(true);
	}

	

	
	
	
	
	
	
	
	
	
}

