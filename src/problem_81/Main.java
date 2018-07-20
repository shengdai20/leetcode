package problem_81;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 5, 6, 0, 0, 1, 2};
		int target = 2;
		boolean res = new Main().search(nums, target);
		System.out.println(res);
	}

	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target || nums[left] == target || nums[right] == target) {
				return true;
			}
			//如果左数组有序
			else if(nums[left] < nums[mid]) {
				//如果target在左数组中
				if(target < nums[mid] && target > nums[left]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			//如果右数组有序
			else if(nums[mid] < nums[right]){
				//如果target在右数组中
				if(target < nums[right] && target > nums[mid]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			//如果出现1,3,1,1,1的情况，mid值与left和right都相等，则将right--再比较
			else {
				right--;
			}
		}
		return false;
	}
}
