package Unit3Module5Demo;

public class StudentException {
	private String name;
	private Student student;

	public StudentException(Student student) {
		this.student = student;
		name=student.getName();
	}

	//if name is null, throws a null pointer
	public void throwNull() {

		if (name == null) {
			throw new NullPointerException("Username cannot be blank");
		} 
	}

	public Student getStudent() {
		return student;
	}

}