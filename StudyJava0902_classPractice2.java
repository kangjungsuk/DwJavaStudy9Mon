package javastudy;
public class StudyJava0902_1 {
	public static void main(String[] args) {		
		My my = new My();
		my.studyMove();
		my.carMove();		
		System.out.println("�� ���������� : " + my.totMoney());
	}
}
class My extends Parent
{
	int money = 10000;
	String carName = "�ƹݶ�";
	void studyMove()
	{
		System.out.println("�����Ϸ�����.");
		System.out.println("�� ��� : " + money);
	}	
	int totMoney()
	{
		return this.money+super.money;
	}
}
class Parent
{
	int money=1000000;
	String carName = "���";
	String houseName = "100��¥������";	
	void carMove()
	{
		System.out.println("��󸮸� �����ߴ�!");
		System.out.println("�θ����� :"+money);
	}	
}
