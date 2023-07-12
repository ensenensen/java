package ex09;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserDAO udao=new UserDAO();
		
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n\n******* 메시지관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.사용자목록|2.사용자조회|3.사용자수정|4.사용자등록|5.사용자삭제|0.종료");
			System.out.println("6.메시지관리");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case "1":
				for(UserVO vo:udao.list()) {
					System.out.printf("%s\t%s\t%s\t%d\n",
							vo.getId(),vo.getUname(),vo.getPhone(),vo.getPoint());
				}
				System.out.println(udao.list().size()+"명 등록되었습니다.");
				break;
			case "2":
				System.out.print("조회할 ID>");
				String id=s.nextLine();
				if(id=="") {
					System.out.println("조회를 종료합니다.");
					break;
				}else {
					UserVO uvo=udao.read(id);
					if(uvo.getUname()==null) {
						System.out.println("사용자가 존재하지 않습니다.");
					}else {
						System.out.println("사용자이름:"+uvo.getUname());
						System.out.println("사용자전화번호:"+uvo.getPhone());
						System.out.println("사용자포인트:"+uvo.getPoint());
					}
				}
				
				break;
			case "3":
				System.out.print("수정할 ID>");
				id=s.nextLine();
				if(id=="") {
					System.out.println("수정을 종료합니다!");
				}else {
					UserVO uvo=udao.read(id);
					if(uvo.getUname()==null) {
						System.out.println("사용자가 존재하지 않습니다.");
					}else {
						System.out.print("이름:"+uvo.getUname()+">");
						String uname=s.nextLine();
						if(uname != "") uvo.setUname(uname);
						System.out.print("전화:"+uvo.getPhone()+">");
						String phone=s.nextLine();
						if(phone != "") uvo.setPhone(phone);
						System.out.println("수정하실래요(Y)?>");
						String sel=s.nextLine();
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
							udao.update(uvo);
							System.out.println("수정이 완료되었습니다.");
						}else {
							System.out.println("수정이 취소되었습니다.");
						}
					}
				}
				break;
			case "4":
				while(true) {
					System.out.print("아이디>");
					id=s.nextLine();
					if(id=="") {
						System.out.println("등록을 취소합니다.");
						break;
					}else {
						UserVO uvo = udao.read(id);
						if(uvo.getUname()==null) {
							uvo.setId(id);
							System.out.print("이름>");
							String sname=s.nextLine();
							if(sname=="") {
								System.out.println("이름 필수!!");
								break;
							}else {
								uvo.setUname(sname);
								System.out.print("전화번호>");
								String phone=s.nextLine();
								uvo.setPhone(phone);
								System.out.println("등록하실래요(Y)?>");
								String sel=s.nextLine();
								if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
									udao.insert(uvo);
									System.out.println("등록이 완료되었습니다.");
								}else {
									System.out.println("등록이 취소되었습니다.");
								}
							}
							
							
							break;
						}else {
							System.out.println("사용중인 아이디입니다.");
						}
					}
				}
				break;
			case "5":
				System.out.print("삭제할 ID>");
				id=s.nextLine();
				if(id=="") {
					System.out.println("삭제를 취소합니다.");
				}else {
					UserVO uvo=udao.read(id);
					if(uvo.getUname()==null) {
						System.out.println("사용자가 존재하지 않습니다.");
					}else {
						System.out.println("사용자이름:"+uvo.getUname());
						System.out.println("삭제하실래요(Y)?>");
						String sel=s.nextLine();
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
							try {
								udao.delete(id);
								System.out.println("삭제가 완료되었습니다.");
							}catch(Exception e) {
								System.out.println("삭제를 실패했습니다.");
							}
							
						}else {
							System.out.println("삭제가 취소되었습니다.");
						}
					}
				}
				break;
			case "6":
				System.out.print("아이디>");
				id=s.nextLine();
				if(id==""){
					System.out.println("메시지관리를 취소합니다.");
				}else {
					UserVO vo = udao.read(id);
					if(vo.getUname()!=null) {
						Messages.run(vo);
					}
				}
			default: 
				System.out.println("메뉴를 다시선택하세요!");
			}//switch
		}//while
	}//main
}//class
