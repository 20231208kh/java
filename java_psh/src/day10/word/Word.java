package day10.word;

public class Word {
	
	private static int count = 0;
	
	private String wordv,mean,failTestUser,failTestWord,failTestAnswer;
	private int num;
	
	
	public Word(String wordv, String mean) {
		super();
		this.num = count++;
		this.wordv = wordv;
		this.mean = mean;

	}
	
	public void failTestPrint() {
		System.out.println("단어 : "+failTestWord);
		System.out.println("뜻 : "+failTestAnswer);
		System.out.println("유저의 오답 : "+failTestUser);
		System.out.println("----------------");
		
		
	}
	

	public String getFailTestUser() {
		return failTestUser;
	}


	public void setFailTestUser(String failTestUser) {
		this.failTestUser = failTestUser;
	}


	public String getFailTestWord() {
		return failTestWord;
	}


	public void setFailTestWord(String failTestWord) {
		this.failTestWord = failTestWord;
	}


	public String getFailTestAnswer() {
		return failTestAnswer;
	}


	public void setFailTestAnswer(String failTestAnswer) {
		this.failTestAnswer = failTestAnswer;
	}


	public String getWordv() {
		return wordv;
	}
	public void setWordv(String wordv) {
		this.wordv = wordv;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void printAllWord() {
		System.out.println("단어 : "+wordv+ " 뜻 : "+mean);
		System.out.println("---------------");
	}
	
	public void printSearchWord() {
		System.out.println("---------------");
		System.out.println("단어 : "+wordv);
		System.out.println("뜻 : "+mean);
	}
	
	public void updateMean(String mean) {
		this.mean = mean;
	}
	

}
