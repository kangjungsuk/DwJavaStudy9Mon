package javastudy;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudyJava0915_1 {

	public static void main(String[] args) {
		StudyJava0915_1_sub ss = new StudyJava0915_1_sub();

	}

}

class StudyJava0915_1_sub extends Frame implements ItemListener{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	//���̾ƿ�
	private Choice ch = new Choice();
	private List li = new List(5, false);
	
	Label lbAlram = new Label("���: ������Դϴ�......");
	
	
	StudyJava0915_1_sub()
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
		ch.setBounds(100, 100, 100, 20); 
		ch.add("ȫ�浿");
		ch.add("�̼���");
		ch.add("�����ҹ�");
		this.add(ch);
		li.setBounds(250, 100, 100, 100); 
		li.add("�Ѹ�");
		li.add("��浿");
		li.add("�����");
		li.add("��ġ");
		li.add("������");
		this.add(li);
		
		lbAlram.setBounds(100, 220, 250, 20); this.add(lbAlram);
		
	}	
	void start()
	{		
		ch.addItemListener(this);
		li.addItemListener(this);
		
		
		//������������ X �ݱ� Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == ch)
		{
			System.out.println(ch.getSelectedItem());
			lbAlram.setText("���: ���̽����� �����Ѱ��� = "+ ch.getSelectedItem());
		}else if(e.getSource() == li)
		{
			String temp = li.getSelectedItem();
			System.out.println(temp);
			lbAlram.setText("���: ����Ʈ���� �����Ѱ��� = "+ temp);
		}
		
	}
	
}

