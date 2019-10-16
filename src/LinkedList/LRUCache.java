package LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * �����˽�ʲô��LRU��LRU�����ڻ��������������ʹ���㷨(Least Recently Used)���������ʲô���������ʹ�á������տ�ʼ�һ���Ϊ�������ڻ����е����ȼ������Ƶ�ʺ�ʱ���й�
 * ������Ƶ��Խ�ߣ����ȼ�Խ�ߣ�֮����������ʣ����ȼ�Խ�ߡ������Ҿ��ǰ������˼·��Ƶģ����û�뵽������LRU�ˡ�����
 * 
 * LRUֻ����ʱ�䲻����Ƶ�ʣ����治��ʱ�����û��ʹ�õı������Խ��ʹ��
 * 
 * */
public class LRUCache {
	
	class Node{
		int key;
		int value;
		Node next=null;
		Node prev=null;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	int size;
	Map<Integer,Node> map;
	Node head;
	Node tail;
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
		map = new HashMap<Integer,Node>();
	}
	    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        //����ҵ��Ľ��Ϊͷ����ֻ��һ�����
        if(size==1 || node==head) {
        	return node.value;
        }else{//��ֹһ��������ҵ��Ľ�㲻�ǵ�һ��
        	node.prev.next = node.next;
        	if(node==tail) {//�����β���
        		tail = node.prev;
        	}else {
        		node.next.prev = node.prev;
        	}
        	node.next = head;
        	head.prev = node;
        	node.prev = null;
        	head = node;
        	return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	n.value = value;
        	get(key);//putҲ�൱�ڷ��ʣ�����get()������˳����
        }else {
        	if(size==capacity) {
        		map.remove(tail.key);
            	tail = tail.prev;
            	if(tail!=null) tail.next = null; //��capacity==1
            	size--;
            }
        	Node n = new Node(key,value);
        	if(size==0) {
        		head=n;
        		tail=n;
        	}else {
        		n.next = head;
            	head.prev = n;
            	head = n;
        	}
        	map.put(key, n);
        	size++;
        }
    }

	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 1 /* �������� */ );

		cache.put(2, 1);
		
		System.out.println(cache.get(2));     // ����  1
		cache.put(3, 2);    // �ò�����ʹ����Կ 2 ����
		System.out.println(cache.get(2));       // ���� -1 
		System.out.println(cache.get(3));     // ����  3
	}

}
