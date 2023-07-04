package ex02;
import java.util.*;

public class Sungjuk {
	public static void run() {
		Scanner s=new Scanner(System.in);
		List<ScoreVO> array=new ArrayList<>();
		ScoreVO score=new ScoreVO("2023-1", "홍길동", 90,77,80);
		array.add(score);
		score=new ScoreVO("2023-2", "심청이", 98,96,85);
		array.add(score);
		score=new ScoreVO("2023-3", "강감찬", 89,92,97);
		array.add(score);
		
		boolean run=true;
		int count = 3;
		while(run) {
			System.out.println("******* 성적관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.입력 |2.조회 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("프로그램 종료");
				break;
			case "1":
				score = new ScoreVO();
				score.setNo("2023-"+(count+1));
				System.out.println("학번>"+score.getNo());
				System.out.print("이름>");
				score.setName(s.nextLine());
				System.out.print("국어>");
				score.setKor(Integer.parseInt(s.nextLine()));
				System.out.print("영어>");
				score.setEng(Integer.parseInt(s.nextLine()));
				System.out.print("수학>");
				score.setMat(Integer.parseInt(s.nextLine()));
				array.add(score);
				count++;
				System.out.println(count+"명 입력완료");
				break;
			case "2":
				System.out.print("조회할 이름> ");
				String search = s.nextLine();
				score = search(array, search);
				if(score.getName() == null) {
					System.out.println(search+"학생이 없습니다.");
				}else {
					score.print_port();
				}
				
				break;
			case "3"://목록
				for(ScoreVO vo:array) {
					vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
					vo.setAvg(vo.getTot()/3.);
					String grade=getGrade(vo.getAvg());
					vo.setGrade(grade);
					vo.print_land();
				}
				break;
			case "4":
				break;
			case "5":	//삭제
				System.out.print("삭제할 이름> ");
				String delete = s.nextLine();
				score = search(array,delete);
				if(score.getName()==null) {
					System.out.println(delete+"학생이 없습니다.");
				}else {
					array.remove(score);
					System.out.println("삭제 완료!");
				}
				break;
			default:
				System.out.println("메뉴 다시 선택");
			}//switch
			System.out.println();
		}//while
		
	}//run
	
	//학점구하기
	public static String getGrade(double avg) {
		String grade="";
		if(avg>=90) {
			if(avg>=95) {
				grade="A+";
			}else {
				grade="A0";
			}		
		}else if(avg>=80) {
			if(avg>=85) {
				grade="B+";
			}else {
				grade="B0";
			}
		}else if(avg>=70) {
			if(avg>=75) {
				grade="C+";
			}else {
				grade="C0";
			}
		}else if(avg>=60) {
			if(avg>=65) {
				grade="D+";
			}else {
				grade="D0";
			}
		}else {
			grade="F";
		}
		return grade;
	}
	
	// 검색
	public static ScoreVO search(List<ScoreVO> array, String name) {
		ScoreVO vo = new ScoreVO();
		for(ScoreVO score:array) {
			if(name.equals(score.getName())) {
				score.setTot(score.getKor()+score.getEng()+score.getMat());
				score.setAvg(score.getTot()/3.);
				score.setGrade(getGrade(score.getAvg()));
				vo = score;
			}
		}	
		return vo;
	}
	
	
}//class