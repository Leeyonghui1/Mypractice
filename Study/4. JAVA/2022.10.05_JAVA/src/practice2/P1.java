package practice2;

public class P1 {

	public static void main(String[] args) {
		// Student클래스를 UnivStudent가 잘 상속했는지 체크
		
		Student s1 = new Student();
		UniversityStudent u1 = new UniversityStudent();
		UnivStudent us1 = new UnivStudent();
		
		s1.setAge(10);
		s1.setName("노민영");

		u1.setAge(20);
		u1.setName("이현민");
		u1.setHakbeon("001");
		
		us1.setAge(30);
		us1.setName("이유나");
		us1.setHakbeon("002");
	}

}
