package javastudy;

public class StudyJava0903_1 {
	public static void main(String[] args) {	
		TestThread tt = new TestThread();
		TestThread2 tt2 = new TestThread2();
		Thread th = new Thread(tt);
		Thread th2 = new Thread(tt2);
		th.start();	
		th2.start();			
	}
}
class TestThread implements Runnable{	

	//�����忪���ϴ� run�޼��� ��������.
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(500);
				System.out.println("������Ŭ���������մϴ�.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}	
}
class TestThread2 implements Runnable{	

	//�����忪���ϴ� run�޼��� ��������.
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1500);
				System.out.println("�ι�° ������Ŭ���������մϴ�.---");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}



