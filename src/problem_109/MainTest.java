package problem_109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		ListNode node = null;
		node = new MainTest().createList(node);
		TreeNode root = new MainTest().sortedListToBST(node);
		new MainTest().print(root);
	}

	public TreeNode sortedListToBST(ListNode head) {
		List<ListNode> list = new ArrayList<ListNode>();
		while(head != null) {
			list.add(head);
			head = head.next;
		}
		return dfs(list, 0, list.size() - 1);
	}
	public static TreeNode dfs(List<ListNode> list, int left, int right) {
		if(left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(list.get(mid).val);
		root.left = dfs(list, left, mid - 1);
		root.right = dfs(list, mid + 1, right);
		return root;
	}
	
	//法二：利用快慢指针做到二分
/*	public TreeNode sortedListToBST(ListNode head) {
		return dfs(head, null);
	}
	public static TreeNode dfs(ListNode head, ListNode tail) {
		if(head == tail) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = dfs(head, slow);
		root.right = dfs(slow.next, tail);
		return root;
	}*/
	
	//法一：利用length计数链表长度
/*	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		ListNode p = head;
		while(head != null) {
			head = head.next;
			length++;
		}
		return dfs(p, length);
	}
	public static TreeNode dfs(ListNode head, int length) {
		if(head == null || length == 0) {
			return null;
		}
		ListNode p = head;
		int leftLength = 1;
		while(leftLength <= length / 2) {
			head = head.next;
			leftLength++;
		}
		TreeNode root = new TreeNode(head.val);
		root.left = dfs(p, leftLength - 1);
		root.right = dfs(head.next, length - leftLength);
		return root;
	}*/
	
	public ListNode createList(ListNode node) {
		node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = null;
		return node;
	}
	
	public void print(TreeNode root) {
		if(root != null) {
			print(root.left);
			System.out.println(root.val);
			print(root.right);
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
