package javastudy;
import java.util.Scanner;
public class StudyJava0902_3 {
	public static void main(String[] args) {		
		Aban a = new Aban();		
	}
}
class Aban extends Score{
	Scanner sc = new Scanner(System.in);
	//String name[] = new String[10];	// 10���� �̸��� �����Ұ���...��ӽ� �ʿ����.
	int score[][] = new int[10][4];	// 10���� �л��� ����ó������ ��ȸ���� ���� ��հ���... 
	int select;	
	int cnt=0;
	Aban()
	{
		while(true)
		{
			System.out.println("1.�Է� 2.��� 3.����.");			
			System.out.print("����:");
			select = sc.nextInt();
			if(select == 1) {
				super.input();	input();		
				}
			else if(select == 2) {	output();		}
			else if(select == 3) {
				System.out.println("���α׷� ����.");	
				break;
			}
		}
	}	
	void input(){		
		//System.out.print(cnt+1+"�� �̸�:"); name[cnt] = sc.next(); //�̸��Է�..��ӽ� ���ʿ�..
		System.out.print(cnt+1+"�� ��ȸ:"); score[cnt][0] = sc.nextInt(); //��ȸ�Է�
		System.out.print(cnt+1+"�� ����:"); score[cnt][1] = sc.nextInt(); //�����Է�		
		score[cnt][2] = super.score[cnt][3] + score[cnt][0] + score[cnt][1]; //����ó�� �θ�����+��������
		score[cnt][3] = score[cnt][2] / 5;   //���ó�� 
		cnt++; // 1���� �����Է��� ������ ���������
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"��:"+name[i]+"�� ����:"+score[i][2]+" / ���:"+score[i][3]);
		}
	}
	
}


class Bban extends Score{
	Scanner sc = new Scanner(System.in);
	//String name[] = new String[10];	// 10���� �̸��� �����Ұ���...��ӽ� �ʿ����.
	int score[][] = new int[10][4];	// 10���� �л��� ����ó������ ��ȸ���� ���� ��հ���... 
	int select;	
	int cnt=0;
	
	void input(){		
		//System.out.print(cnt+1+"�� �̸�:"); name[cnt] = sc.next(); //�̸��Է� ��ӽ�...���ʿ�..
		System.out.print(cnt+1+"�� ����:"); score[cnt][0] = sc.nextInt(); //�����Է�
		System.out.print(cnt+1+"�� �̼�:"); score[cnt][1] = sc.nextInt(); //�̼��Է�		
		score[cnt][2] = super.score[cnt][3] + score[cnt][0] + score[cnt][1]; //����ó��
		score[cnt][3] = score[cnt][2] / 5;   //���ó�� 
		cnt++; // 1���� �����Է��� ������ ���������
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"��:"+name[i]+"�� ����:"+score[i][2]+" / ���:"+score[i][3]);
		}
	}
	
}




class Score
{
	Scanner sc = new Scanner(System.in);
	String name[] = new String[10];	// 10���� �̸��� �����Ұ���...
	int score[][] = new int[10][5];	// 10���� �л��� ����ó������ ������ ���� ��հ���... 
	int select;	
	int cnt=0;

	void input(){		
		System.out.print(cnt+1+"�� �̸�:"); name[cnt] = sc.next(); //�̸��Է�
		System.out.print(cnt+1+"�� ����:"); score[cnt][0] = sc.nextInt(); //�����Է�
		System.out.print(cnt+1+"�� ����:"); score[cnt][1] = sc.nextInt(); //�����Է�
		System.out.print(cnt+1+"�� ����:"); score[cnt][2] = sc.nextInt(); //�����Է�
		score[cnt][3] = score[cnt][0] + score[cnt][1] + score[cnt][2]; //����ó��
		score[cnt][4] = score[cnt][3] / 3;   //���ó�� 
		cnt++; // 1���� �����Է��� ������ ���������
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"��:"+name[i]+"�� ����:"+score[i][3]+" / ���:"+score[i][4]);
		}
	}
	
}
