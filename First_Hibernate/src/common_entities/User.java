package common_entities;

public class User {
	private int id;
	private String name;
	private String passowrd;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String passowrd) {
		super();
		this.name = name;
		this.passowrd = passowrd;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passowrd=" + passowrd +  "]";
	}
	
}
