package problem_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {
		String s = "pww";
		int ans = new MainTest().lengthOfLongestSubstring(s);
		System.out.println(ans);
	}
	
	public int lengthOfLongestSubstring(String s) {
		int ans = 0, length = s.length();
		int[] flag = new int[256];
		for(int left = 0, right = 0; right < length; right++) {
			//这里不能用flag[s.charAt(right)+1,因为java默认初始化是0，这里如果+1，就会导致起始位置+1状态
			//如果前面初始化为-1了，这里就可以+1，下面也可以改成flag[s.charAt(right)] = right
			left = Math.max(left, flag[s.charAt(right)]);
			ans = Math.max(ans, right - left + 1);
			flag[s.charAt(right)] = right + 1;
		}
		return ans;
	}
	
/*	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;
		int length = s.length();
		for(int left = 0, right = 0; right < length; right++) {
			if(map.containsKey(s.charAt(right)) == true) {
				//如果所存字符串中有当前字符，更新子串起始位置
				//很容易犯错成left = map.get(s.charAt(right))+1，这里不能直接将最新值当成子串起始位置
				//因为有可能这个最新值已经是过期值，即有可能是比当前left小的下标，而其后已经有重复字符不能取，比如pwkkfw字符串
				//这里也不能犯错成left = Math.max(left, map.get(s.charAt(right)))
				//因为要取到重复字符下标+1的位置，当然这里如果下面是map.put(s.charAt(right), right + 1)则就可以写成left = Math.max(left, map.get(s.charAt(right)))
				left = Math.max(left, map.get(s.charAt(right))+1);
			}
			ans = Math.max(ans, right - left + 1);
			map.put(s.charAt(right), right);
		}
		return ans;
	}*/
	
/*	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int left = 0, right = 0, ans = 0;//left记录子串开始下标，right记录子串结束下标
		HashSet<Character> set = new HashSet<Character>();//set判断重复字符
		while(right < length) {
			if(set.contains(s.charAt(right)) == false) {
				//前面的字符串中不包含当前字符
				//将当前字符加入子串中，长度+1
				set.add(s.charAt(right++));
				ans = Math.max(ans, set.size());
			}
			else {
				//前面的字符串中包含当前字符
				//将重复字符前面的包括它自己都删去，也就是从重复字符+1开始重新计算子串
				set.remove(s.charAt(left++));
			}
		}
		return ans;
	}*/
	
/*	public int lengthOfLongestSubstring(String s) {
		int length = 1;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			length = 1;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			map.put(s.charAt(i), i);
			for(int j = i + 1; j < s.length(); j++) {
				if(map.containsKey(s.charAt(j)) == false) {
					//如果前面的字符串中没有当前字符，则将当前字符加入字符串中
					length++;
					map.put(s.charAt(j), j);
				}
				else {
					//如果有，则直接退出从当前字符串起始位置的下一个位置开始重新计算字符串
					//这里就有优化的地方了
					break;
				}
			}
			if(length > max) {
				max = length;
			}
		}
		return max;
	}*/
}
