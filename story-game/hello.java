public class hello {
	public static void main(String[] args){
		
		Student s1 = new Student();
		Student s2 = new Student();
		s1.id =101;
		s1.name="AJ";
		s1.department = "CS";

		
		s2.id =102;
		s2.name="HEXAA";
		s2.department= "CSE";
		System.out.println(s1.name);

		s1.displayDetails();
		s2.displayDetails();
		
		
		
	}
	
}
