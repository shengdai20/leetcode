package problem_61;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;
		int k = 6;
		ListNode res = new Main().rotateRight(head, k);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		int len = 1;
		ListNode cur = head;
		while(cur.next != null) {
			len++;
			cur = cur.next;
		}
		//形成循环单链表
		cur.next = head;
		//找到前面翻转的最末节点位置
		int pre = len - k % len;
		for(int i = 0; i < pre; i++) {
			cur = cur.next;
		}
		//记录头节点，由于是循环链表，所以已经相连了
		ListNode res = cur.next;
		//将末节点next=null
		cur.next = null;
		return res;
	}
	
/*	public ListNode rotateRight(ListNode head, int k) {
		//如果链表为空或不需要rotate，直接返回原链表
		if(k == 0 || head == null) {
			return head;
		}
		//记录原链表头节点
		ListNode tmpHead = head;
		//计算链表长度
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		//计算需要rotate的实际数量
		k = k % len;
		//如果不需要rotate直接返回原链表
		if(k == 0) {
			return tmpHead;
		}
		//计算rotate前面需要换到后面的数量
		int pre = len - k, cnt = 0;
		head = tmpHead;
		//开始分割前面需要换到后面的链表节点，用postHead记录头节点
		ListNode post = null, postHead = post;
		while(cnt < pre) {
			cnt++;
			//如果头节点为空，单独处理，由于前面post=null，所以这里postHead需要重新赋值
			if(post == null) {
				post = head;
				postHead = post;
			}
			//尾插
			else {
				post.next = head;
				post = head;
			}
			head = head.next;
		}
		//由于是最后一个节点所以要next=null
		post.next = null;
		//分割后面需要换到前面的链表节点，用resHead记录头节点，与前面类似
		ListNode res = null, resHead = res;
		while(head != null) {
			if(res == null) {
				res = head;
				resHead = res;
			}
			else {
				res.next = head;
				res = head;
			}
			head = head.next;
		}
		//将分割的两个单链表连接起来
		res.next = postHead;
		//返回头节点即可
		return resHead;
	}*/
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}