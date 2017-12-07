package problem_35;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 3;
		nums[2] = 5;
		nums[3] = 7;
		int target = 9;
		int index = searchInsert(nums, target);
		System.out.println("index:" + index);
	}

	public static int searchInsert(int[] nums, int target) {
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i] == target) {
//				return i;
//			}
//			else if(target < nums[i]) {
//				return i;
//			}
//		}
//		return nums.length;
		int length = nums.length;
		if(length == 1) {//处理特殊情况，也就是数组中只有一个数字的情况
			if(target <= nums[0]) {
				return 0;
			}
			else {
				return 1;
			}
		}
		int low = 0;
		int high = length - 1;
		int mid = (low + high) / 2;
		while(low < high) {//二分查找
			if(nums[mid] == target) {
				return mid;
			}
			else if(target < nums[mid]) {
				if(mid > 0 && target > nums[mid - 1]) {
					return mid;
				}
				else if(mid > 0 && target == nums[mid - 1]) {
					return mid - 1;
				}
				else {
					high= mid - 1;
				}
			}
			else if(target > nums[mid]) {
				if(target < nums[mid + 1]) {
					return mid + 1;
				}
				else if(target == nums[mid + 1]) {
					return mid + 1;
				}
				else {
					low = mid + 1;
				}
			}
			mid = (low + high) / 2;
		}
		if(low == 0) {//处理特殊情况，当要插入在第一个位置时
			return low;
		}
		return nums.length;//当要插入在最后一个位置时
	}
}
