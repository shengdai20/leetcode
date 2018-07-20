package problem_23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(5);
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		ListNode head3 = new ListNode(2);
		head3.next = new ListNode(6);
//		ListNode[] lists = {head1, head2, head3};
		ListNode[] lists = {};
		ListNode res = new Main().mergeKLists(lists);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		int n = lists.length;
		while(n > 1) {
			//每次都取一半进行归并
			int mid = (n + 1) / 2;
			//如果是6个链表，则归并1，4和2，5和3，6，如此归并最后得到的结果链表一定在1中
			for(int i = 0; i < n / 2; i++) {
				lists[i] = mergeLists(lists[i], lists[mid + i]);
			}
			n = mid;
		}
		//返回最后的结果链表
		return lists[0];
	}
	//合并两个链表
	public static ListNode mergeLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}
			else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}
		return head.next;
	}
	
/*	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		//定义最小堆
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(11, new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
		//初始化最小堆，将k个链表的首节点放入堆中
		for(int i = 0; i < lists.length; i++) {
			if(lists[i] != null) {
				q.offer(lists[i]);
			}
		}
		ListNode head = new ListNode(0), cur = head;
		while(!q.isEmpty()) {
			//取出堆顶元素尾插，即将堆中最小值插入结果链表中
			cur.next = q.poll();
			cur = cur.next;
			//将堆顶元素的下一个元素加入堆中，即原链表中的下一个元素
			if(cur.next != null) {
				q.offer(cur.next);
			}
		}
		return head.next;
	}*/
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
