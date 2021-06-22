import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class TestExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 7, 5, 6, 8, 2, 4, 3, 7);
		// count, sum, max, min, average

		Set<Integer> set = list.stream().collect(Collectors.toSet());

		set.forEach(System.out::println);

		// Long l = set.stream().map(i -> i).max(comparator);
		// System.out.println(l);
		// Map<String, List<Integer>> map = set.stream().filter(i ->
		// i%2==0).collect(supplier, accumulator, combiner)
		// set.stream().s

		/*
		 * List customerProfiles = new ArrayList<>(); for (Campaign c : campaigns) { if
		 * (c.isActive()) { for (Participant p : c.getParticipants()) { if
		 * (p.getCampaignCode() == 1) { customerProfiles.add(p.getCustomerProfile()); }
		 * } } }
		 * 
		 * campaigns.stream().filter(c -> c::isActive)
		 */

		Queue<Integer> q = new PriorityQueue<>();
		for (Integer in : list)
			q.add(in);

		while (!q.isEmpty())
			System.out.print(q.poll() + " ");

		Queue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});

		for (Integer in : list)
			maxPQ.add(in);

		while (!maxPQ.isEmpty())
			System.out.print(maxPQ.poll() + " ");

	}

}
