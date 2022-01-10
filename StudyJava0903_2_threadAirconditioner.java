package javastudy;

public class StudyJava0903_2 {
	public static void main(String[] args) {	
		TestThread3 tt = new TestThread3();
		tt.start();	
					
	}
}
class TestThread3 extends Thread{	

	//스레드역할하는 run메서드 쓸수있음.
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
						System.out.println("$$$$$$$$$$$$$$$$에어컨이 가동됩니다.$$$$$$$$$$$$$");
						plusStart = false; //34도조건이되면 마이너스로 동작을위해 끔.
						minusStart = true; //온도 내려가는게 시작.
					}
					else {
						tempo += addTempo;
						System.out.println("현재 : " + tempo +"도 입니다."  );
					}
					
					
				}
				if(minusStart == true)
				{
				
					if(tempo <= 27) {
						System.out.println("***********에어컨이 중단됩니다.*************");
						minusStart = false; //34도조건이되면 마이너스로 동작을위해 끔.
					}
					else {
						tempo -= addTempo;
						System.out.println("현재 : " + tempo +"도 입니다."  );
					}					
					
				}		        
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}	
}



