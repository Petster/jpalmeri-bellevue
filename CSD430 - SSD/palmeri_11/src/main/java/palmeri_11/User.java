package palmeri_11;

public class User {
	private String firstname = "";
	private String lastname = "";
	private String username = "";
	private String password = "";
	private String email = "";
	private String phone = "";
	private String homeaddress = "";
	private String state = "";
	private String color = "";
	private String joindate = "";
	private String  role = "";
	private int isAdmin;
	private Integer id;
	
	public User() {}
	
	public User(Integer id, String username, String password, String email, String phone, String joindate, String role, int isAdmin, String firstname, String lastname, String homeaddress, String state, String color) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
		this.phone = phone;
		this.joindate = joindate;
		this.role = role;
		this.isAdmin = isAdmin;
		this.firstname = firstname;
		this.lastname = lastname;
		this.homeaddress = homeaddress;
		this.state = state;
		this.color = color;
	}
	
	public User(String username, String password, String email, String phone, String joindate, String role, int isAdmin, String firstname, String lastname, String homeaddress, String state, String color) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.joindate = joindate;
		this.role = role;
		this.isAdmin = isAdmin;
		this.firstname = firstname;
		this.lastname = lastname;
		this.homeaddress = homeaddress;
		this.state = state;
		this.color = color;
	}
	
	/*creating user*/
	public User(String username, String password, String email, String phone, String firstname, String lastname, String homeaddress, String state, String color) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.homeaddress = homeaddress;
		this.state = state;
		this.color = color;
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
	
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	
	public void setJoindate(String newJD) {
		this.joindate = newJD;
	}
	
	public void setRole(String newRole) {
		this.role = newRole;
	}
	
	public void setAdmin(int i) {
		this.isAdmin = i;
	}
	
	public void setFirstname(String i) {
		this.firstname = i;
	}
	
	public void setLastname(String i) {
		this.lastname = i;
	}
	
	public void setHome(String i) {
		this.homeaddress = i;
	}
	
	public void setState(String i) {
		this.state = i;
	}
	
	public void setColor(String i) {
		this.color = i;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getState() {
		return state;
	}
	
	public String getHome() {
		return homeaddress;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public int getAdmin() {
		return isAdmin;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getJoindate() {
		return joindate;
	}
	
	public String getPhone() {
		return phone;
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
