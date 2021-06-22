
public class BestTimeToBuy {

	public static void main(String[] args) {

		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}

	// Best Time to Buy and Sell Stock
	static int maxProfit(int[] prices) {

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else
				max = Math.max(max, prices[i] - min);
		}
		return max;
	}

	// buy one and sell one share of the stock multiple times)
	static int maxProfitII(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

	static int maxProfitIII(int[] prices) {
		if (prices.length == 0)
			return 0;
		int min1 = prices[0], min2 = Integer.MAX_VALUE, max1 = 0,  max2 = 0, cur;
		for (int i = 1; i < prices.length; i++) {
			cur = prices[i];
			min1 = Math.min(min1, cur);
			max1 = Math.max(max1, cur - min1);
			min2 = Math.min(min2, cur - max1);
			max2 = Math.max(max2, cur - min2);
		}
		return max2;
	}
}
