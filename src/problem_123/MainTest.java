package problem_123;

public class MainTest {

	public static void main(String[] args) {
//		int[] prices = {1, 5, 3, 6};
//		int[] prices = {1, 2};
		int[] prices = {2, 1};
		int res = new MainTest().maxProfit(prices);
		System.out.println(res);
	}
	
	public int maxProfit(int[] prices) {
/*		int res = 0;
		for(int i = 0; i < prices.length; i++) {
			int maxPre = 0;
			int min = Integer.MAX_VALUE;
			//0 to i-1
			for(int j = 0; j < i; j++) {
				if(prices[j] < min) {
					min = prices[j];
				}
				else if(prices[j] - min > maxPre){
					maxPre = prices[j] - min;
				}
			}
			//i to n-1
			int maxPost = 0;
			min = Integer.MAX_VALUE;
			for(int j = i; j < prices.length; j++) {
				if(prices[j] < min) {
					min = prices[j];
				}
				else if(prices[j] - min > maxPost){
					maxPost = prices[j] - min;
				}
			}
			
			if(maxPre + maxPost > res) {
				res = maxPre + maxPost;
			}
		}
		return res;*/
		int length = prices.length;
		int[] preProfit = new int[length];
		int[] postProfit = new int[length];
		//从前往后找，0 to i，用数组记录每一天i之前所能获得的最大利润，计算过程与121题类似
		int minPrice = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < length; i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];
			}
			else if(prices[i] - minPrice > max) {
				max = prices[i] - minPrice;
			}
			preProfit[i] = max;
		}
		//从后往前，i to n-1，用数组记录每一天i之后所能获得的最大利润
		//注意：从后往前找的时候，应该记录当前位置之后的最大价值，然后将当前位置的价值与最大价值进行比较
		int maxPrice = Integer.MIN_VALUE;
		max = 0;
		for(int i = length - 1; i >= 0; i--) {
			if(prices[i] > maxPrice) {
				maxPrice = prices[i];
			}
			else if(maxPrice - prices[i] > max) {
				max = maxPrice - prices[i];
			}
			postProfit[i] = max;
		}
		
		int res = 0;
		for(int i = 0; i < length; i++) {
			if(preProfit[i] + postProfit[i] > res) {
				res = preProfit[i] + postProfit[i];
			}
		}
		return res;
	}
}
