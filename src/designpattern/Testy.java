package designpattern;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Testy {
	
	public static void main(String args[]) {
		int arr[] = {1,1,1,2,3,4,5,5,5};
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> b.getValue() - a.getValue());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int in : arr)
			map.put(in, map.getOrDefault(in, 0)+1);
		
		pq.addAll(map.entrySet());
		
		int count =0;
		while(count <2) {
			System.out.println(pq.poll().getKey());
			count++;
		}
	}
}

class IntC implements Comparator<Integer>{
	
	@Override
	public int compare(Integer a, Integer b) {
		return b -a;
	}
}
