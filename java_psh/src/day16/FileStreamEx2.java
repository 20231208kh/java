package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos1 = null;
		FileInputStream fis1 = null;
		String fileName = "src/day16/fileEx3.txt";
		try {
			fos1 = new FileOutputStream(fileName);
			fis1 = new FileInputStream(fileName);
			String str = "Hello";
			for(int i=0; i<str.length();i++) {
				fos1.write(str.charAt(i));
			}
			for(int i=0; i<str.length();i++) {
				int ch= fis1.read();
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName+"을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("작업중 예외 발생");
		} finally {
			try {
				fos1.close();
				fis1.close();
			} catch (IOException e) {
				System.out.println("파일 닫기 예외발생");
			}
		}
		
		
		
		
	}

}
