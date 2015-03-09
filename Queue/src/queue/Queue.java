package queue;

public class Queue {

	public static void main(String[] args) {
		NotPriorityQueue<Integer> npq = new NotPriorityQueue<Integer>();
        npq.enqueue(0);
        npq.enqueue(1);
        npq.enqueue(2);
        npq.enqueue(3);
        npq.enqueue(4);
        npq.enqueue(5);
        
        System.out.println(npq.toString());
        
        npq.dequeue();
        System.out.println(npq.toString());
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.enqueueWithPriority(11,4);
        pq.enqueueWithPriority(1,1);
        pq.enqueueWithPriority(2,2);
        pq.enqueueWithPriority(3,3);
        pq.enqueueWithPriority(4,4);
        pq.enqueueWithPriority(5,5);
        
        pq.a();
        //System.out.println(pq.toString());
        
        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
        System.out.println(pq.toString());
	}

}
