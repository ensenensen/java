package ex08;

import java.text.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		AccountDAO adao = new AccountDAO();
		DetailDAO ddao = new DetailDAO();
		
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n\n******* 계좌관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 |2.계좌조회 |3.입금 |4.출금 |5.계좌목록 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case "1":
				AccountVO acc = new AccountVO();
				
				System.out.print("계좌주명>");
				String name=s.nextLine();
				if(name=="") break;
				else acc.setAname(name);
				
				int balance = input("초기입금액");
				if(balance==0) break;
				else acc.setBalance(balance);
				
				System.out.print("새로운 계좌 생성하시겠습니까?(Y)>");
				String sel=s.nextLine();
				if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
					int newano=adao.insert(acc);
					System.out.println(newano+"번 새로운 계좌가 생성되었습니다.");
					//거래내역저장
					DetailVO dvo=new DetailVO();
					dvo.setAno(newano);
					dvo.setAmount(balance);
					dvo.setType("입금");
					ddao.insert(dvo);
				}
//				
				break;
			case "2":
				while(true) {
					int ano=input("\n조회할 계좌번호");
					if(ano==0) {
						System.out.println("조회를 종료합니다.");
						break;
					}else {
						try {
							AccountVO vo = adao.read(ano);
							if(vo.getAname()==null) {
								System.out.println("해당 계좌가 존재하지 않습니다.");
							}else {
								System.out.println("계좌주:"+vo.getAname());
								System.out.println("잔액:"+df.format(vo.getBalance()));
								System.out.println("\n거래번호\t금액\t\t거래유형\t날짜");
								System.out.println("------------------------------------------");
								for(DetailVO dvo:ddao.list(ano)) {
									System.out.printf("%d\t%-10s\t%s\t%s\n",
											dvo.getDno(),df.format(dvo.getAmount()),dvo.getType(),sdf.format(dvo.getDdate()));
								}
							}
						} catch (Exception e) {
							System.out.println("계좌조회:"+e.toString());
						}
					}
				}
				
				break;
			case "3":
				int ano=input("입금계좌번호");
				if(ano==0) {
					System.out.println("입금을 취소합니다.");
				}else {
					try {
						AccountVO acc1 = adao.read(ano);
						if(acc1.getAname()==null) {
							System.out.println("해당 계좌가 존재하지 않습니다.");
						}else {
							System.out.println("계좌주:"+acc1.getAname());
							System.out.println("잔액:"+df.format(acc1.getBalance()));
							int amount = input("입금금액");
							if(amount==0) {
								System.out.println("입금을 취소합니다.");
							}else {
								acc1.setBalance(acc1.getBalance()+amount);
								adao.update(acc1);
								DetailVO dvo = new DetailVO();
								dvo.setAno(ano);
								dvo.setType("입금");
								dvo.setAmount(amount);
								ddao.insert(dvo);
								System.out.println("입금이 완료되었습니다.");
							}
							
						}
					} catch (Exception e) {
						System.out.println("입금조회:"+e.toString());
					}
				}
				break;
			case "4":
				ano=input("출금계좌번호");
				if(ano==0) {
					System.out.println("출금을 취소합니다.");
				}else {
					try {
						AccountVO acc2 = adao.read(ano);
						if(acc2.getAname()==null) {
							System.out.println("해당 계좌가 존재하지 않습니다.");
						}else {
							System.out.println("계좌주:"+acc2.getAname());
							System.out.println("잔액:"+df.format(acc2.getBalance()));
							while(true) {
								int amount = input("출금금액");
								if(amount==0) {
									System.out.println("출금을 취소합니다.");
									break;
								}else {
									if(acc2.getBalance()>=amount) {
										acc2.setBalance(acc2.getBalance()-amount);
										adao.update(acc2);
										DetailVO dvo = new DetailVO();
										dvo.setAno(ano);
										dvo.setType("출금");
										dvo.setAmount(amount);
										ddao.insert(dvo);
										System.out.println("출금이 완료되었습니다.");
										break;
									}else {
										System.out.println("잔액이 부족합니다.");
									}						
								}
							}			
						}
					} catch (Exception e) {
						System.out.println("출금조회:"+e.toString());
					}
				}
				break;
			case "5":
				System.out.println("\n계좌번호\t계좌주명\t잔액");
				System.out.println("--------------------------------");
				for(AccountVO avo:adao.list()) {
					System.out.printf("%d\t%s\t%s\n",
							avo.getAno(),avo.getAname(),df.format(avo.getBalance()));
				}
				break;
			default: 
				System.out.println("메뉴를 다시선택하세요!");
			}//switch
		}//while
	}//main
	
	// 숫자 체크 메소드
	public static int input(String title) {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print(title+">");
			String str=s.nextLine();
			try {
				if(str=="") return 0;
				else return Integer.parseInt(str);
			}catch(Exception e) {
				System.out.println("숫자를 입력하세요!");
			}
		}
	}
}//class
