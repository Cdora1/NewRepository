
public class BSTUsingRec {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 5, 6, 7, 9, 10 };
		int key = 9;
		int start = 0;
		int end = arr.length - 1;
		System.out.println(recursiveBinarySearch(arr, start, end, key));
		/*while (start <= end) {

			int mid = (start + end) / 2;
			if (key == arr[mid])
				System.out.println(" index " + mid);

			if (key <= arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}*/
	}

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);

			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);

			} else {
				return mid;
			}
		}
		return -(start + 1);
	}
}
