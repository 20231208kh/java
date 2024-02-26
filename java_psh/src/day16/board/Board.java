package day16.board;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board implements Serializable{

	private static final long serialVersionUID = -540150075960298531L;
	private int grade,classNum,num;
	private String name;
	
	

	@Override
	public String toString() {
		return "---------------\n"+"학년 : "+grade + "\n반 : "+classNum +"\n번호 : "+num+"\n이름 : "+name+"\n";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}



	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
}
