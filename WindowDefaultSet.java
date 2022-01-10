package javastudy;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowDefaultSet extends Frame{
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	WindowDefaultSet()
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
		
	}	
	void start()
	{		
		//윈도우우측상단 X 닫기 활성화
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
