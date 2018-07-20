package problem_33;

public class Main {

	public static void main(String[] args) {
	//	int[] nums = {4, 5, 6, 7, 0, 1, 2};
	//	int[] nums = {1};
		int[] nums = {3, 1};
		int target = 1;
		int res = new Main().search(nums, target);
		System.out.println(res);
	}

	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			//如果左半段有序
			else if(nums[left] <= nums[mid]) {
				//如果target在左半段范围内
				if(nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				}
				//虽然左半段有序，如果target不在左半段范围内，则向右遍历右半段
				else {
					left = mid + 1;
				}
			}
			//如果右半段有序
			else {
				//如果target在右半段范围内
				if(nums[right] >= target && nums[mid] < target) {
					left = mid + 1;
				}
				//虽然右半段有序，如果target不在右半段范围内，则向左遍历左半段
				else {
					right = mid - 1;
				}
			} 
		}
		return -1;
	}
}
