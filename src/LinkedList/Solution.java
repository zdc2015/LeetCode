package LinkedList;

public class Solution {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
		}
	}
	
	public static void print(ListNode head) {
		ListNode p =  head;
		while(p!=null) {
			System.out.print(p.val+" -> ");
			p = p.next;
		}
		System.out.println("null");
	}
	
	public static ListNode createNode(int a[]) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0;i<a.length;i++) {
			p.next = new ListNode(a[i]);
			p = p.next;
		}
		return head.next;
	}
	
	/*
	 * 
	 */
	
	public ListNode reverseList(ListNode head) {
        if(head==null) return head;
		ListNode p = head;
        ListNode tail = null;
        ListNode q = p.next;
        
        while(true) {
        	p.next = tail;
        	tail = p;
        	p = q;
        	if(p==null) {
        		return tail;
        	}else {
        		q = q.next;
        	}
        }
    }
	
	//����˼·��һ��ɨ�裬��ɨ�赽��m��ʱ����ʼ��ת���ѵ�ǰ����nextָ����һ�������ӵ�m����ת����n��ʱ����ʼ�ν������ת������
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || m==n) return head;
		
		ListNode p = head;
		ListNode pre_p = null;
		ListNode pre_m = null;//ָ���m-1�����
		ListNode first = null;//ָ���m�����
		
		for(int i=1;i<=n;i++) {
			if(i==m-1) pre_m = p;
			if(i>=m) {
				if(i==m) first = p;
				ListNode tmp = p.next;
				p.next = pre_p;
				pre_p = p;
				p = tmp;
				//����ת����ת���ˣ����ɨβ����
				if(i==n) {
					if(pre_m!=null) { //���m==1
						pre_m.next = pre_p;
					}else {
						head = pre_p;
					}
					first.next = p;
				}
			}
			if(i<m) {
				pre_p = p;
				p = p.next;
			}
		}
		return head;
    }

	
	/*
	 * Odd Even Linked List
	 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
	 * 
	 * �ҵ�˼·������һ��ָ��p���б�������ÿһ������nextָ�붼ָ�����¸���㡣
	 */
	static ListNode oddevenList(ListNode head) {
		if(head==null) return head;
		
		ListNode evenhead = head.next;//ż������ͷָ��
		ListNode p = head;
		ListNode oddTail = head;//ָ����������β���
		
		for(int i=1;;i++) {
			if(i%2==1) {
				oddTail = p;
			}
			//��pָ�����һ�����
			if(p.next==null) {
				oddTail.next = evenhead;
				break;
			}
			ListNode tmp = p.next;
			p.next = tmp.next;
			p = tmp;
		}
		
		return head;
	}
	
	/*
	 * Partition List
	 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
	 * ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
	 * 
	 * ˼·����������������һ����С��x�Ľ�㣬��һ���Ŵ��ڵ���x�Ľ��
	 */
	
	static ListNode partitionList(ListNode head, int x) {
		ListNode lessX = new ListNode(0);
		ListNode noLessX = new ListNode(0);
		ListNode lp = lessX;
		ListNode nlp = noLessX;
		ListNode p = head;
		
		while(p!=null) {
			if(p.val<x) {
				lp.next = p;
				lp = p;
			}else {
				nlp.next = p;
				nlp = p;
			}
			p = p.next;
		}
		lp.next = noLessX.next;
		nlp.next = null;
		return lessX.next;
	}
	
	/*
	 * Remove Duplicates from Sorted List
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * 
	 * ��������ָ����бȽϣ�����һ�鼴��
	 */
	static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        for (ListNode prev = head, cur = head.next; cur != null; cur = prev.next) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
