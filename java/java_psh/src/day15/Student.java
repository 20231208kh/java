package day15;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
	@NonNull
	private int grade,classNum,studentNum;
	@NonNull
	private String name;
	private int kor,eng,math;

	
	public void printInfo() {
		System.out.println("--------------");
		System.out.println("학년 : "+grade+"학년");
		System.out.println(" 반 : "+classNum+"반");
		System.out.println("번호 : "+studentNum+"번");
		System.out.println("이름 : "+name);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+math);
		
	}
	
	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng =eng;
		this.math = math;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && studentNum == other.studentNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, studentNum);
	}
	
	
	
	
}
