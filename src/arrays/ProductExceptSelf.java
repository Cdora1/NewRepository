package arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {

		int nums[] = {1,2,3,4};
		for(int in : productExceptSelf(nums))
			System.out.print(in + " ");
	}

	static int[] productExceptSelf(int[] nums) {
		int[] p = new int[nums.length];

		int product = 1;
		for (int i = 0; i < p.length; ++i) {
			p[i] = product;
			product *= nums[i];
		}

		product = 1;
		for (int i = p.length - 1; i >= 0; --i) {
			p[i] *= product;
			product *= nums[i];
		}
		return p;
	}
}
