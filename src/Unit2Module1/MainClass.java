package Unit2Module1;
import java.util.Calendar;
import java.util.Formatter;

public class MainClass {
	static public void main(String[] args) {
		Formatter fmt = new Formatter();
		Calendar cal = Calendar.getInstance();
		fmt.format("%tb", cal);
		System.out.println(fmt);
	}
}
