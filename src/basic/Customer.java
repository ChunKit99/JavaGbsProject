package basic;

/**
 *
 * @author Kong Choon
 */
public class Customer extends Account implements PersonalDetail {//

	private String name;
	private String email;
	private String phoneNumber;
	private String gender;

	public Customer(String username, String password, String name, String email, String phoneNumber, String gender) {
		super(username, password);
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
