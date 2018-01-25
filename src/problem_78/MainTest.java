package problem_78;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = new MainTest().subsets(nums);
		System.out.println(list);
	}
	
/*	public List<List<Integer>> subsets(int[] nums) {
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
    }*/
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());//加入空集
		for(int num : nums) {//遍历nums数组
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();//临时结果集
			for(List<Integer> r : res) {//遍历结果集
				//新建一个对象a指向r地址空间，在执行完a.add()之后，a的地址空间发生变化，得到一个新的地址空间，而res结果集中的原地址空间中的数据仍保持不变，保证了一致性，不会篡改数据
		//		System.out.println("r:" + r.hashCode());
				List<Integer> a = new ArrayList<Integer>(r);
		//		System.out.println("a:" + a.hashCode());
				a.add(num);
		//		System.out.println(":" + a.hashCode());
 				tmp.add(a);//将新得到的结果放入临时结果集
 				
 				//虽然你看上去上面的代码新建了一个变量，使得代码更加繁琐，但是其实是有必要而且必须的
 				//下面的这段代码不可行，因为r所拿到的其实是res结果集里面的某一个list的地址，而且并没有新开辟空间，也就没有更换地址
 				//这样在执行r.add()函数的时候，加入的num值就是在原地址空间的基础上加的，但是在执行完add()函数之后，r的地址会变成一个新的地址，至于为什么，看了源码也无从得知
				//而由于在r.add()之后r的地址已经变了，下面new一个新对象，指向变后的地址空间，让其存留，但是此时其实res结果集中的数据也已经变了，因为r是在原地址上做的操作
				//当再次执行下面的res.addAll()的操作时，会得到很多个地址空间相同的对象，因为其实一直都指向一个地址空间，也就是r的地址空间
			//	r.add(num);
				//new的作用仅仅是将原始数据存留，而不是新开辟一个地址空间，也就是新建一个对象指向r地址空间
			//	tmp.add(new ArrayList<Integer>(r));
			}
			//addAll()是在res原结果集的基础上将tmp整个的加入res结果集中，而不是用tmp将res覆盖
			res.addAll(tmp);//将临时结果集赋给res结果集

		}
		return res;
	}
	
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
