package students.enities;

public class Student {
	private int id;
	private String username;
	private String sex;
	private int age;
	public Student() {
		super();
	}
	public Student(String username, String sex, int age) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
