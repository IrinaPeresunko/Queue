package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class NotPriorityQueue<Item> implements Iterable<Item> {

	private int N;
	private Node first;
	private Node last;
	
	private class Node{
		private Item item;
		private Node next;
	}
	public NotPriorityQueue(){
		first=null;
		last=null;
	}
	public int size(){
		return N;
	}
	public int length(){
		return N;
	}
	public Item peek(){
		if(isEmpty()) throw new RuntimeException("Queue underflow");
		return first.item;
	}
	public boolean isEmpty(){
		return (first==null);
	}
	public Item dequeue(){
		if(isEmpty()) throw new RuntimeException("Queue underflow");
		Item item=first.item;
		first=first.next;
		N--;
		if(isEmpty()) last=null;
		return item;
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

	    public Item next() {
	       if (!hasNext()) throw new NoSuchElementException();
	       Item item = current.item;
	       current = current.next; 
	       return item;
	    }
	 }
}
