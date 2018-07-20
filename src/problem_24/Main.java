package problem_24;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode res = new Main().swapPairs(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}


	
	public ListNode swapPairs(ListNode head) {
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode cur = res;
		while(cur.next != null && cur.next.next != null) {
			//相邻的第一个节点
			ListNode pre = cur.next;
			//相邻的第二个节点
			ListNode post = cur.next.next;
			//开始交换
			//将第一个节点的next指向第二个节点的next
			pre.next = post.next;
			//加入到结果链表，结果链表的next指向第二个节点，结果链表的next的next指向第一个节点
			cur.next = post;
			cur.next.next = pre;
			//回到遍历
			cur = cur.next.next;
		}
		return res.next;
	}
	
/*	public ListNode swapPairs(ListNode head) {
		ListNode cur = head;
		while(cur != null && cur.next != null) {
			int tmp = cur.val;
			cur.val = cur.next.val;
			cur.next.val = tmp;
			cur = cur.next.next;
		}
		return head;
	}*/
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
