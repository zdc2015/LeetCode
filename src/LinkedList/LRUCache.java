package LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * 首先了解什么事LRU，LRU是用于缓存管理的最近最少使用算法(Least Recently Used)，首先理解什么叫最近最少使用。。。刚开始我还以为数据留在缓存中的优先级与访问频率和时间有关
 * ，首先频率越高，优先级越高，之后最近被访问，优先级越高。本来我就是按照这个思路设计的，结果没想到我理解错LRU了。。。
 * 
 * LRU只考虑时间不考虑频率，缓存不够时，最久没被使用的被清除。越近使用
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
        //如果找到的结点为头结点或只有一个结点
        if(size==1 || node==head) {
        	return node.value;
        }else{//不止一个结点且找到的结点不是第一个
        	node.prev.next = node.next;
        	if(node==tail) {//如果是尾结点
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
        	get(key);//put也相当于访问，调用get()当调整顺序用
        }else {
        	if(size==capacity) {
        		map.remove(tail.key);
            	tail = tail.prev;
            	if(tail!=null) tail.next = null; //若capacity==1
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
		LRUCache cache = new LRUCache( 1 /* 缓存容量 */ );

		cache.put(2, 1);
		
		System.out.println(cache.get(2));     // 返回  1
		cache.put(3, 2);    // 该操作会使得密钥 2 作废
		System.out.println(cache.get(2));       // 返回 -1 
		System.out.println(cache.get(3));     // 返回  3
	}

}
