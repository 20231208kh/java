package homework1.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
@Data

public class WordManager {
	private List<Word> wordList = new ArrayList<Word>();
	private List<Word> failList = new ArrayList<Word>();
	
	
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
	
	
	public void askWordClass(Word word,String wordClass) {
		int index = wordList.indexOf(word);
		int index2 = wordList.indexOf(wordClass);
		int index3 = wordList.get(index).getMean().indexOf(wordClass);
		
		Means m = new Means(wordClass);
		int index4 = wordList.get(index).getMean().indexOf(m);
		boolean index5 = wordList.get(index).getMean().contains(wordClass);
		boolean index6 = wordList.get(index).getMean().contains(m);
		int index7 = word.getMean().indexOf(wordClass);
		int index8 = word.getMean().indexOf(m);
		
		String a = wordList.get(index).getMean().get(0).getWordClass();
		System.out.println(a);
		boolean b = a.equals(wordClass);
		System.out.println(b);
		
		
		for(int i=0; i<wordList.get(index).getMean().size();i++) {
			if(wordList.get(index).getMean().get(i).getWordClass().equals(wordClass)) {
				System.out.println(i);
				}else {
					System.out.println("no");
				}
		}
		
		
		
//		System.out.println(index);
//		System.out.println(index2);
//		System.out.println(index3);
//		System.out.println(index4);
//		System.out.println(index5);
//		System.out.println(index6);
//		System.out.println(index7);
//		System.out.println(index8);
		
		
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
		wordList.stream().forEach(w->System.out.println(w));
	}
	
	public void failPrintAll() {
		System.out.println("-----오답노트-----");
		if(failList.size()==0) {
			System.out.println("현재 오답노트가 비어있습니다.");
			return;
		}
		failList.stream().forEach(f->System.out.println(f));
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
		System.out.println(wordList);
		
//		String wordc = wordList.get(index).getMean().get(index).getWordClass();
//		System.out.println(wordc);

		
	}
}

