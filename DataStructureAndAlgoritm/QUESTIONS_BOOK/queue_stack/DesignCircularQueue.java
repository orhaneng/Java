package queue_stack;

public class DesignCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k =5;
		int value=5;
		 MyCircularQueue obj = new MyCircularQueue(k);
		 boolean param_1 = obj.enQueue(value);
		 boolean param_2 = obj.enQueue(2);
		 boolean param_3 = obj.enQueue(3);

		 boolean param_4 = obj.deQueue();
		 int param_5 = obj.Front();
		 int param_6 = obj.Rear();
		 boolean param_7 = obj.isEmpty();
		 boolean param_8 = obj.isFull();
	}

	static class MyCircularQueue {
	    
	    private int[] data;
	    private int head;
	    private int tail;
	    private int size;

	    /** Initialize your data structure here. Set the size of the queue to be k. */
	    public MyCircularQueue(int k) {
	        data = new int[k];
	        head = -1;
	        tail = -1;
	        size = k;
	    }
	    
	    /** Insert an element into the circular queue. Return true if the operation is successful. */
	    public boolean enQueue(int value) {
	        if (isFull() == true) {
	            return false;
	        }
	        if (isEmpty() == true) {
	            head = 0;
	        }
	        tail = (tail + 1) % size;
	        data[tail] = value;
	        return true;
	    }
	    
	    /** Delete an element from the circular queue. Return true if the operation is successful. */
	    public boolean deQueue() {
	        if (isEmpty() == true) {
	            return false;
	        }
	        if (head == tail) {
	            head = -1;
	            tail = -1;
	            return true;
	        }
	        head = (head + 1) % size;
	        return true;
	    }
	    
	    /** Get the f
	     *Front item from the queue. */
	    public int Front() {
	        if (isEmpty() == true) {
	            return -1;
	        }
	        return data[head];
	    }
	    
	    /** Get the last item from the queue. */
	    public int Rear() {
	        if (isEmpty() == true) {
	            return -1;
	        }
	        return data[tail];
	    }
	    
	    /** Checks whether the circular queue is empty or not. */
	    public boolean isEmpty() {
	        return head == -1;
	    }
	    
	    /** Checks whether the circular queue is full or not. */
	    public boolean isFull() {
	        return ((tail + 1) % size) == head;
	    }
	}

}