package day06;
import java.util.*;
public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 숫자 야구게임
		 * 1~9 사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞춤
		 * -> 배열? 일단 랜덤 난수 생성하고 for문 돌려야할듯?
		 * -> 중복 제거도 해줘야됨
		 * S : 숫자가 있고, 위치가 같은경우
		 * -> for문으로 검사해보고, 인덱스값이 같고 요소도 같은경우에 S를 넣어줘야할듯
		 * -> count 같은 변수를 추가해서 S의 갯수를 저장해야할듯
		 * B : 숫자가 있지만 위치가 다른경우
		 * -> for문으로 검사해보고, 인덱스값이 다르지만 요소가 있긴 있으면 B
		 * -> count 같은 변수를 추가해서 B의 갯수를 저장해야할듯
		 * O : 일치하는 숫자가 하나 없음
		 * -> 인덱스와 요소가 전부 다르면 O
		 * 3S가 되면 게임 종료
		 * 
		 * -일단 필요한 변수 목록-
		 * 랜덤 1~9 난수 , 이걸 문자화해서 charAt 해보는것도 괜찮아보임 우선은 배열로
		 * 중복제거
		 * 유저 입력값 저장 + 입력값을 배열화
		 * S 갯수 저장 변수
		 * B 갯수 저장 변수
		 * 
		 */
		int baseball [] = new int[3];
		int min=1, max=9;
		int count = 0 ;
		int out = 0;
		int strikes;
		int balls;
		Scanner scan = new Scanner(System.in);
		int user;
		int [] userArr = new int[3];
		while(count < baseball.length ) {
			//랜덤숫자 생성
			int r = (int)(Math.random()*(max - min +1) + min);
			//중복 확인
			int i;
			for (i =0; i< count; i++) {
				if (baseball[i]==r) {
					break;
				}
			}
			
			//중복되지 않으면 저장 후 count 증가
			if(i == count) {
				baseball[count] = r;
				count ++;
			}
			
		}
		
		for (int i =0; i<baseball.length;i++) {
			System.out.print(baseball[i]);
		}
		
		while(true) {
			strikes =0;
			balls = 0;
			System.out.print("입력: ");
			for(int i=0; i<userArr.length;i++) {
				userArr[i] = scan.nextInt();
			}
			
			for(int i=0; i<userArr.length;i++) {
				for(int j=0; j<userArr.length; j++) {
					if(i!= j) {
						if(userArr[i]==baseball[j]) {
							balls++;
						
						}
					}
				}
			}
			
			for(int i =0; i<userArr.length;i++) {
				if (userArr[i]==baseball[i]) {
					strikes++;
				}
			}
			
			if (strikes==0 && balls==0) {
				System.out.println("out!");
			}
			else {
			System.out.println(strikes + "S "+ balls+ "B ");
			}
			if (strikes==3){
				System.out.println("승리");
				break;
			}
			
			
			
		}
		
	}
}	
	