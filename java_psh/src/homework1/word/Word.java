package homework1.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
	private String word;
	private List<Means> mean = new ArrayList<>();
	
	public Word(String word) {
		super();
		this.word = word;
	}

	@Override
	public String toString() {
		return "[단어 : "+word+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	

	
	
	
	
	
	


}

@Data
@AllArgsConstructor
class Means{
	private String wordClass,mean;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Means other = (Means) obj;
		return Objects.equals(mean, other.mean);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mean);
	}

	@Override
	public String toString() {
		return "[품사 : "+wordClass+" 뜻 : "+mean+"]";
	}
	
	
	
}
