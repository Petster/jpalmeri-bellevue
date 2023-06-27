package palmeri_08;

public class User {
	private String username = "";
	private String password = "";
	private String email = "";
	private Integer id;
	
	public User() {}
	
	public User(Integer id, String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
	}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void setUsername(String newName) {
		this.username = newName;
	}
	
	public void setPassword(String newPass) {
		this.password = newPass;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
}
