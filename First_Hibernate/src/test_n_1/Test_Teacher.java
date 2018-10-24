package test_n_1;

import java.util.HashSet;
import java.util.Set;

public class Test_Teacher {
	private int id;
	private String name;
	private Set<Test_Student> students = new HashSet<>();
	public Test_Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test_Teacher(String name) {
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
	public Set<Test_Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Test_Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Test_Teacher [id=" + id + ", name=" + name + "]";
	}
}
