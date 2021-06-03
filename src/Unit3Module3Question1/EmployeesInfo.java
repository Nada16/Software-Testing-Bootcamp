package Unit3Module3Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeesInfo {
	public static void main(String[] args) {
		//Create a list of employees
		List<Employee> employees = new ArrayList<Employee>();
		Car tesla = new Car("Tesla", "blue", "02 B 5544");
		Car dodge = new Car("Dodge", "grey", "50 C 6824");
		Bike bmw = new Bike("BMW", "2233");
		Bike harley = new Bike("Harley", "5168");		
		
		employees.add(new Employee("Tony", "456234", tesla, bmw));
		employees.add(new Employee("Jim", "885486", dodge, bmw));
		employees.add(new Employee("David", "254863", dodge, harley));
		
		//Print employees' details using a stream
		Stream<Employee> stream = employees.stream();
		stream.forEach((employee)->{
			employee.printEmployee();
		});
	}
}
