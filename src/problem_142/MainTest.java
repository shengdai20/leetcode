package problem_142;

import java.util.HashSet;
import java.util.Set;

public class MainTest {

	public static void main(String[] args) {
		ListNode head = null;
		head = new MainTest().createList(head);
		ListNode res = new MainTest().detectCycle(head);
		System.out.println(res.val);
	}
	
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> list = new HashSet<>();
		while(head != null) {
			if(list.contains(head)) {
				return head;
			}
			else {
				list.add(head);
				head = head.next;
			}
		}
		return null;
		/*		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				fast = head;
				while(fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;*/
	}
	
	public ListNode createList(ListNode head) {
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
