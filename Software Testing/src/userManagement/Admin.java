package userManagement;

public class Admin extends User{
	
	public Admin() {
		this.isEditor = true;
		this.isPermitted = true;
		this.isRestricted = false;
	}
	
	@Override
	public String generateUsername() {
		String username ="A." + email.substring(0, email.indexOf('@'));
		return username;
	}
	

	//Overloaded methods for changing the privilege of a user
	public void setPrivilege(User user, boolean isEditor) {
		user.isEditor = isEditor;
	}
	public void setPrivilege(User user, boolean isEditor, boolean isPermitted) {
		user.isEditor = isEditor;
		user.isPermitted = isPermitted;
	}
	public void setPrivilege(User user, boolean isEditor, boolean isPermitted, boolean isRestricted) {
		user.isEditor = isEditor;
		user.isPermitted = isPermitted;
		user.isRestricted = isRestricted;
	}
	
	//changing the privilege of adding apps permission only
	public void setAddAppsPermission(User user, boolean isPermitted) {
		user.isPermitted = isPermitted;
	}
	
	//changing the privilege of viewing app restriction only
	public void setViewingAppRestriction(User user, boolean isRestricted) {
		user.isRestricted = isRestricted;
	}
}
