/**
 * 
 */
package SouthTeam;



/**
 * @author Praveena
 *
 */
public class Client {

	private final String name;
	private final String phoneNumber;
	private final String email;
	
	/**
	 * @param name
	 * @param phoneNumber
	 * @param email
	 */
	public Client(String name, String phoneNumber, String email) {


		if(name.isEmpty()) {
			throw new IllegalArgumentException("name missing!");
		}
		else {

			if(!validPhoneNumber(phoneNumber)) {
				throw new IllegalArgumentException("Invalid phonenumber!");
			}
			else {
				if(!emailCheck(email)) {

					throw new IllegalArgumentException("Invalid email");
				}
			}
		}

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public  String getName() {
		return name;
	}
	/**
	 * @return the phoneNumber
	 */
	public  String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @return the email
	 */
	public  String getEmail() {
		return email;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + phoneNumber.hashCode();
		result = prime * result + email.hashCode();
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Client) {
			Client that = (Client)obj;
			if(this.name.equals(that.name) 
				&& this.phoneNumber.equals(that.phoneNumber) 
					&& this.email == that.email ) {
				return true;
			}
		}
		return false;
		
	}

	// To check the valid email id
	public boolean emailCheck(String email)
	{
		//Regular expression to accept valid email id
		String regex = "^(.+)@(.+)$";
		boolean result = email.matches(regex);
		return result;
		
	}
    
	// To check the valid phone number
	public boolean validPhoneNumber(String pno) {

		//Regular expression to accept valid phone number
		String regex =  "\\d{11}";
		
		boolean result = pno.matches(regex);
		return result;

	}
	
	@Override
	public String toString() {
		return String.format("Client [name= %s | phoneNumber = %s| email= %s]", name, phoneNumber, email);
	}




}
