import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Demo {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,3,4,5,33,22);
		//values.forEach(i -> System.out.println(i));
		
		Consumer<Integer> c = new Consumer<Integer>() {

			@Override
			public void accept(Integer arg0) {
				System.out.println(arg0);
				
			}
			
		};

		values.forEach(c);
		//values.stream().
		System.out.println(" Print " + "jcasfsdfasdfsasdwqer1234123412".hashCode());
	}

}
