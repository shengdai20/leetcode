package problem_25;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode res = new Main().reverseKGroup(head, 2);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		int cnt = 0;
		while(cur != null && cur.next != null) {
			
		}
		return null;
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}