package queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class PriorityQueue<Item> implements Iterable<Item> {

	private int N;
	private int[] priority;
	private int[] items;
	private Node first;
	private Node last;
	
	private class Node{
		private Object item;
		private Node next;
	}
	public PriorityQueue(){
		first=null;
		last=null;
		priority=new int[10];
		items = new int[10];
	}
	public int size(){
		return N;
	}
	public int length(){
		return N;
	}
	public Object peek(){
		if(isEmpty()) throw new RuntimeException("Queue underflow");
		return first.item;
	}
	public boolean isEmpty(){
		return (first==null);
	}
	public Object dequeue(){
		int i=0;
		while(i<N){
			Node x=new Node();
			x.item=items[i];
			if(isEmpty()){
				first=x;
				last=x;
			}
			else{
				last.next=x;
				last=x;
			}
			i++;
		}
		System.out.println(toString());
		if(isEmpty()) throw new RuntimeException("Queue underflow");
		Object item=first.item;
		first=first.next;
		N--;
		if(isEmpty()) last=null;
		return item;
	}
	public void enqueueWithPriority(int value,int priority){
		
			this.priority[N]=priority;
			this.items[N]=value;
		
		if(N!=0){
			int i=N;
			while(i>0){
				if(this.priority[i-1]<this.priority[i]){
					int temp=items[i-1];
					items[i-1]=items[i];
					items[i]=temp;
					
					temp=this.priority[i-1];
					this.priority[i-1]=this.priority[i];
					this.priority[i]=temp;
				}
				i--;
			}
		}
		N++;
	}
	public void a(){
		System.out.println(Arrays.toString(items));
	}
	public void enqueue(Item item){
		Node x=new Node();
		x.item=item;
		if(isEmpty()){
			first=x;
			last=x;
		}
		else{
			last.next=x;
			last=x;
		}
		N++;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(Item item:this){
			sb.append(item+" ");
		}
		return sb.toString();
	}
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	 private class ListIterator implements Iterator<Item> {
	    private Node current = first;

	    public boolean hasNext(){
	    	return current != null; 
	    }
	    public void remove(){
	    	throw new UnsupportedOperationException();
	    }

	    @SuppressWarnings("unchecked")
		public Item next() {
	       if (!hasNext()) throw new NoSuchElementException();
	       Object item = current.item;
	       current = current.next; 
	       return (Item) item;
	    }
	 }
}

