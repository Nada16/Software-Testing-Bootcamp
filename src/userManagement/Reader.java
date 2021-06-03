package userManagement;

public class Reader extends User{
	public Reader() {
		this.isEditor = false;
		this.isPermitted = false;
		this.isRestricted = true;
	}
	
	@Override
	public String generateUsername() {
		String username ="R." + email.substring(0, email.indexOf('@'));
		return username;
	}
}
