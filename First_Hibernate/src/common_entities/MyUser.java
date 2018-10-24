package common_entities;

import java.util.Date;

public class MyUser {
	private int id;
	private String name;
	private String passowrd;
	private Date birthday;
	private String textContent;
	private int age;
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyUser(String name, String passowrd) {
		super();
		this.name = name;
		this.passowrd = passowrd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
