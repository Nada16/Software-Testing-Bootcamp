package Unit3Module4;

public class RecordExample {
	
	public static void main(String[] args) {
		//Create an instance of the record "Vehicle"
		Vehicle v = new Vehicle("Mercedes", "UX 1238 A95");
		
		//Print the details of the record
		System.out.println(v.brand());
		System.out.println(v.licensePlate());
		System.out.println(v.toString());
	}	
	
}

//Defining the record "Vehicle"
@SuppressWarnings("preview")
record Vehicle(String brand, String licensePlate) {

}
