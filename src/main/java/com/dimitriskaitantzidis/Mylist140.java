package com.dimitriskaitantzidis;

public class Mylist140 {
    private Node head;

    public Mylist140() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    
    public void addFirst (int in) {
        Node tmp = new Node(in);
        if (head !=null)
            tmp.setNext(head);
        head = tmp;
    }
    
    public int removeLast (){
        Node current = head;
        int result = -1;
        
        if(current == null) //length = 0
            System.out.println("List is empty!!!");
        else if (current.getNext() == null)//length = 1
        {
            result = current.getData();
            head = null;
        }
        else{ //length >= 2
            while (current.getNext().getNext() != null)
                    current = current.getNext();
            result = current.getNext().getData();
            current.setNext(null);
        }
        return result;
    }
    
    public void addLast (int in) {
        
        Node tmp = new Node(in);
        Node current = head;
        
        if (head ==null)
            head = tmp;
        else{
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(tmp);
        }
    }

	/**
	 * Adds a given value in a given position. If the position is a negative value, it
	 * prints an error message and no add operation is done.
	 * @param value The value given by the user to add to singly linked list
	 * @param position The position given by the user for the value to be added to the
	 * singly linked list
	 */
	public void add(int value, int position) {

		// Check if value of position is negative
		if (position < 0) {
			System.err.println("The value of position given is negative. "
					+ "No add operation was performed. Please use a zero or positive value");
			return;
		}

		// check if position is zero
		if (position == 0) {
			addFirst(value);
		}

		// Get Head
		Node current = head;

		// iterate in order to find the node that is the previous one before the position given
		for (int i = 0; i < position; i++) {

			if (i + 1 == position) {
				// current is the previous node before the position we want to add the value
				Node node = new Node(value); // The new value as Node object
				Node temp = current.getNext(); // The position we want for the new node to be added
				current.setNext(node); // Adding the new node to the given position
				node.setNext(temp); // Setting the new node to point to the node that was in the given position initially
			}

			// For position that is greater than the list size fill with zeros
			if (current.getNext() == null) {
				current.setNext(new Node(0));
			}

			current = current.getNext();
		}
	}
    
    public void printList () {
        Node current = head;
        while (current != null) {
            current.printNode();
            current = current.getNext();
        }
    }
    
    public static void main(String[] args) {
        Mylist140 Alex = new Mylist140();
//        System.out.println(Alex.getHead());
//        System.out.println("removed: "+Alex.removeLast());
//        Alex.printList();
//        Alex.addFirst(7);
//        //System.out.println("removed: "+Alex.removeLast());
//        //Alex.printList();
//        Alex.addFirst(12);
//        System.out.println("removed: "+Alex.removeLast());
//        Alex.printList();
//        Alex.addFirst(15);
//        Alex.addFirst(17);
//        Alex.addLast(123);
//        Alex.addLast(125);
//        Alex.printList();
//        System.out.println("removed: "+Alex.removeLast());
//        Alex.printList();
//        System.out.println(Alex.getHead());

//		for (int i = 0; i < 6; i++){
//			Alex.addLast(1);
//		}
//		Alex.printList();
//
//		Alex.add(999, 3);
//
//		Alex.printList();

		for (int i = 0; i < 6; i++){
			Alex.addLast(1);
		}
		Alex.printList();

		Alex.add(999, 0);

		Alex.printList();
	}
    
}
