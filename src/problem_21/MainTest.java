package problem_21;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class MainTest {
	
	public void addNode(ListNode l, int num) {
		ListNode listNode = new ListNode(num);
		listNode.next = null;
		if(l == null) {
			l = listNode;
			return;
		}
		ListNode tmp = l;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = listNode;
	}

	public static void main(String[] args) {
		MainTest t1 = new MainTest();
		ListNode l1 = new ListNode(4);
		t1.addNode(l1, 5);
	//	t1.addNode(l1, 6);
		ListNode l2 = new ListNode(4);
		t1.addNode(l2, 6);
	//	t1.addNode(l2, 7);
//		while(l1 != null) {
//			System.out.println("1val:" + l1.val);
//			l1 = l1.next;
//		}
//		while(l2 != null) {
//			System.out.println("2val:" + l2.val);
//			l2 = l2.next;
//		}
		ListNode l = t1.mergeTwoLists(l1, l2);
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode tmp = l;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l.next = l1;//这里在将l1结点赋值给l.next后，不能立即执行l=l1，而只能执行l1=l1.next和l=l.next（这两个位置可以调换）
                //至于为什么，还没完全弄明白，应该跟java里面的对象的引用有关系？
     //           l = l.next;
                l1 = l1.next;
            }
            else if(l1.val > l2.val) {
                l.next = l2;
      //          l = l.next;
                l2 = l2.next;
            }
            else {//测试用例中有5和5归并，结果输出为5，5，所以这里要两次连接结点
                l.next = l1;
                l = l.next;
                l1 = l1.next;
                
                l.next = l2;
        //        l = l.next;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 != null) {//由于不需要新建结点，所以只需要把剩下的链表结点接上去即可。
            l.next = l1;
        }
        else if(l2 != null) {
            l.next = l2;
        }
        l = tmp;
        return l.next;
    }
}
