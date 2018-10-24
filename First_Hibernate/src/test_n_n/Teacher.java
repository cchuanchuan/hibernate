package test_n_n;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int id;
	private String name;
	private Set<Course> cources = new HashSet<>();
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
	public Set<Course> getCources() {
		return cources;
	}
	public void setCources(Set<Course> cources) {
		this.cources = cources;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
}
