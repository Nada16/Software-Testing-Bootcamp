package userManagement;

public class Contributor extends User{
	public Contributor() {
		this.isEditor = false;
		this.isPermitted = false;
		this.isRestricted = true;
	}
	
	@Override
	public String generateUsername() {
		String username ="C." + email.substring(0, email.indexOf('@'));
		return username;
	}
}
