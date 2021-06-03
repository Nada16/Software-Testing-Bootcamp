package Unit3Module5Demo;

public class Student {
	String stdname;
	int id;
	float percentage;
	
	public Student(int id, float per, String name) {
		this.id = id;
		percentage = per;
		stdname = name;
	}
	
	public String getName() {
		return stdname;
	}
}
