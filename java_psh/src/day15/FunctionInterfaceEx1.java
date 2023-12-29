package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionInterfaceEx1 {

	public static void main(String[] args) {
		
		List<Student1> list = new ArrayList<Student1>();
		list.add(new Student1(1,1,1,"홍길동",90,80,70));
		list.add(new Student1(1,1,2,"임꺽정",100,100,100));
		list.add(new Student1(1,1,3,"고길동",50,50,50));
	
		print(list, s->{
			System.out.println(s.getGrade()+"학년 " + s.getClassNum() +"반 "
					+s.getNum()+"번호 "+s.getName());
		});
		
		print(list, s->{
			System.out.println(s.getName()+": 국어 - "+s.getKor()
					+", 영어 - "+s.getEng()
					+", 수학 - "+s.getMath());
		});
		
	}
	
	public static void print(List<Student1> list, Consumer<Student1> consumer) {
		for(Student1 student : list) {
			consumer.accept(student);
		}
	}

}

@Data
@AllArgsConstructor
class Student1{
	int grade, classNum,num;
	String name;
	int kor,eng,math;
}