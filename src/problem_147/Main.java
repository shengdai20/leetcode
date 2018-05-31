package problem_147;

public class Main {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		head.next = new ListNode(99);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = null;
		ListNode res = new Main().insertionSortList(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	public ListNode insertionSortList(ListNode head) {
		ListNode first = new ListNode(0);
		ListNode pre = first, cur = head, post = null;
		while(cur != null) {
			//保存cur.next，因为要遍历当前结点，下一次就要遍历当前结点的下一个结点，所以在这次遍历完之后需要重新赋值cur=post
			post = cur.next;
			//寻找可以插入的结点位置
			while(pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			//找到之后，将cur结点插入在pre和pre.next之间
			cur.next = pre.next;
			pre.next = cur;
			//下一次pre再从头开始找可插入的结点位置，所以要置为开始头节点
			pre = first;
			//下一次对cur.next结点进行排序，所以要将cur置回
			cur = post;
		}
		return first.next;
	}

}
