package test_n_1;

public class Copy_Student {
	private int id;
	private String name;
	private Test_Teacher teacher;
	public Copy_Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Copy_Student(String name) {
		super();
		this.name = name;
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
	public Test_Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Test_Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Copy_Student [id=" + id + ", name=" + name + "]";
	}
}
