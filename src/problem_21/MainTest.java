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
                l.next = l1;//�����ڽ�l1��㸳ֵ��l.next�󣬲�������ִ��l=l1����ֻ��ִ��l1=l1.next��l=l.next��������λ�ÿ��Ե�����
                //����Ϊʲô����û��ȫŪ���ף�Ӧ�ø�java����Ķ���������й�ϵ��
     //           l = l.next;
                l1 = l1.next;
            }
            else if(l1.val > l2.val) {
                l.next = l2;
      //          l = l.next;
                l2 = l2.next;
            }
            else {//������������5��5�鲢��������Ϊ5��5����������Ҫ�������ӽ��
                l.next = l1;
                l = l.next;
                l1 = l1.next;
                
                l.next = l2;
        //        l = l.next;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 != null) {//���ڲ���Ҫ�½���㣬����ֻ��Ҫ��ʣ�µ����������ȥ���ɡ�
            l.next = l1;
        }
        else if(l2 != null) {
            l.next = l2;
        }
        l = tmp;
        return l.next;
    }
}
