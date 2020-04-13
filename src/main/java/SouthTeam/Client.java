/**
 * 
 */
package SouthTeam;

/**
 * @author 
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


		if(name == null || name.isEmpty()) {
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
	 * @return the phoneNumabe
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	public boolean emailCheck(String email)
	{
		int a = email.indexOf('@');
		int b = email.indexOf('.');
		if (a > -1)
			return true;
		if (b > -1)
			return true;
		if (a<b)
			return true;
		else
			return false;
	}

	public boolean validPhoneNumber(String pno) {

		//Regular expression to accept valid phone number
		String regex =  "\\d{11}";
		
		boolean result = pno.matches(regex);
		return result;

	}
	@Override
	public String toString() {
		return String.format("Client [name=%s, phoneNumber =%s, email=%s]", name, phoneNumber, email);
	}






}
