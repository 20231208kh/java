package day18.student;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentManger {

	private List<Student> list = new ArrayList<Student>();
	
	public StudentManger(List<Student> list) {
		if(list ==null) {
			return;
		}
		this.list = list;
	}
	
	public boolean insertStudent(Student std) {
		if(list.contains(std)) {
			return false;
		}
		
		list.add(std);
		//학년, 반, 번호 순으로 정렬
		sort();
		
		return true;
	}
	/**가지고 있는 학생 정보들을 정렬하는 메서드
	 * */
	public void sort() {
		list.sort((s1, s2)-> {
			//학년이 다르면
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s2.getGrade();
			}
			//반이 다르면
			if(s1.getClassNum() != s2.getClassNum()) {
				return s1.getClassNum() - s2.getClassNum();
			}
			return s1.getNum() - s2.getNum();
		});
	}
	
	
	//학생 정보 출력
	public void printAll() {
		list.stream().forEach(s->System.out.println(s));
	}
	
	public void setList(ArrayList<Student> list) {
		if(list == null) {
			return;
		}
		this.list = list;
	}

	
}
