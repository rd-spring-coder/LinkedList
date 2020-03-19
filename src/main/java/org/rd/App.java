package org.rd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(10);
        ll.insertAtEnd(20);
        ll.insertAtEnd(30);
        ll.insertAtEnd(40);
        ll.insertAtEnd(50);
        ll.insertAtEnd(60);

        printLL(ll);

        System.out.println("Middle of the Linked List : "+middleOfLL(ll));
    }

    private static void printLL(LinkedList ll) {
        Node curr = ll.head;
        while(curr!=null){
            if(curr.next!=null){
                System.out.print(curr.data+"-->");
            }else{
                System.out.print(curr.data);
            }
            curr = curr.next;
        }
    }

    private static int middleOfLL(LinkedList linkedList) throws Exception{
        int size = linkedList.size();
        if(size == 0){
            throw new Exception("please provide a valid linked list");
        }else{
            if(size >=1){
                size = size/2;
            }
            for(int i=0;i<size;i++){
                linkedList.head = linkedList.head.next;
            }
            return linkedList.head.data;
        }
    }

    
}

class LinkedList{
    
    Node head;

    LinkedList(){
        head = null;
    }

    public void insertAtEnd(int data){
        Node tmp = new Node(data);
        if(head == null){
            head = tmp;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = tmp;
    }

    public int size(){
        int counter=0;
        Node curr = this.head;
        while(curr!=null){
            counter++;
            curr = curr.next;
        }
        return counter;
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}