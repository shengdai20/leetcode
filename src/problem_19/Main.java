package problem_19;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = new Main().removeNthFromEnd(head, 5);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int cnt = 0;
		ListNode fast = head, slow = head, preSlow = head;
		while(cnt < n) {
			fast = fast.next;
			cnt++;
		}
		while(fast != null) {
			fast = fast.next;
			preSlow = slow;
			slow = slow.next;
		}
		//删除的是第一个节点
		if(preSlow == slow) {
			head = preSlow.next;
		}
		//删除的不是第一个节点
		preSlow.next = slow.next;
		return head;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
