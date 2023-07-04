package ex01;

import java.util.Scanner;

public class Repeat {
	public static void run() {
		// 반복문(while, for)
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1)100까지합|2)100까지짝수합|3)100까지홀수합|0)종료");
			System.out.println("-----------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();
			int tot = 0;
			switch(menu) {
			case "0":
				System.out.println("프로그램 종료");
				run = false;
				break;
			case "1":
				for(int i=1; i<=100; i++) {
					tot += i;
				}
				System.out.println("1~100까지합계:"+tot);
				break;
			case "2":
				for(int i=2; i<=100; i+=2) {
					tot += i;
				}
				System.out.println("1~100까지짝수합계:"+tot);
				break;
			case "3":
				for(int i=1; i<=100; i+=2) {
					tot += i;
				}
				System.out.println("1~100까지홀수합계:"+tot);
				break;
			default:
				System.out.println("메뉴를 다시 입력하세요!");
			}
		}
		
	}
}
