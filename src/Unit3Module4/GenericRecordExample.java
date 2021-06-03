package Unit3Module4;

public class GenericRecordExample {
	public static void main(String[] args) {
		//Create an instance of the record "Employee"
		Employee emp = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com", 38);
		
		//Print the details of the record
		System.out.println(emp.id());
		System.out.println(emp.email());
		System.out.println(emp);
	}
}

//Defining the record "Vehicle"
@SuppressWarnings("preview")
record Employee (int id, String firstName, String lastName, String email, int age) {
	
}
