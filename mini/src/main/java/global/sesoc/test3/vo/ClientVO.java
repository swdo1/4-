package global.sesoc.test3.vo;

public class ClientVO {
	

	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String address;
	private String gender;
	private String birth;
	
	public ClientVO() {
	}

	public ClientVO(String id, String password, String email, String name, String phone, String address, String gender,
			String birth) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", phone="
				+ phone + ", address=" + address + ", gender=" + gender + ", birth=" + birth + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
	
	
	

}

