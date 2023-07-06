package day16;

class Test{
    static int a = 0;
    int b = 0;
    
    static void printA() {
    	System.out.println("printA 메소드 실행");
    }

    void printB() {
    	System.out.println("printB 메소드 실행");
    }
}

public class Main {
	
    public static void main(String[] args) {
    	System.out.println("--객체 생성 전--");
    	System.out.println("Test.a : "+Test.a);
    	Test.printA();
    	
    	Test t1 = new Test();
    	Test t2 = new Test();
    	
    	t1.a++;
    	t2.b++;
    	System.out.println();
    	System.out.println("--객체 생성 후--");
    	System.out.println("t1.a : "+t1.a);
    	System.out.println("t1.b : "+t1.b);
    	System.out.println("t2.a : "+t2.a);
    	System.out.println("t2.b : "+t2.b);

        t1.printA();
        t1.printB();
        t2.printA();
        t2.printB();
    }
}

