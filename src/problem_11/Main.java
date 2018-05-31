package problem_11;

public class Main {

	public static void main(String[] args) {
		int height[] = {1, 2, 3, 4, 5, 3};
	//	int[] height = {1, 2};
	//	int[] height = {2, 1};
		int res = new Main().maxArea(height);
		System.out.println(res);
	}
	
	//两指针移动
	public int maxArea(int[] height) {
		int res = 0, left = 0, right = height.length - 1;
		while(left < right) {
			//如果左指针<=右指针
			if(height[left] <= height[right]) {
				while(left < right && height[left] <= height[right]) {
					res = Math.max(res, (right - left) * height[left++]);
				}
			}
			//如果左指针>右指针
			else {
				while(left < right && height[left] > height[right]) {
					res = Math.max(res, (right - left) * height[right--]);
				}
			}
		}
		return res;
	}
	
	//暴力
/*	public int maxArea(int[] height) {
		int res = 0;
		for(int i = 0; i < height.length; i++) {
			//计算左边直线
			for(int j = height.length - 1; j > i; j--) {
				if(height[j] >= height[i]) {
					res = Math.max(res, (j - i) * height[i]);
					break;
				}
			}
			//计算右边直线
			for(int j = 0; j < i; j++) {
				if(height[j] >= height[i]) {
					res = Math.max(res, (i - j) * height[i]);
					break;
				}
			}
		}
		return res;
	}*/

}
