package test;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("문자 입력> ");
//		String a = sc.next();	// 문자 입력(String)
//		System.out.print("숫자 입력> ");
//		int b = sc.nextInt();	// 정수 입력(int)
//		
//		System.out.println(a);
//		System.out.println(b);
		
		// Scanner로 숫자 입력받고 양수, 음수, 0 출력하기
//		System.out.print("숫자 입력> "); //(밑에 것) 입력받을때 무조건 써야함
//		int num = sc.nextInt();
//		if(num>0) {
//			System.out.println("양수");
//		}else if(num<0) {
//			System.out.println("음수");
//		}else {
//			System.out.println("0");
//		}
		
		
		
		
		
		
		
		
		// Scanner로 숫자 입력받고 양수, 음수, 0 출력하기
//		System.out.print("숫자 입력 ");
//		int num = sc.nextInt(); //입력받을땐 무조건 sc 기억해라!
//		if (num>0) {
//			System.out.println("양수");
//		}else if (num<0) {
//			System.out.println("음수");
//		}else {
//			System.out.println("0");
//		}
		
		
		
		// Scanner로 숫자 입력받고 짝수, 홀수 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		if (num>2) {
			System.out.println("양수");
		}else if (num<0) {
			System.out.println("음수");
		}else {
			System.out.println("0");
		}
		
		
		

	}

}
