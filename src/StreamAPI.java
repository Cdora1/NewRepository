import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.camel.model.dataformat.SyslogDataFormat;

public class StreamAPI {

	static List<String>list = populateList();
	static Map<String, String> map = populateMap();
	public static void main(String[] args) {
		int []arr = new int[] {1,3,3,4};
		System.out.println(Arrays.stream(arr).filter(value -> value>=3).sum());
		
		
		System.out.println("populate stream from list");
		list.stream().forEach(a -> System.out.println(a));
		
		System.out.println("populate map using stream from map help of entrySet()");
		map.entrySet().stream().forEach(a-> System.out.println(a));
		
		System.out.println("populate map using stream from map help of keySet() ");
		map.keySet().stream().forEach(a ->System.out.println(a));
		
		System.out.println("populate map using values()");
		map.values().stream().forEach(a-> System.out.println(a));
		
		System.out.println("Obtain stream from a stream using chars");
		"asdasfas2353245234".chars().forEach(a->System.out.println(Character.toChars(a)));
		
		System.out.println("Obtain stream from a string using split()");
		Stream.of("a,b,c,d", ",").forEach(a->System.out.println(a));
		
		System.out.println("Obtain stream from a stream using array");
		Integer array[] = {1,2,3,4};
		Stream.of(array).forEach(a->System.out.println(a));
		
		System.out.println("Obtain stream of values");
		Stream.of("one","two","three").forEach(a ->System.out.println(a));
		System.out.println("Obtain stream from funtion generate");
		Stream.generate(()->{return Math.random();}).limit(2).forEach(a->System.out.println(a));
		
		System.out.println("Obtain stream from funtion iterate");
		Stream.iterate(0, i->i+1).limit(3).forEach(a -> System.out.println(a));
		
		System.out.println("Obtain stream from funtion iterate");
		Stream.builder().add("one").add("two").add("Three").build().forEach(a ->System.out.println(a));
		System.out.println("Obtain stream from funtion iterate");

	}
	
	public static List<String> populateList(){
		List<String> list = new ArrayList<String>();
		
		list.add("jc1");
		list.add("jc2");
		list.add("jc3");
		
		return list;
	}
	
	public static Map<String, String> populateMap(){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
		return map;
	}

}
