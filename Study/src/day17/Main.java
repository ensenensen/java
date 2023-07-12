package day17;

class Test{
	int number;
	
	int doubleNumber() {
		return number*2;
	}
	
	void printSky() {
		System.out.println("하늘");
	}
}

public class Main {

	public static void main(String[] args) {
		Test test = new Test();
		
		test.printSky();
		
		int result = test.doubleNumber();
		System.out.println(result);
	}

}


