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
	//레이아웃
	private Choice ch = new Choice();
	private List li = new List(5, false);
	
	Label lbAlram = new Label("결과: 대기중입니다......");
	
	
	StudyJava0915_1_sub()
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
		ch.setBounds(100, 100, 100, 20); 
		ch.add("홍길동");
		ch.add("이순신");
		ch.add("연개소문");
		this.add(ch);
		li.setBounds(250, 100, 100, 100); 
		li.add("둘리");
		li.add("고길동");
		li.add("도우너");
		li.add("또치");
		li.add("마이콜");
		this.add(li);
		
		lbAlram.setBounds(100, 220, 250, 20); this.add(lbAlram);
		
	}	
	void start()
	{		
		ch.addItemListener(this);
		li.addItemListener(this);
		
		
		//윈도우우측상단 X 닫기 활성화
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
			lbAlram.setText("결과: 초이스에서 선택한값은 = "+ ch.getSelectedItem());
		}else if(e.getSource() == li)
		{
			String temp = li.getSelectedItem();
			System.out.println(temp);
			lbAlram.setText("결과: 리스트에서 선택한값은 = "+ temp);
		}
		
	}
	
}

