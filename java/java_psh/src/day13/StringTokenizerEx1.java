package day13;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		String fruits = "사과, 배, 오렌지";
		String [] fruit = fruits.split(",");
		for(String tmp : fruit) {
			System.out.println(tmp);
		}
		
		
		StringTokenizer st = new StringTokenizer(fruits,",");
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		

	}

}
