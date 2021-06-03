package Unit3Module3Question1;

public class Car {
	String carname;
	String color;
	String regno;
	
	public Car(String name, String color, String no) {
		carname = name;
		this.color = color;
		regno = no;
	}
	
	public void printCar() {
		//print car's details
		System.out.println("Car Name: " + this.carname);
		System.out.println("Car Color: " + this.color);
		System.out.println("Car Reg No: " + this.regno);
	}
}
