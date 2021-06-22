package intv.search_sort;

public class Test {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
		int end = arr.length - 1;
		int key = 10;
		System.out.println(bst(arr, 0, end, key));
	}

	static int bst(int arr[], int start, int end, int key) {

		if(end < start)
			return -1;
		
		int mid = (start + end) / 2;
		if (arr[mid] == key)
			return mid;
		if (arr[mid] < key)
			return bst(arr, mid + 1, end, key);
		else if (arr[mid] > key)
			return bst(arr, start, mid - 1, key);

		return -1;
	}

}
