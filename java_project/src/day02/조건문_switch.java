package day02;

import java.util.Scanner;

public class 조건문_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자입력> ");
////		int a = sc.nextInt();
//		String a = sc.next();
//		
//		switch(a) {
//		case "1":
//			System.out.println("1을 선택하였습니다");
//			break;
//		case "2":
//			System.out.println("2를 선택하였습니다");
//			break;
//		case "3":
//			System.out.println("3을 선택하였습니다");
//			break;
//			default:
//				System.out.println("1~3까지 입력하세요");
//		}
		
		// 입력한 월의 영어 출력
		// January
		// February
		// March
		// April
		// May
		// June
		// July
		// August
		// September
		// October
		// November
		// December
		System.out.print("월 입력> ");
		int month = sc.nextInt();
		
		if(month == 1) {
			System.out.println("January");
		}else if(month == 2) {
			System.out.println("February");
		}
		
//		switch(month) {
//		case 1:
//			System.out.println("January");
//			break;
//		case 2:
//			System.out.println("February");
//			break;
//		case 3:
//			System.out.println("March");
//			break;
//		case 4:
//			System.out.println("April");
//			break;
//		case 5:
//			System.out.println("May");
//			break;
//		case 6:
//			System.out.println("June");
//			break;
//		case 7:
//			System.out.println("July");
//			break;
//		case 8:
//			System.out.println("August");
//			break;
//		case 9:
//			System.out.println("September");
//			break;
//		case 10:
//			System.out.println("October");
//			break;
//		case 11:
//			System.out.println("November");
//			break;
//		case 12:
//			System.out.println("December");
//			break;
//			default:
//				System.out.println("1~12까지 입력");
//		}
		
	}

}







