package linear_ds.java;

class DubNode{
	int data;
	DubNode prev,next;
	public DubNode(int data){
		this.data=data;
		prev=next=null;
	}
}

class DubMethods{
	static DubNode head,tail;
	static int count=0;
	public static void insertAtBeg(int data) {
		DubNode node = new DubNode(data);
		if( head==null && tail==null) {
			head=node;
			tail=node;
		}
		else {
			node.next=head;
			head.prev=node;
			head=node;
		}
	}
	
	public static void insertAtend(int data) {
		DubNode node =new DubNode(data);
		if(head==null&& tail ==null) {
			head=node;
			tail=node;
		}
		else {
			node.prev=tail;
			tail.next=node;
			tail=node;
		}
	}
	
	public static void diplay() {
		DubNode temp = head;
		while (temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
			count++;
		}
		System.out.println("\nNo of node: "+count);
	}
}

public class DoublyLinkedList extends DubMethods {
	public static void main (String[]args) {
		insertAtBeg(3);		
		insertAtBeg(2);
		insertAtBeg(1);
		insertAtBeg(0);
		insertAtend(4);
		insertAtend(5);
		diplay();
	}
}
