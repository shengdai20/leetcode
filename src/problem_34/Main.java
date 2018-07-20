package problem_34;

public class Main {

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = new Main().searchRange(nums, target);
		System.out.println(res[0] + "," + res[1]);
	}

	public int[] searchRange(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int[] res = {-1, -1};
		if(nums.length == 0) {
			return res;
		}
		//二分找到起始下标
		while(left < right) {
			int mid = (left + right) / 2;
			//这里比较左值，如果<，则left更新，否则left不会更新
			//所以left不更新有两种情况：>或=
			if(nums[mid] < target) {
				left = mid + 1;
			}
			//这里统统修改右值
			else {
				right = mid;
			}
		}
		if(nums[left] != target) {
			return res;
		}
		res[0] = left;
		left = 0;
		right = nums.length - 1;
		//二分找到结束下标
		while(left < right) {
			//这里要+1，否则会出错
			int mid = (left + right) / 2 + 1;
			//比较右值，如果>，则right更新
			if(nums[mid] > target) {
				right = mid - 1;
			}
			//修改Left
			else {
				left = mid;
			}
		}
		res[1] = right;
		return res;
	}
}
