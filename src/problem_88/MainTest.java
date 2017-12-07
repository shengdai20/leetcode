package problem_88;

import java.util.Arrays;

public class MainTest {
	public static void main(String[] args) {
		int[] nums1 = new int[10];
		int[] nums2 = new int[5];
		nums1[0] = 4;
//		nums1[1] = 5;
//		nums1[2] = 6;
//		nums1[3] = 7;
//		nums1[4] = 8;
		nums2[0] = 1;
//		nums2[1] = 3;
//		nums2[2] = 4;
//		nums2[3] = 6;
//		nums2[4] = 9;
		merge(nums1, 0, nums2, 1);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
//		int i = 0;
//		int j = 0;
//		int[] nums = new int[m + n];
//		int k = 0;
//		for( ; i < m && j < n; ) {
//			if(nums1[i] < nums2[j]) {
//				nums[k++] = nums1[i++];
//			}
//			else if(nums1[i] > nums2[j]) {
//				nums[k++] = nums2[j++];
//			}
//			else {
//				nums[k++] = nums1[i];
//				nums[k++] = nums1[i];
//				i++;
//				j++;
//			}
//		}
//		while(i < m) {
//			nums[k++] = nums1[i++];
//		}
//		while(j < n) {
//			nums[k++] = nums2[j++];
//		}
//		for(int t = 0; t < m + n; t++) {
//			nums1[t] = nums[t];
//		}
		for(int i = m, j = 0; j < n; i++, j++) {
			nums1[i] = nums2[j];
		}
		Arrays.sort(nums1);
		System.out.println("length:" + nums1.length);
		for(int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
	}
}
