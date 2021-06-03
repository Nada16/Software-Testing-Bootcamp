package userManagement;
import java.util.Date;  

abstract class User {

	//User attributes 
	String name, email, payment, preferences, address;
	String dob; //format dd/mm/yyyy
	
	boolean isEditor; //true = can edit, false = viewer
	boolean isPermitted; //true = permitted to add apps, false = not permitted
	boolean isRestricted; //true = viewing apps is restricted, false = viewing apps isn't restricted

	public abstract String generateUsername();

	@SuppressWarnings("deprecation")
	public int calculateAge() {
		//casting birth date to get birth year
		String strYear = dob.substring(6);
		int year = Integer.parseInt(strYear);

		//get current year
		Date d = new Date();		
		int age = d.getYear()+1900-year;

		//return age value
		return age;
	}
		
}
