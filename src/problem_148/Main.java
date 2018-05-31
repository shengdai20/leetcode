package problem_148;

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
		ListNode res = new Main().sortList(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	//归并
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		//划分成两个链表，由快慢指针得到。
		//最终slow会指向第二个链表的起始位置，fast会指向第二个链表的末尾，pre会指向第一个链表的末尾
		ListNode pre = null, slow = head, fast = head;
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//第一个链表的终结
		pre.next = null;
		//分别对两个链表进行排序
		//head是第一个链表的头，slow是第二个链表的头
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		//归并l1和l2
		return merge(l1, l2);
	}
	private static ListNode merge(ListNode l1, ListNode l2) {
		//l头节点初始化为0，返回的时候返回l.next即可，即不带头结点的指针
		ListNode l = new ListNode(0), p = l;
		while(l1 != null && l2 != null) {
			//尾插
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			}
			else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		//如果还有结点，则直接放在其后即可
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		return l.next;
	}
	
	//从小到大
	//冒泡
/*	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode cur = null, tail = null;
		cur = head;
		while(cur.next != tail) {
			while(cur.next != tail) {
				//其实这里交换的是两个相邻结点的值，并没有交换两个结点指针
				if(cur.val > cur.next.val) {
					int tmp = cur.val;
					cur.val = cur.next.val;
					cur.next.val = tmp;
				}
				cur = cur.next;
			}
			//每一趟排序都会把一个相对最大的数排到最后一个，所以这里要将tail置为cur，而不是一直是null
			tail = cur;//下一次遍历的尾结点是当前结点
			//每一趟都再次从头开始遍历
			cur = head;//遍历起始结点重置为头结点
		}
		return head;
	}*/

}
