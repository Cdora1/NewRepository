package intv.str_arr;

//https://www.youtube.com/watch?v=3X9-qs1Lwe4
public class ProductExceptSelf {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		for(int in : productExceptSelf(nums))
			System.out.print(in + " ");

	}
	
	static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int N = ans.length;
        int left = 1;
        
        for (int i = 0; i < N; i++) {
            ans[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        for (int i = N - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        return ans;
    }

}
