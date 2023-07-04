package test;

public class test2 {

	public static void main(String[] args) {
		// 배열
		
		int[] a = new int[5];
		int[] b = {1,2,3,4,5};
		
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		
		// 인덱스 (Index) : 주소
		for(int i = 0; i < 5; i++) {
			System.out.println(a[i]);
		}
		System.out.println("=============");
		System.out.println(a.length);
		System.out.println("=============");
		
		// for(초기문; 조건문; 증감문){실행문}
		for(int i = 4; i >= 0; i--) {
			System.out.println(b[i]);
		}
		
		String[] name = new String[3];
		String[] name2 = {"홍길동","이순신","심청이"};
		
		name[0] = "홍길동";
		name[1] = "이순신";
		name[2] = "심청이";
		System.out.println("====================");
		System.out.println(name.length);
		// length : 길이 -> 배열의 크기
		
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		
		
		

	}

}
