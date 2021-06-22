import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public interface JC {
	
	public void show();
	public default void remove(){
		System.out.println("heloooo");
		
		List<Integer> values = Arrays.asList(1,3,4,5,33,22);
		values.forEach(i -> System.out.println(i));
	}

}
