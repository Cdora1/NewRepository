import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ttttt {

	public static void main(String[] args) {

		int nums[] = { 7, 7, 3, 3, 2, 1, 5, 5, 5, 5, 5, 8, 9, 7 };
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		for (Map.Entry<Integer, Integer> keySet : map.entrySet())
			pq.offer(keySet);

		List<Integer> res = new ArrayList<>();

		while (pq != null) {
			int number = pq.peek().getKey();
			int n = map.get(pq.peek().getKey());
			for (int i = 0; i < n - 1; i++) {
				res.add(number);
			}
			pq.poll();
		}

		System.out.println(res);
	}

}
