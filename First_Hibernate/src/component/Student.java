package component;

public class Student {
	private int id;
	private StudentInfo Info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentInfo getInfo() {
		return Info;
	}
	public void setInfo(StudentInfo info) {
		Info = info;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Info=" + Info + "]";
	}
	
}
