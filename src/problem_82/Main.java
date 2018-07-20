package problem_82;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		ListNode res = new Main().deleteDuplicates(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		//pre记录前面最后一个重复的结点，cur进行遍历
		ListNode res = null, cur = res, pre = null;
		while(head != null) {
			//如果前后节点重复则跳过，即删除
			if(head.next != null && head.val == head.next.val) {
				pre = head;
				head = head.next.next;
			}
			//如果当前节点与上一个节点重复，则删除
			else if(pre != null && head.val == pre.val) {
				head = head.next;
			}
			//如果不重复，则将结点保留
			else {
				//尾插
				if(cur == null) {
					cur = head;
					res = cur;
				}
				else {
					cur.next = head;
					cur = head;
				}
				head = head.next;
			}
		}
		if(cur == null) {
			return null;
		}
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