package problem_92;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;
		ListNode res = new Main().reverseBetween(head, 2, 5);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre = null, res = head;
		//找到前面的最末位节点
		for(int i = 1; i < m; i++) {
			if(pre == null) {
				pre = head;
				res = pre;
			}
			else {
				pre.next = head;
				pre = head;
			}
			head = head.next;
		}
		//处理中间节点
		ListNode mi = null, miPost = mi;
		for(int i = m; i <= n; i++) {
			if(mi == null) {
				mi = head;
				miPost = mi;
				head = head.next;
			}
			else {
				ListNode tmp = head;
				head = head.next;
				tmp.next = mi;
				mi = tmp;
			}
		}
		if(pre != null) {
			//前面连接中间
			pre.next = mi;
			//中间连接后面
			miPost.next = head;
		}
		else {
			res = mi;
			miPost.next = head;
		}
		return res;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
