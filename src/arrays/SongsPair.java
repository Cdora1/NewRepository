package arrays;

public class SongsPair {

	public static void main(String[] args) {

		int time[] = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(time));
	}

	static int numPairsDivisibleBy60(int[] time) {
		int c[] = new int[60], res = 0;
		for (int t : time) {
			res += c[(600 - t) % 60];
			c[t % 60] += 1;
		}
		return res;
	}
}
