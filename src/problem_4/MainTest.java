package problem_4;

public class MainTest {

	public static void main(String[] args) {
	//	int[] nums1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
	//	int[] nums2 = {0,6};
		int[] nums1 = {1};
		int[] nums2 = {2, 3};
		double ans = new MainTest().findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}
	
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length, length2 = nums2.length;
		int[] res = new int[length1 + length2];
		int index = 0, index1 = 0, index2 = 0;
		for( ; index1 < length1 && index2 < length2; ) {
			if(nums1[index1] < nums2[index2]) {
				res[index++] = nums1[index1++];
			}
			else if(nums1[index1] > nums2[index2]) {
				res[index++] = nums2[index2++];
			}
			else {
				res[index++] = nums1[index1++];
				res[index++] = nums2[index2++];
			}
		}
		while(index1 < length1) {
			res[index++] = nums1[index1++];
		}
		while(index2 < length2) {
			res[index++] = nums2[index2++];
		}
		double ans = 0;System.out.println(index);
		if(index % 2 == 0) {
			ans = (double) (res[index / 2] + res[index / 2 - 1]) / 2;
		}
		else {
			ans = res[index/2];
		}
		return ans;
	}
}
