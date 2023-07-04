package day10;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = new Animal();
		dog.setName("강이지");
		dog.setSound("멍멍");
		dog.setLeg(4);
		
		// cat, chicken, snake객체 만들어서 값 셋팅하기
		Animal cat = new Animal();
		cat.setName("고양이");
		cat.setSound("야옹");
		cat.setLeg(4);
		
		Animal chicken =  new Animal();
		chicken.setName("닭");
		chicken.setSound("꼬끼오");
		chicken.setLeg(2);
		
		Animal snake = new Animal();
		snake.setName("뱀");
		snake.setSound("스윽");
		snake.setLeg(0);
		
		System.out.println(dog.getName()+"\t"+dog.getSound()+"\t"+dog.getLeg());
		System.out.println(cat.getName()+"\t"+cat.getSound()+"\t"+cat.getLeg());
		System.out.println(chicken.getName()+"\t"+chicken.getSound()+"\t"+chicken.getLeg());
		System.out.println(snake.getName()+"\t"+snake.getSound()+"\t"+snake.getLeg());
	}

}










