package day08.test;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food implements Serializable {
	
	private static final long serialVersionUID = 3027625281369581798L;
	private String name;
	private int kcal;
	
	@Override
	public String toString() {
		return "[음식 이름: " + name + ", 칼로리 =" + kcal + "]";
	}
	
	
	
}
