package day07;

import java.util.Scanner;

public class sdafsadfadfadfsadf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int balance = 10000;
		
		while (run) {
			System.out.println("=====자판기=====" + "잔액 : " + balance + "원");
			System.out.println("1. 콜라(1000원) 2. 사이다 3. 우유 4. 충전 5. 종료");
			System.out.println("메뉴선택 : ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				if (balance >= 1000) {  
					balance = balance - 1000;
				}else {
				}
			}
		}

	}

}
