package problem_78;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> list = new MainTest().subsets(nums);
		System.out.println(list);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int length = nums.length;//记录数组个数
        int num = (int) Math.pow(2, length);//记录子集个数
        for(int i = 0; i < num; i++) {//初始化结果集，必须的，如果不初始化下面res.get()的时候会出错
            res.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < num; j++) {
                //System.out.println(j + "," + (j>>i));
                if(((j >> i) & 1) == 0) {
                    res.get(j).add(nums[i]);
                }
            }
        }
        return res;
    }
	
/*	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for(int i = 0; i < nums.length; i++) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(List<Integer> r : list) {
				List<Integer> a = new ArrayList<Integer>(r);
				a.add(nums[i]);
	//			System.out.println(a);
				tmp.add(a);
			}
			
			list.addAll(tmp);
//			System.out.println("list:" + list);
		}
		return list;
	}*/
	
/*	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(list, tmp, nums, 0);
		return list;
	}
	public static void dfs(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<Integer>(tmp));
		for(int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}*/
}
