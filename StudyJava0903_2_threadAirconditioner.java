package javastudy;

public class StudyJava0903_2 {
	public static void main(String[] args) {	
		TestThread3 tt = new TestThread3();
		tt.start();	
					
	}
}
class TestThread3 extends Thread{	

	//�����忪���ϴ� run�޼��� ��������.
	int tempo=25;
	boolean minusStart = false;
	boolean plusStart = true;
	public void run()
	{
		while(true)
		{
			try {
				int addTempo = (int)(Math.random()*2);				
				Thread.sleep(1000);//					
				if(plusStart == true)
				{
				
					if(tempo >= 34) {
						System.out.println("$$$$$$$$$$$$$$$$�������� �����˴ϴ�.$$$$$$$$$$$$$");
						plusStart = false; //34�������̵Ǹ� ���̳ʽ��� ���������� ��.
						minusStart = true; //�µ� �������°� ����.
					}
					else {
						tempo += addTempo;
						System.out.println("���� : " + tempo +"�� �Դϴ�."  );
					}
					
					
				}
				if(minusStart == true)
				{
				
					if(tempo <= 27) {
						System.out.println("***********�������� �ߴܵ˴ϴ�.*************");
						minusStart = false; //34�������̵Ǹ� ���̳ʽ��� ���������� ��.
					}
					else {
						tempo -= addTempo;
						System.out.println("���� : " + tempo +"�� �Դϴ�."  );
					}					
					
				}		        
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}	
}



