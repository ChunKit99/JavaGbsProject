package basic;

/**
 *
 * @author Yong Liang
 */
public abstract class Account {

	public final String username;
	private String password;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
