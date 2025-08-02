package linear_ds.java;

class Cnode{
	int data;
	Cnode next;
	public Cnode(int data){
		this.data=data;
		next=null;
	}
}
class Cmethod{
	static Cnode head,tail;
	public static void insertatbeg(int data) {
		Cnode node = new Cnode(data);
		if(head==null) {
			head=node;
			tail=node;
			node.next=head;
		}
		else {
			node.next=head;
			head=node;
			tail.next=head;
		}
	}
	public static void display() {
		Cnode temp=head;
		do {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}while (temp!=head);
	}
}

public class CircLinkedList extends Cmethod{
	public static void main(String[] args) {
		insertatbeg(3);
		insertatbeg(2);
		insertatbeg(1);
		insertatbeg(0);
		display();
	}

}
