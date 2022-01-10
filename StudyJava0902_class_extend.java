package javastudy;
import java.util.Scanner;
public class StudyJava0902_3 {
	public static void main(String[] args) {		
		Aban a = new Aban();		
	}
}
class Aban extends Score{
	Scanner sc = new Scanner(System.in);
	//String name[] = new String[10];	// 10명의 이름을 저장할공간...상속시 필요없음.
	int score[][] = new int[10][4];	// 10명의 학생의 점수처리공간 사회과학 총점 평균공간... 
	int select;	
	int cnt=0;
	Aban()
	{
		while(true)
		{
			System.out.println("1.입력 2.출력 3.종료.");			
			System.out.print("선택:");
			select = sc.nextInt();
			if(select == 1) {
				super.input();	input();		
				}
			else if(select == 2) {	output();		}
			else if(select == 3) {
				System.out.println("프로그램 종료.");	
				break;
			}
		}
	}	
	void input(){		
		//System.out.print(cnt+1+"번 이름:"); name[cnt] = sc.next(); //이름입력..상속시 불필요..
		System.out.print(cnt+1+"번 사회:"); score[cnt][0] = sc.nextInt(); //사회입력
		System.out.print(cnt+1+"번 과학:"); score[cnt][1] = sc.nextInt(); //과학입력		
		score[cnt][2] = super.score[cnt][3] + score[cnt][0] + score[cnt][1]; //총점처리 부모총점+현재총점
		score[cnt][3] = score[cnt][2] / 5;   //평균처리 
		cnt++; // 1명의 점수입력이 끝나면 사람수증가
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"번:"+name[i]+"의 총점:"+score[i][2]+" / 평균:"+score[i][3]);
		}
	}
	
}


class Bban extends Score{
	Scanner sc = new Scanner(System.in);
	//String name[] = new String[10];	// 10명의 이름을 저장할공간...상속시 필요없음.
	int score[][] = new int[10][4];	// 10명의 학생의 점수처리공간 사회과학 총점 평균공간... 
	int select;	
	int cnt=0;
	
	void input(){		
		//System.out.print(cnt+1+"번 이름:"); name[cnt] = sc.next(); //이름입력 상속시...불필요..
		System.out.print(cnt+1+"번 음악:"); score[cnt][0] = sc.nextInt(); //음악입력
		System.out.print(cnt+1+"번 미술:"); score[cnt][1] = sc.nextInt(); //미술입력		
		score[cnt][2] = super.score[cnt][3] + score[cnt][0] + score[cnt][1]; //총점처리
		score[cnt][3] = score[cnt][2] / 5;   //평균처리 
		cnt++; // 1명의 점수입력이 끝나면 사람수증가
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"번:"+name[i]+"의 총점:"+score[i][2]+" / 평균:"+score[i][3]);
		}
	}
	
}




class Score
{
	Scanner sc = new Scanner(System.in);
	String name[] = new String[10];	// 10명의 이름을 저장할공간...
	int score[][] = new int[10][5];	// 10명의 학생의 점수처리공간 국영수 총점 평균공간... 
	int select;	
	int cnt=0;

	void input(){		
		System.out.print(cnt+1+"번 이름:"); name[cnt] = sc.next(); //이름입력
		System.out.print(cnt+1+"번 국어:"); score[cnt][0] = sc.nextInt(); //국어입력
		System.out.print(cnt+1+"번 영어:"); score[cnt][1] = sc.nextInt(); //영어입력
		System.out.print(cnt+1+"번 수학:"); score[cnt][2] = sc.nextInt(); //수학입력
		score[cnt][3] = score[cnt][0] + score[cnt][1] + score[cnt][2]; //총점처리
		score[cnt][4] = score[cnt][3] / 3;   //평균처리 
		cnt++; // 1명의 점수입력이 끝나면 사람수증가
	}	
	void output(){
		for(int i=0; i < cnt ; i++)
		{			
			System.out.println(i+1+"번:"+name[i]+"의 총점:"+score[i][3]+" / 평균:"+score[i][4]);
		}
	}
	
}
