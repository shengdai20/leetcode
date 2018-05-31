package problem_134;

public class Main {

	public static void main(String[] args) {
		int[] gas = {5};
		int[] cost = {4};
		int res = new Main().canComplete(gas, cost);
		System.out.println(res);
	}

	public int canComplete(int[] gas, int[] cost) {
		int gas_cnt = 0, cost_cnt = 0;
		int index = 0, cnt = 0;
		for(int i = 0; i < gas.length; i++) {
			//统计所有汽油数量
			gas_cnt += gas[i];
			//统计汽车行驶花费的所有汽油数量
			cost_cnt += cost[i];
			//统计到目前为止，汽油数量能否支撑汽车行驶
			cnt += gas[i] - cost[i];
			//如果一旦行驶不了，则从当前位置的下一个位置作为起始点
			//原因：由于到现在都行驶不了，如果选择这个位置之前的任何一个位置作为起始点，汽油数量只会更少
			//由于如果汽油数量>=花费数量，则一定存在解，所以所找到的解一定符合要求。
			if(cnt < 0) {
				cnt = 0;
				index = i + 1;
			}
		}
		//如果汽油数量<花费数量，则一定不存在解。
		if(gas_cnt < cost_cnt) {
			return -1;
		}
		return index;
	}
	
/*	public int canComplete(int[] gas, int[] cost) {
		int len = gas.length;
		int cnt = 0;
		int flag = 0;
		//逐一遍历每一种可能
		for(int i = 0; i < len; i++) {
			flag = 0;
			//对于每一个可能起始点，都计算一下circle能否完成汽车行驶任务
			for(int j = i; j < len; j++) {
				cnt += gas[j] - cost[j];
				if(cnt < 0 ) {
					cnt = 0;
					flag = -1;
					break;
				}
			}
			if(flag == -1) {
				continue;
			}
			for(int j = 0; j < i; j++) {
				cnt += gas[j] - cost[j];
				if(cnt < 0) {
					cnt = 0;
					flag = -1;
					break;
				}
			}
			if(flag == 0) {
				return i;
			}
		}
		return -1;
	}*/
}
