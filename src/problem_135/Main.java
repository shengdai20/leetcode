package problem_135;

public class Main {

	public static void main(String[] args) {
	//	int[] ratings = {3, 4, 5, 2, 1};
	//	int[] ratings = {1, 2, 2};
	//	int[] ratings = {1, 0, 2};
		int[] ratings = {5, 3, 1};
	//	int[] ratings = {2, 2};
		int res = new Main().candy(ratings);
		System.out.println(res);
	}
	
	public int candy(int[] ratings) {
		int first = 1, cnt = 0, res = 1, len = ratings.length;
		for(int i = 1; i < len; i++) {
			//如果比前一个小朋友rating高，则计算总糖果值
			if(ratings[i] >= ratings[i - 1]) {
				//如果当前小朋友前面有递减rating，先处理这几个小朋友的糖果值
				if(cnt > 0) {
					//从递减的第二个数开始，到最后一个递减rating结束为止，这几个小朋友的糖果总值就是cnt * (cnt + 1) / 2
					res += cnt * (cnt + 1) / 2;
					//处理开始递减的第一个数，即将其需要增加的糖果数cnt-res+1，加入res中
					if(cnt >= first) {
						res += cnt - first + 1;
					}
					//重置
					cnt = 0;
					first = 1;
				}
				//对于当前第i个小朋友，正常计算其糖果值，将其加入res结果中
				first = (ratings[i] == ratings[i - 1]) ? 1 : first + 1;
				res += first;
			}
			//计数递减rating的个数
			else {
				cnt++;
			}
		}
		//处理最后一组递减rating，而其后没有再反弹的小伙伴，即一直递减，不满足ratings[i] >= ratings[i - 1]就到数组终结
		if(cnt > 0) {
			res += cnt * (cnt + 1) / 2;
			if(cnt >= first) {
				res += cnt - first + 1;
			}
		}
		return res;
	}
	
/*	public int candy(int[] ratings) {
		int len = ratings.length;
		if(len == 0) {
			return 0;
		}
		else if(len == 1) {
			return 1;
		}
		int[] left_candy = new int[len];
		int[] right_candy = new int[len];
		//初始化
		left_candy[0] = ratings[0] <= ratings[1] ? 1 : 2;
		right_candy[len - 1] = ratings[len - 1] <= ratings[len - 2] ? 1 : 2;
		//从前往后遍历
		for(int i = 1; i < len; i++) {
			if(ratings[i] > ratings[i - 1]) {
				left_candy[i] = left_candy[i - 1] + 1;
			}
			else {
				left_candy[i] = 1;
			}
		}
		//从后往前遍历
		for(int j = len - 2; j >= 0; j--) {
			if(ratings[j] > ratings[j + 1]) {
				right_candy[j] = right_candy[j + 1] + 1;
			}
			else {
				right_candy[j] = 1;
			}
		}
		//两者中取较大者，计算糖果值
		int cnt = 0;
		for(int i = 0; i < len; i++) {
			cnt += Math.max(left_candy[i], right_candy[i]);
		}
		return cnt;
	}*/
	
/*	public int candy(int[] ratings) {
		int len = ratings.length;
		if(len == 0) {
			return 0;
		}
		else if(len == 1) {
			return 1;
		}
		int[] dp = new int[len];
		//初始化第一个小伙伴的糖果值
		dp[0] = ratings[0] <= ratings[1] ? 1 : 2;
		int cnt = 0;
		for(int i = 1; i < len; i++) {
			//只与前面小伙伴的ratings进行比较
			if(ratings[i] > ratings[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
			else {
				dp[i] = 1;
				//如果前面小伙伴的糖果是1，且ratings比较高，则遍历其前面的所有小伙伴
				if(dp[i - 1] == 1 && ratings[i - 1] > ratings[i]) {
					//更新前面的小伙伴的糖果值，因为这个更新，对于这种用例5，3，1，这个小伙伴前面的所有糖果值都要更新，所以进入下面的for循环进行判断
					dp[i - 1] = 2;
					for(int j = i - 2; j >= 0; j--) {
						//如果前面的小伙伴的糖果值小，且ratings又比较高，则更新其值
						if(ratings[j] > ratings[j + 1] && dp[j] <= dp[j + 1]) {
							dp[j] = dp[j + 1] + 1;
						}
						else {
							break;
						}
					}
				}
			}
		}
		//计算所有的糖果值
		for(int i = 0; i < len; i++) {
			cnt += dp[i];
		}
		return cnt;
	}*/

}
