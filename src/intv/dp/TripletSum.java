package intv.dp;

import java.util.Arrays;

public class TripletSum {

	public static boolean tripletExists(int[] A, int n, int sum, int count) {
		// if triplet has desired sum, return true
		if (count == 3 && sum == 0) {
			return true;
		}

		// return false if sum is not possible with given array
		if (count == 3 || n == 0 || sum < 0) {
			return false;
		}

		// recur with including current element and excluding current element
		return tripletExists(A, n - 1, sum - A[n - 1], count + 1) || tripletExists(A, n - 1, sum, count);
	}

	// Find Triplet with given sum in an array
	public static void main(String[] args) {
		int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int sum = 6;

		if (tripletExists(A, A.length, sum, 0)) {
			System.out.print("Triplet Exists");
		} else {
			System.out.print("Triplet Don't Exist");
		}
		System.out.println();
		find3Numbers(A, A.length, sum);
	}

	static boolean find3Numbers(int A[], int arr_size, int sum) {

		int l, r;
		Arrays.parallelSort(A);

		for (int i = 0; i < arr_size - 2; i++) {

			l = i + 1; // index of the first element in the remaining elements
			r = arr_size - 1; // index of the last element
			while (l < r) {
				if (A[i] + A[l] + A[r] == sum) {
					System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
					return true;
				} else if (A[i] + A[l] + A[r] < sum)
					l++;
				else 
					r--;
			}
		}

		return false;
	}

	public static void printAllTriplets(int[] arr, int sum) {
		Arrays.sort(arr);

		// check if triplet is formed by arr[i] and a pair from
		// sub-array arr[i+1..arr.length)
		for (int i = 0; i <= arr.length - 3; i++) {
			// remaining sum
			int k = sum - arr[i];

			// maintain two indices pointing to end-points of the
			// sub-array arr[i+1..n)
			int low = i + 1;
			int high = arr.length - 1;

			// loop till low is less than high
			while (low < high) {
				// increment low index if total is less than the remaining sum
				if (arr[low] + arr[high] < k) {
					low++;
				}

				// decrement high index is total is more than the remaining sum
				else if (arr[low] + arr[high] > k) {
					high--;
				}

				// triplet with given sum found
				else {
					// print the triplet
					System.out.println("(" + arr[i] + ", " + arr[low] + ", " + arr[high] + ")");

					// increment low index and decrement high index
					low++;
					high--;
				}
			}
		}
	}

}
