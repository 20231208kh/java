package day12;

public class PolymorphismEx2 {

	public static void main(String[] args) {
		/* 다형성 예제2
		 * 포함 다형성 :
		 * 자식 인스턴스들을 부모 인스턴스가 관리하는 것
		 */
		//그려진 도형들을 관리
		//사각형 > 타원 > 선 > 선> 사각형 순으로 그렸다면, 그린 순서대로 관리
		
		Rect[] rects = new Rect[10];
		Ellipse[] ellipses = new Ellipse[10];
		Line [] lines =new Line[10];
		int rectCount = 0, ellipseCount = 0, lineCount =0;
		
		/*
		//사각형
		rects[rectCount++] = new Rect();
		//타원
		ellipses[ellipseCount++] = new Ellipse();
		//선
		lines[lineCount++] = new Line();
		lines[lineCount++] = new Line();
		//사각형
		rects[rectCount++] = new Rect();
		*/
		
		//다형성을 이용한 방법
		Shape [] shapes = new Shape[30];
		int count =0;
		//사각형
		shapes[count++] = new Rect();
		//타원
		shapes[count++] = new Ellipse();
		//선
		shapes[count++] = new Line();
		shapes[count++] = new Line();
		//사각형
		shapes[count++] = new Rect();
		
		for(int i = 0; i<count; i++) {
			shapes[i].draw();
		}
		
	}

}

class Shape{
	void draw() {}
}

class Rect extends Shape{
	void draw() {
		System.out.println("사각형");
	}
}

class Ellipse extends Shape{
	void draw() {
		System.out.println("타원");
	}
}

class Line extends Shape{
	void draw() {
		System.out.println("선");
	}
}