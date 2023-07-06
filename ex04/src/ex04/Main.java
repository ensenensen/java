package ex04;

public class Main {
	public static void main(String[] args) {
//		Juso.run();
//		Database.connect();
		StudentDAO dao = new StudentDAO();
		
		// 수정
		StudentVO stu = new StudentVO(13,"강감찬","서울","010-0000-0000");
		dao.update(stu);
		
		// 삭제
//		dao.delete(11);
		
		// 조회
//		System.out.println(dao.read(11));
		
		// 입력
//		StudentVO stu = new StudentVO(20,"박준수","인천","010-1111-1111");
//		dao.insert(stu);
		
		// 목록출력
		for(StudentVO vo:dao.list()) {
			System.out.println(vo.toString());
		}
	}
}
