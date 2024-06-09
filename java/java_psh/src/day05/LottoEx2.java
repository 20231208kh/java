package day05;
import java.util.*;
public class LottoEx2 {

	public static void main(String[] args) {
		// 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리+보너스번호)
		// 사용자가 로또번호를 입력하면 (당첨 등수를 출력하는 코드를 작성하세요)
		
		int lotto1 [] = new int[7];
		int lotto2 [] = new int[6];
		int min=1, max=45;
		int user [] = new int[6];
		int count = 0;
		int prize = 0;
		
		while(count < lotto1.length ) {

			int r = (int)(Math.random()*(max - min +1) + min);
			
			//중복 확인
			int i;
			for (i =0; i< count; i++) {
				if (lotto1[i]==r) {
					break;
				}
			}
			
			//중복되지 않으면 저장 후 count 증가
			//lotto1[i]가 난수와 같다면 break가 걸려 i의 값이 증가하지 않음
			if(i == count) {
				lotto1[count++] = r;
			}
		}
		
		//보너스 번호 지정
		int bonus = lotto1[6];
		//배열복사
		System.arraycopy(lotto1, 0, lotto2, 0, 6);
		//배열정렬
		Arrays.sort(lotto2);
		//출력
		System.out.print("당첨번호: ");
		for (int i = 0 ; i<lotto2.length; i++) {
			System.out.print(lotto2[i] + " ");
		}
		System.out.print("보너스번호: "+bonus);
		
		//유저 입력, 유저의 입력 값 저장
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<user.length; i++) {
			System.out.print("\n유저 번호 : ");
			user[i] = scan.nextInt();
		}
		
		//당첨번호 비교
		for (int i =0; i<lotto2.length; i++) {
			for(int j=0; j<user.length; j++) {
				if (user[j] == lotto2[i]) {
					prize ++;
					//사용자의 중복입력 방지
					break;
				}
			}
		}

		
		//당첨 알림
		
		switch(prize) {
		case 6 :
			System.out.println("1등 입니다.");
			break;
		
		case 5 :
			int i;
			// 보너스와 user 배열의 값이 일치하면 i의 값이 증가하지 않음
			
			for (i=0; i<user.length; i++) {
				if(bonus==user[i]) {
					break;
				}
			}
			// i의 값이 증가해서 6까지 올라간 경우 (bonus와 user[i]가 일치하지 않아 break를 만나지 않은 경우) -> 3등
			if(i == user.length) {
				System.out.println("3등 입니다.");
			// i의 값이 증가하지 않아 6까지 올라가지 못한 경우 (bonus와 user[i]가 일치하여 break를 만난 경우) -> 2등
			}else {
				System.out.println("2등 입니다.");
			}
			break;
			
		
		case 4: 
			System.out.println("3등 입니다.");
			break;
			
		case 3:
			System.out.println("4등 입니다.");
			break;
		default:
			System.out.println('꽝');
			break;
		}
		
		
	}

}
