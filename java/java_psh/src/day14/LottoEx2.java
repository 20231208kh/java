package day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx2 {

	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성하세요.
		 * 단, 컬렉션을 이용
		 * 당첨번호 : 6개, 보너스 : 1개
		 * 사용자 : 6개
		 * 범위 : 1~45
		 */
		Scanner scan = new Scanner(System.in);
		Set<Integer> lotto = new HashSet<Integer>();
		Set<Integer> user = new HashSet<Integer>();
		int min = 1, max = 45;
		Random random = new Random();
		int prizes = 0;
		int bonus =0;
		
		while(lotto.size()<7) {
			int tmp = random.nextInt((max-min+1)+min);
			lotto.add(tmp);
		}
		
		System.out.println(lotto);
		
		
		List <Integer> lotto2 = new ArrayList<Integer>();
		lotto2.addAll(lotto);
		bonus = lotto2.remove(lotto2.size()-1);
		System.out.println(bonus);
		
		System.out.print("번호 입력 : ");
		while(user.size()<6) {
			int userNum = scan.nextInt();
			user.add(userNum);
		}
		
		
		for(int tmp:user) {
			if(lotto2.contains(tmp)) {
				prizes++;
			}
		}
		System.out.println(prizes);
		
		switch(prizes) {
		case 6 :
			System.out.println("1등 입니다.");
			break;
		
		case 5 :
			int i = user.contains(bonus) ? 2: 3;
			System.out.println(i+"등 입니다.");
			
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

