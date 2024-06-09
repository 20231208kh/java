package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "src/day16/fileEx3.txt";
		try(FileOutputStream fos1 =  new FileOutputStream(fileName);
				FileInputStream fis1= new FileInputStream(fileName) 
				) {

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
		} 
		
		
		
		
	}

}
