package javastudy;
import java.util.Scanner;
public class StudyJava0902_2 {
	public static void main(String[] args) {		
		MyClass m = new MyClass();
	}
}

class ParentClass
{
	ParentClass()
	{
		System.out.println("�θ�Ŭ�����Դϴ�.");
	}
}
class MyClass extends ParentClass
{
	MyClass()
	{
		System.out.println("���� �۾�Ŭ�����Դϴ�.");
	}
}