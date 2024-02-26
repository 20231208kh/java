package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import day15.Student;

public class Streamex1 {

	public static void main(String[] args) {
		List<Student> list= 
				Arrays.asList(
						new Student(1,1,1,"홍길동",100,100,100),
						new Student(1,1,2,"임꺽정",95,85,55),
						new Student(2,1,1,"고길동",50,10,20)
						);
		
		Stream <Student> stream = list.stream();
		stream.filter(s->s.getGrade() ==1).forEach(s->System.out.println(s));
		stream = list.stream();
		stream.map(s->s.getKor()).forEach(k->System.out.println("국어: "+k));
		
	}	

}
