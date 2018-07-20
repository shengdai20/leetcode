package problem_83;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);
		ListNode res = new Main().deleteDuplicates(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode res = head, cur = res;
		head = head.next;
		while(head != null) {
			ListNode tmp = head;
			//如果不重复，直接加入新的链表结点
			if(cur.val != head.val) {
				//尾插
				cur.next = head;
				cur = head;
			}
			head = tmp.next;
		}
		//由于是尾插，所以要将最后一个结点末尾置null
		cur.next = null;
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
