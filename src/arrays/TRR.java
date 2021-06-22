package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TRR {

	public static void main(String[] args) {

		int A[] = { 2, 6, 4, 8, 10, 9, 15 };

		int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, A[i]);
			min = Math.min(min, A[n - 1 - i]);

			if (A[i] < max)
				end = i;

			if (A[n - 1 - i] > min)
				beg = n - 1 - i;
		}

		int res = end - beg + 1;

		int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		for (int a[] : merge(intervals))
			System.out.print(a[0] + " " + a[1] + " ");
		
		int []nums = {23,2,4,6,7}; int k = 6;
		System.out.println(checkSubarraySum(nums, k));
	}

	static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			}
			// otherwise, there is overlap, so we merge the current and previous
			// intervals.
			else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}

	static boolean checkSubarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				put(0, -1);
			}
		};
		
		int runningSum = 0;

		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			
			if (k != 0)
				runningSum %= k;
			
			Integer prev = map.get(runningSum);
			
			if (prev != null) {
				if (i - prev > 1)
					return true;
			} else
				map.put(runningSum, i);
		}
		return false;
	}
}
