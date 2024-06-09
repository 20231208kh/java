package day05;
import java.util.*;
public class ThirtyOneEx1 {

	public static void main(String[] args) {
		/*사용자와 컴퓨터가 돌아가면서 최대 3개의 숫자를 부르고,
		 * 31을 입력한 사용자 또는 컴퓨터가 패배
		 */
		
		//사용자는 입력한 정수만큼 연달아 숫자가 나옴
		//컴퓨터는 랜덤한 값이 숫자로 나옴
		
		Scanner scan = new Scanner(System.in);
		int user = 0 ;
		int count = 0;
		int min =1, max =3;
		while(count < 31) {
			//컴퓨터가 랜덤으로 1~3 사이의 숫자를 생성
			int com = (int)(Math.random()*(max - min +1) + min);
			//현재 숫자 저장, end는 0+1~3 
			int end = count + com;
			
			//현재 숫자부터 랜덤으로 생성된 숫자를 합했을 때 31이상이 되면 31까지 출력
			
			//end가 31이상이라면 end를 31로 설정, end가 31 미만이라면 그냥 그대로 둠
			end = end>= 31 ? 31 : end; 
			
			//현재 숫자부터 랜덤으로 생성된 숫자 개수만큼 출력
			System.out.print("com : ");
			for (int i = count + 1; i<= end; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			//현재 숫자를 출력된 마지막 숫자로 수정
			count = end;
			if(count == 31) {
				System.out.println("유저 승!");
				break;
			}
			//사용자가 1~3 사이의 숫자를 입력
			System.out.print("정수 : ");
			user = scan.nextInt();
			end = count + user;
			end = end >= 31 ? 31 : end;
			System.out.print("user : ");
			for(int i = count+1; i<=end; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			count = end;
			
			if (count==31) {
				System.out.println("컴퓨터 승!");
				break;
			}
			
			
		}


	
		
		
		
		
		
	}

}
