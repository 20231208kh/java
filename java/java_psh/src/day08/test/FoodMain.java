package day08.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.stream.Stream;

public class FoodMain {

	
	
	public static void main(String[] args) {
		String fileName = "src/day08/test/food.txt";
		
		fileSave(fileName);

	}
	
	public static void fileSave(String fileName) {
		
		Food food = new Food("사과",30);
		System.out.println(food);
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(food);
				fos.close();
				oos.close();
			}
			  catch (FileNotFoundException e) {
				System.out.println("파일 찾을 수 없음");
			} catch (IOException e) {
				System.out.println("파일 작업 중 예외 발생");
			}
	
	}

}
