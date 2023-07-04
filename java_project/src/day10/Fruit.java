package day10;

public class Fruit {
	String name;
	String color;
	boolean isSeed;
	
	// 생성자의 특징 1. 클래스이름과 동일
	// 생성자의 특징 2. 리턴타입이 없다
	// [생성자 선언방식]
	// 접근제한자 생성자명([매개변수]){
	// 		실행문구(보통의 경우 필드값을 초기화한다)
	// }
	public Fruit() {
		System.out.println("첫번째 생성자");
	}
	public Fruit(String name) {
		System.out.println("두번째 생성자");
		this.name = name;
	}
	public Fruit(String name, String color) {
		System.out.println("세번째 생성자");
		this.name = name;
		this.color = color;
	}
	public Fruit(String name, String color, boolean isSeed) {
		System.out.println("네번째 생성자");
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
	}
	
	// 메서드
	public void print() {
		System.out.println(name+"\t"+color+"\t"+isSeed);
	}
}











