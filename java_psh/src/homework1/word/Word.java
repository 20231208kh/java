package homework1.word;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
	private String word;
	private List<Means> mean = new ArrayList<>();
	

	


}

@Data
@AllArgsConstructor
class Means{
	private String wordClass,mean;
	
	
}
