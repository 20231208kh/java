package day09.board;

public class Board {
	private String id,date;
	private int view,num;
	private String subject,post;
	
	
	public void update(String subject1, String post1) {
		subject=subject1;
		post=post1;
	}
	public Board(int num, String id,String subject,String post, String date) {
		super();
		this.num = num;
		this.id = id;
		this.subject = subject;
		this.post = post;
		this.date = date;
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setView(int view) {
		this.view=view;
	}
	
	public void upView() {
		this.view += 1;
	}
	
	public int getView() {
		return view;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void userInfo() {
		System.out.println("사용자 아이디 : " +id);
		System.out.println("오늘의 날짜 : " + date);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public void printInfo() {
		System.out.println("번호 : "+num+", 제목 : "+subject+", 작성자 : "+id+", 작성일 : "+date+", 조회수 : "+view);
	}
	public void checkPost() {
		System.out.println("번호 : "+num);
		System.out.println("작성자 : " +id);
		System.out.println("제목 : "+subject);
		System.out.println("내용 : "+post);
		System.out.println("작성일 : "+date);
		System.out.println("조회수 : "+view);
	}
	
	
	
}
