package day10;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		// 배열
		String[] a = new String[10];
		a[0] = "안녕";
		a[1] = "반가워요";
		a[2] = "잘있어요";
		System.out.println(a[0]);
		a[0] = "안녕하세요";
		
		// arrayList
		ArrayList<String> b = new ArrayList<String>(); // 어레이리스트 생성 
		b.add("안녕"); // 값 추가
		b.add("반가워요");
		b.add("잘있어요");
		System.out.println(b.get(0)); // 값 확인
		b.set(0, "안녕하세요"); // 값 변경
		
		// a와 b의 값을 for문으로 출력
		
		// 안녕하세요
		// 반가워요
		// 잘있어요
		// 안녕하세요
		// 반가워요
		// 잘있어요
		
		for(int i=0; i<3; i++) {
			System.out.println(a[i]);
		}
		for(int i=0; i<b.size(); i++) { // size()는 리스트의 길이
			System.out.println(b.get(i));
		}
		
	}

}




