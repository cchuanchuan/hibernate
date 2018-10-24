package component;

public class StudentInfo {
	private String name;
	private String classes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "StudentInfo [name=" + name + ", classes=" + classes + "]";
	}
}
