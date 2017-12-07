package problem_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainTest {
	public static void main(String[] args) {
		int[] nums = {3, 3, 0, 3};
		List<List<Integer>> list = new MainTest().permuteUnique(nums);
		System.out.println(list);
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] vis = new int[nums.length];
        Arrays.fill(vis, 0);//初始化全为0
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums);//一定要先排序，这样才能保证下面剪枝的时候，相同的元素相邻
        dfs(list, nums, vis, tmp);
        return list;
    }
    public static void dfs(List<List<Integer>> list , int[] nums, int[] vis, List<Integer> tmp) {
    //    System.out.println(tmp);
        if(tmp.size() == nums.length) {
            list.add(new ArrayList<Integer>(tmp));//这里一定要用new之后再加入到list中，否则list集合会是空值
            return;
        }
        for(int i =0 ; i < nums.length; i++) {
        	//套路剪枝，去除重复元素
        	//选取下一个元素的时候，要查看这个元素的前一个元素是否和它相同，如果相同而且没有使用过，就不用选取这个元素，因为如果选取了这个元素，所得的结果被包含于选取了前一个相同元素的结果中。
        	if(i > 0 && vis[i - 1] == 0 && nums[i - 1] == nums[i]) {
        		continue;
        	}
        	else if(vis[i] == 0){
                vis[i] = 1;
                tmp.add(nums[i]);
                dfs(list, nums, vis, tmp);
                tmp.remove(tmp.size() - 1);//删除最后一个元素
                vis[i] = 0;
            }
        }
    }
}
