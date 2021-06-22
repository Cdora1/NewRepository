package intv.str_arr;

public class MaximumProductSubArray {

	public static void main(String[] args) {

		int arr[] = { 2, 3, -2, 4 };
		System.out.println(maximumProductSubArray(arr));
		System.out.println();
		System.out.println(maxSubarrayProduct(arr));
		
	System.out.println(bruteForcePROD(arr));
	}
	
	static int bruteForcePROD(int arr[]) {
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			int prod = 1;
			for(int j =i; j<arr.length; j++) {
				prod = prod * arr[j];
				max = Math.max(max, prod);
			}
		}
		return max;
				
	}

	static int maxPROD(int arr[]) {
		int max = arr[0], min = arr[0], sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				min = 1;
				max = Math.max(max, sum);
				sum = 1;
			}else if(arr[i] < 0) {
				min = Math.min(min, arr[i]*min);
				sum = 1;
			} else {
				sum = sum * arr[i];
				min = Math.min(min, arr[i] * min);
				max = Math.max(max, sum);
			}
		}
		return Math.max(min, max);
	}

	static int maxSubarrayProduct(int a[]) {
		if (a == null || a.length == 0)
			return 0;

		int ans = a[0], min = ans, max = ans;

		for (int i = 1; i < a.length; i++) {
			if (a[i] >= 0) {
				max = Math.max(a[i], max * a[i]);
				min = Math.min(a[i], min * a[i]);
			} else {
				int tmp = max;
				max = Math.max(a[i], min * a[i]);
				min = Math.min(a[i], tmp * a[i]);
			}
			ans = Math.max(ans, max);
		}

		return ans;
	}

	static int maximumProductSubArray(int arr[]) {

		int n = arr.length;
		if (n == 0)
			return -1;

		int minProduct = arr[0];
		int maxProduct = arr[0];
		int ans = arr[0];
		int choice1, choice2;

		for (int i = 1; i < n; i++) {
			choice1 = arr[i] * minProduct;
			choice2 = arr[i] * maxProduct;
			minProduct = Math.min(arr[i], Math.min(choice1, choice2));
			maxProduct = Math.max(arr[i], Math.max(choice1, choice2));
			ans = Math.max(ans, maxProduct);
		}

		return ans;
	}

}
