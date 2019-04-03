/*https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/
 *   Design HashMap
  Go to Discuss
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

 */
package HashTable;

public class DesignHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found) 

		
	}
	static class MyHashMap {

	    public MyHashMap() {
	    }

	    final ListNode[] nodes = new ListNode[10000];    
	    
	    public int hash(int key){
	        return Integer.hashCode(key) % nodes.length;
	    }
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int i = hash(key);
	        if(nodes[i]==null){
	            nodes[i] = new ListNode(-1,-1);
	        }
	        ListNode prev = find(nodes[i],key);
	        if(prev.next ==null){
	            prev.next = new ListNode(key, value);
	        }else{
	            prev.next.val = value;
	        }

	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int i = hash(key);
	        
	        if(nodes[i]==null){
	            return -1;
	        }
	        ListNode node = find(nodes[i],key);
	        return node.next == null ?-1:node.next.val;
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int i = hash(key);
	        if(nodes[i]==null) return;
	        ListNode prev = find(nodes[i], key);
	        if(prev.next==null) return;
	        prev.next = prev.next.next;
	    }

	    public ListNode find(ListNode bucket, int key){
	        ListNode node = bucket,prev=null;
	        while(node!=null &&node.key!=key){
	            prev=node;
	            node = node.next;
	        }
	        return prev;
	    }
	    
	    class ListNode{
	        int key, val;
	        ListNode next;
	        public ListNode(int key, int val){
	            this.val=val;
	            this.key=key;
	        }
	    } 
	}
}
