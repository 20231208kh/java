package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ObjectStreamEx1 {

	public static void main(String[] args) {
		// 직렬화/역직렬화 이용한 객체를 쓰고 읽는 예제
		Board board = new Board(1,"제목","내용","테스트");
		String fileName = "src/day16/objectStreamEx1.txt";
		//게시글을 파일에 저장
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(board);
			
		}
		  catch (FileNotFoundException e) {
			System.out.println("파일 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("파일 작업 중 예외 발생");
		}
		//저장된 파일에서 게시글을 읽어옴
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			Board tmp = (Board)ois.readObject();
			System.out.println(tmp);
		} catch (FileNotFoundException e) {
			System.out.println("파일 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("파일 작업 중 예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 못찾음");
		}
	}

}
@Data
@AllArgsConstructor

class Board implements Serializable{
	
	private static final long serialVersionUID = -2004124461323227781L;
	int num;
	String title,contents;
	
	transient String test;
}