package day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamEx1 {

	public static void main(String[] args) {
		String fileName = "src/day16/charStreamEx1.txt";
		
		try(FileWriter fw = new FileWriter(fileName)){
			String str = "안녕하세요\n제 이름은 홍길동입니다. \n끝";
			for(int i =0; i<str.length();i++) {
				fw.write(str.charAt(i));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("파일 작업 중 예외 발생");
		}
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("파일 끝 도달");
		}
	}

}
