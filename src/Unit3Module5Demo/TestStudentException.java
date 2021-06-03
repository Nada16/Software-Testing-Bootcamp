package Unit3Module5Demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestStudentException {
	@Test
	public void testUsernameIsNull() {

		//Anonymous class Alert

		assertThrows(NullPointerException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				StudentException studentException=new StudentException(new Student(1,54.5f,null));           
				studentException.throwNull();

			}
		});
	}
}
