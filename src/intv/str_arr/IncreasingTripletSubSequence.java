package intv.str_arr;

public class IncreasingTripletSubSequence {

	public static void main(String[] args) {

		int nums[] = {20,100,10,12,5,13};
		System.out.println(increasingTriplet(nums));
	}
	
	static boolean increasingTriplet(int[] nums) {
	    int small = Integer.MAX_VALUE;
	    int big = Integer.MAX_VALUE;

	    for (int num: nums) {
	        if (num <= small) {
	            small = num; 
	        } else if (num <= big) {
	            big = num; 
	        } else {
	            return true;
	        }
	    }
	    return false;
	}
}
