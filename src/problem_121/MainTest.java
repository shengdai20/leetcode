package problem_121;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

	public static void main(String[] args) {
	//	int[] prices = {7, 1, 5, 3, 6, 4};
	//	int[] prices = {7, 6, 4, 3, 1};
	//	int[] prices = {7, 4, 1, 2};
		int[] prices = {1, 4, 1, 4, 3, 1};
		int res = maxProfit(prices);
		System.out.println("res:" + res);
	}
	
	public static int maxProfit(int[] prices) {
/*		int max = 0;
		int length = prices.length;
		for(int i = length - 1; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(max < (prices[i] - prices[j])) {
					max = prices[i] - prices[j];
				}
			}
		}
		return max;*/
		int min = Integer.MAX_VALUE;
		int res = 0;
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}
			else if(prices[i] - min > res){
				res = prices[i] - min;
			}
		}
		return res;
	}
}
