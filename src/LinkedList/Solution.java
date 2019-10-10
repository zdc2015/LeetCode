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
	
	//整体思路是一遍扫描，当扫描到底m个时，开始逆转，把当前结点的next指向上一个，当从第m个逆转到第n个时，开始衔接这段逆转的链表
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || m==n) return head;
		
		ListNode p = head;
		ListNode pre_p = null;
		ListNode pre_m = null;//指向第m-1个结点
		ListNode first = null;//指向第m个结点
		
		for(int i=1;i<=n;i++) {
			if(i==m-1) pre_m = p;
			if(i>=m) {
				if(i==m) first = p;
				ListNode tmp = p.next;
				p.next = pre_p;
				pre_p = p;
				p = tmp;
				//该逆转的逆转完了，完成扫尾工作
				if(i==n) {
					if(pre_m!=null) { //如果m==1
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
	 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
	 * 
	 * 我的思路：设置一个指针p进行遍历，将每一个结点的next指针都指向下下个结点。
	 */
	static ListNode oddevenList(ListNode head) {
		if(head==null) return head;
		
		ListNode evenhead = head.next;//偶数结点的头指针
		ListNode p = head;
		ListNode oddTail = head;//指向奇数结点的尾结点
		
		for(int i=1;;i++) {
			if(i%2==1) {
				oddTail = p;
			}
			//当p指向最后一个结点
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
	 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
	 * 你应当保留两个分区中每个节点的初始相对位置。
	 * 
	 * 思路：设置两个空链表，一个放小于x的结点，另一个放大于等于x的结点
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
	 * 设置两个指针进行比较，遍历一遍即可
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
