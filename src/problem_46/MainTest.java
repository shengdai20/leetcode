package problem_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = new MainTest().permute(nums);
		System.out.println(list);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		do {
			ArrayList<Integer> listIn = new ArrayList<Integer>();
			for(int i = 0; i < nums.length; i++) {
				listIn.add(nums[i]);
			}
			//每求出一个全排列就加入res结果集中
			//由下面的尝试得知，必须要new一个新的，原因不是新开辟了一个地址空间，而是为了让原地址空间不被垃圾回收器回收，而导致原数据无法读取的情况
			//listIn和a的地址空间相同
/*			System.out.println(listIn.hashCode());
			List<Integer> a = new ArrayList<Integer>(listIn);
			System.out.println(a.hashCode());
			res.add(a);*/
			res.add(new ArrayList<Integer>(listIn));
		} while(nextPermutation(nums) == true);
		return res;
	}
	public static boolean nextPermutation(int[] nums) {
		int length = nums.length;
		int pre = 0, post = 0;//pre标记前面的第一个小数，即nums[pre]<nums[pre+1]，post标记后面的第一个大数，即nums[post]>nums[pre]
		boolean mark = false;//标记是否是降序序列
		//从后往前找，找到第一个前面的数小于后面的数的下标
		for(int i = length - 1; i > 0; i--) {
			if(nums[i - 1] < nums[i]) {
				mark = true;
				pre = i - 1;
				break;
			}
		}
		//从后往前找，找到第一个比前面标记的数大的数的下标
		for(int i = length - 1; i > 0; i--) {
			if(nums[i] > nums[pre]) {
				post = i;
				break;
			}
		}
		int mid = (length - pre - 1) / 2;
		//如果直接是降序，直接反转即可
		if(mark == false) {
			return false;
		}
		int tmp = nums[pre];
		nums[pre] = nums[post];
		nums[post] = tmp;
		//反转后面的降序序列为升序序列
		for(int i = pre + 1; i <= (pre + mid); i++) {
			int t = nums[i];
			nums[i] = nums[--length];
			nums[length] = t;
		}
		return true;
	}
	
/*	public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();//这里利用LinkedList，而不用ArrayList，因为这样可以利用LinkedList.add(i,n)在第i位加入数值
		res.add(new ArrayList<Integer>());//加一个空的list进去，以保证下面size在第一次的时候就为1，从而保证后面的计算
		for(int n : nums) {//遍历nums数组值
			for(int size = res.size(); size > 0; size--) {//查看结果集res中已经包含几个序列
				List<Integer> tmp = res.pollFirst();//取出结果集res中的每个序列
				for(int i = 0; i <= tmp.size(); i++) {//对于取出的序列，在每一个位置都尝试加入当前nums数组值，这里的i表示当前取出序列的第i位，比如取出的序列是1，接下来就要在1之前及1之后加入2
					List<Integer> resIn = new ArrayList<Integer>(tmp);//每一个位置都新初始化刚取出的序列，这样保证能在原始取出序列的基础上增添数值
					resIn.add(i, n);//在第i位加入数值n
					res.add(resIn);//这里因为每从结果集中取出一个序列就是清空一个序列，所以这里add的时候就是一个全新的序列
				}
			}
		}
		return res;
	}*/
	
/*	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(list, nums, tmp);
		return list;
	}
	public static void dfs(List<List<Integer>> list , int[] nums, List<Integer> tmp) {
		System.out.println(tmp);
		if(tmp.size() == nums.length) {
			if(!list.contains(tmp))
				list.add(new ArrayList<Integer>(tmp));//这里一定要用new之后再加入到list中，否则list集合会是空值
			return;
		}
		for(int i =0 ; i < nums.length; i++) {
			if(!tmp.contains(nums[i])) {
				tmp.add(nums[i]);
				dfs(list, nums, tmp);
				tmp.remove(tmp.size() - 1);//删除最后一个元素
			}
		}
	}*/
}
