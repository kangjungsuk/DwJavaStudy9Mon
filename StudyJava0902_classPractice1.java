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
		System.out.println("부모클래스입니다.");
	}
}
class MyClass extends ParentClass
{
	MyClass()
	{
		System.out.println("현재 작업클래스입니다.");
	}
}