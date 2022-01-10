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

	//스레드역할하는 run메서드 쓸수있음.
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(500);
				System.out.println("스레드클래스동작합니다.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}	
}
class TestThread2 implements Runnable{	

	//스레드역할하는 run메서드 쓸수있음.
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1500);
				System.out.println("두번째 스레드클래스동작합니다.---");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}



