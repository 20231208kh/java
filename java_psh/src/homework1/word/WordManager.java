package homework1.word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
@Data

public class WordManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8564411599883434414L;
	
	private List<Word> wordList = new ArrayList<Word>();
	private List<Word> failList = new ArrayList<Word>();
	
	
	// 각종 정렬
	// 단어장 정렬
	public void sortWordList() {
		wordList.sort((w1,w2)->{
			return w1.getWord().compareTo(w2.getWord());
		});
	}
	
	// 오답노트 정렬
	public void sortFailList() {
		failList.sort((w1,w2)->{
			return w1.getWord().compareTo(w2.getWord());
		});
	}
	
	// 품사 정렬
	public void sortWordClass() {
		wordList.forEach(w-> w.getMean().sort((c1,c2)->{
			return c1.getWordClass().compareTo(c2.getWordClass());
		}));
	}
	
	public boolean askContain(Word word) {
		if(wordList.contains(word)) {
			return true;
		}
		return false;
	}
	
	public int getIndex(Word word) {
		int index = -1;
		if(wordList.contains(word)) {
			index = wordList.indexOf(word);
			return index;
		}
		return index;
	}
	
	
		
	
	public boolean askContainFail(Word word) {
		if(failList.contains(word)) {
			return true;
		}
		return false;
	}
	
	public void insertWord(Word word,String wordClass, String mean) {
		List<Means> meanList = new ArrayList<Means>();
		List<String> meaning = new ArrayList<String>();
		meaning.add(mean);
		Means means = new Means(wordClass,meaning);
		meanList.add(means);
		word.setMean(meanList);
		wordList.add(word);
		int index = getIndex(word);
		System.out.println(getWordList().get(index).toString());
		System.out.println("단어 등록 완료");
	}
	
			
	public boolean updateWord(Word word,String updateWord) {
		if(wordList.indexOf(word)== -1){
			return false;
		}
		int index = wordList.indexOf(word);
		word.setWord(updateWord);
		if(askContain(word)) {
			System.out.println("중복된 단어입니다.");
			return false;
		}
		wordList.get(index).setWord(updateWord);
		return true;
	}
	
	
	
		
	

	
	public boolean deleteWord(Word word) {
		if(askContain(word)) {
			wordList.remove(word);
			return true;
		}
		return false;
	}
	
	public void addFailList(Word word) {
		if(askContainFail(word)) {
			return;
		}
		failList.add(word);
	}
	
	public List<Integer> makeRanList(){
		List<Integer> quiz = new ArrayList<Integer>();
		for (int i=0; i<wordList.size();i++) {
			quiz.add(i);
		}
		return quiz;
	}
	
	
	public void printAll() {
		wordList.stream().forEach(w->System.out.println(w.toString()));
	}
	
	public void failPrintAll() {
		System.out.println("-----오답노트-----");
		if(failList.size()<=0 ) {
			System.out.println("현재 오답노트가 비어있습니다.");
			return;
		}
		failList.stream().forEach(f->System.out.println(f.toString()));
	}
	
	public void clearFailList() {
		List<Word> tmp = new ArrayList<Word>();
		failList = tmp; 
	}
	
	public List<String> test(int index) {
		List<String> answers = new ArrayList<String>();
		for (int i=0;i<wordList.get(index).getMean().size();i++) {
			answers.addAll(wordList.get(index).getMean().get(i).getMeanList());
		}
		return answers;
		
		
		
	}
	
	
	
	public void insertOnlyMean(Word word, String newMean,int index2) {
		int index = -1;
		if(!askContain(word)) {
			return;
		}
		index = wordList.indexOf(word);
		
		if (wordList.get(index).containsMean(newMean)) {
	        System.out.println("중복된 뜻입니다.");
	        return;
		}
		
		
		
		
		wordList.get(index).getMean().get(index2).addMean(newMean);
		System.out.println(getWordList().get(index).toString());
		
//		String wordc = wordList.get(index).getMean().get(index).getWordClass();
//		System.out.println(wordc);

	}

	public void updateMean(int index,String updateMean, int index2,String mean) {
		if (wordList.get(index).containsMean(updateMean)) {
	        System.out.println("중복된 뜻입니다.");
	        return;
		}
		
		wordList.get(index).getMean().get(index2).getMeanList().remove(mean);
		wordList.get(index).getMean().get(index2).addMean(updateMean);
		
		
		
	}
	public void deleteMean(int index,String deleteMean, int index2) {

		
		wordList.get(index).getMean().get(index2).getMeanList().remove(deleteMean);
	
		
		
		
	}
	
}

