package businesslogic;

public class Validation {
	
	public  boolean adminLogin(String username,String password) {
		if(username.equals("admin") && password.equals("admin@98"))
			return true;
	else 
			return false;
				}

}
