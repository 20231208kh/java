package day10;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

public class tmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("1", "2"));
		list.add(new Fruit("1", "2"));
		list.add(new Fruit("1", "2"));
		list.add(new Fruit("1", "2"));
		
		for(int i =0; i<=list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	
}

