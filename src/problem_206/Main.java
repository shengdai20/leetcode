package problem_206;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;
		ListNode res = new Main().reverseList(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		//头节点没有记录，因为头节点会成为尾结点
		ListNode nextHead = head.next;
		//res保证每次return的都是头结点
		ListNode res = reverseList(head.next);
		//return之后，开始组装结点，其实这里是尾插的思想
		//依次会是5->4,4->3,3->2,2->1
		nextHead.next = head;
		//下面的这个操作不知是为啥。。。
		head.next = null;
		return res;
	}
	
/*	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode res = head;
		head = head.next;
		res.next = null;
		while(head != null) {
			ListNode tmp = head;
			//head=head.next一定要放在tmp.next=res的前面
			//因为如果放在后面，tmp.next=res就会改变head.next的值，这样head就不能正常指向原值，会造成死循环
			head = head.next;
			//下面是头插法
			tmp.next = res;
			res = tmp;
		}
		return res;
	}*/
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
