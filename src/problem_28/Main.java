package problem_28;

public class Main {

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		int res = new Main().strStr(haystack, needle);
		System.out.println(res);
	}
	
	//kmp
	public int strStr(String haystack, String needle) {
		int next[] = computeNext(needle);
		int i = 0, j = 0, len_h = haystack.length(), len_n = needle.length();
		for( ; i < len_h && j < len_n; i++) {
			while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = next[j - 1];
			}
			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}
		}
		return (j == needle.length()) ? (i - j) : -1;
	}
	private int[] computeNext(String needle) {
		int[] next = new int[needle.length()];
		for(int i = 1, j = 0; i < needle.length(); i++) {
			while(j > 0 && needle.charAt(i) != needle.charAt(j)) {
				j = next[j - 1];
			}
			if(needle.charAt(i) == needle.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	
	//暴力
/*	public int strStr(String haystack, String needle) {
		int res = -1, len_h = haystack.length(), len_n = needle.length();
		if(len_n == 0) {
			return 0;
		}
		//此处优化点：i <= len_h - len_n，当主字符串中字符个数已经过小时，则不需要再遍历了
		for(int i = 0; i <= len_h - len_n; i++) {
			//可能有当前字符串
			if(len_n != 0 && haystack.charAt(i) == needle.charAt(0)) {
				int k = i + 1, j = 1;
				boolean flag = true;
				for( ; j < len_n && k < len_h; j++) {
					if(haystack.charAt(k++) != needle.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag == true && j == len_n) {
					res = i;
					break;
				}
			}
		}
		return res;
	}*/

}
