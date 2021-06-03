package Unit3Module3Question1;

public class Bike {
	String bikename;
	String regno;
	
	public Bike(String name, String no) {
		bikename = name;
		regno = no;
	}
	public void printBike() {
		//print bike's details
		System.out.println("Bike Name: " + this.bikename);
		System.out.println("Bike Reg No: " + this.regno);
	}
}
