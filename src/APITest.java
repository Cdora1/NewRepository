import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class APITest {

	public static void main(String[] args) {

		linkedList();
		stack();
		queue();
		priorityQueue();
		str();

		System.out.println("Contains check " + "JayaChandra".contains("J"));
	}

	static void linkedList() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.addFirst(0);
		ll.addLast(3);
		ll.add(2, 2);
		ll.forEach((a) -> System.out.print(a + " "));
	}

	static void stack() {
		Stack st = new Stack();
		st.push(5);
		st.push("stack");
		st.push("st1");
		st.remove("stack");
		System.out.println("Index Of " + st.indexOf("st1"));
		System.out.println(st.pop() + " , " + st.pop());
	}

	static void queue() {
		Queue qu = new LinkedList<>();
		qu.add(1);
		qu.add("queue");
		System.out.println(qu.poll() + " , " + qu.poll());
	}

	static void priorityQueue() {
		List<Integer> ll = new ArrayList<>();
		ll.add(1);
		ll.add(9);

		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

		PriorityQueue<Integer> qu1 = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		qu.add(3);
		qu.add(1);
		qu.add(8);
		qu.addAll(ll);

		qu.forEach((a) -> System.out.print(a + " "));
	}

	static void str() {
		String str = "JayaChandra".toLowerCase();
		char ch[] = str.toCharArray();
		System.out.println("CharAT " + str.charAt(0) + " " + str.indexOf('C'));

		int arr[] = new int[26];
		for (char c : str.toCharArray()) {
			arr[c - 'a']++;
		}

		for (int in : arr)
			System.out.print(in + " ");
	}

	static String strReverse(String str) {

		StringBuilder sb = new StringBuilder();
		Stack st = new Stack();
		
		for (char ch : str.toCharArray())
			st.add(ch);

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return st.toString();
	}
}
