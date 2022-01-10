package javastudy;
public class StudyJava0902_1 {
	public static void main(String[] args) {		
		My my = new My();
		my.studyMove();
		my.carMove();		
		System.out.println("내 모든현금재산 : " + my.totMoney());
	}
}
class My extends Parent
{
	int money = 10000;
	String carName = "아반떼";
	void studyMove()
	{
		System.out.println("공부하러간다.");
		System.out.println("내 재산 : " + money);
	}	
	int totMoney()
	{
		return this.money+super.money;
	}
}
class Parent
{
	int money=1000000;
	String carName = "페라리";
	String houseName = "100평짜리주택";	
	void carMove()
	{
		System.out.println("페라리를 운전했다!");
		System.out.println("부모님재산 :"+money);
	}	
}
