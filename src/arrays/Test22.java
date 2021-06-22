package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test22 {

	public static void main(String[] args) {

		List<Integer> lst = new ArrayList();
		lst.add(null);
		lst.add(10);
		lst.add(15);
		
		
		System.out.println(lst.stream().filter(e -> e!=null ).collect(Collectors.toList()));
	}

}
