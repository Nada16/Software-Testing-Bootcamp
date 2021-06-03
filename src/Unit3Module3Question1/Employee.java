package Unit3Module3Question1;
public class Employee {
	String empname;
	String empid;
	Car car;
	Bike bike;
	
	public Employee(String name, String id, Car car, Bike bike) {
		empname = name;
		empid = id;
		this.car = car;
		this.bike = bike;
	}
	
	public void printEmployee() {
		//print employee's details
		System.out.println("----------Employee Details:----------");
		System.out.println("Employee Name: " + this.empname);
		System.out.println("Employee ID: " + this.empid);
		System.out.println("----------Employee's car details:----------");
		car.printCar();
		System.out.println("----------Employee's bike details:----------");
		bike.printBike();
		System.out.println("\n");
	}
}
