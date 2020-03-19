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

        int n = 2;

        System.out.println("Middle of the Linked List : "+middleOfLL(ll));

        System.out.println("n-th node from the end : "+nthNodeFromEndLengthApproachBigOLinear(ll,n));

        System.out.println("n-th node from the end : "+nthNodeFromEndTwoPointerApproachBigOLinear(ll,n));

        System.out.println("Reverse a link list:");

        Node reverseHead = reverseLinkedListIterative(ll);
        printLL(reverseHead);
    }

    private static Node reverseLinkedListIterative(LinkedList ll) {
       Node curr = ll.head;
       Node prev = null;
       while(curr!=null){
           Node next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
    }

    private static int nthNodeFromEndTwoPointerApproachBigOLinear(LinkedList ll, int n) {
        Node firstNode = ll.head;
        Node secondNode = ll.head;
        for(int i=0;i<n;i++){
            if(firstNode == null){
                return -1;
            }
            firstNode = firstNode.next;
        }
        while(firstNode!=null){
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }

        return secondNode.data;
    }

    private static int nthNodeFromEndLengthApproachBigOLinear(LinkedList ll, int n) {
        int length = 0;
        Node curr = ll.head;
        while(curr!=null){
            curr = curr.next;
            length++;
        }
        System.out.println("Length of linked list:"+length);
        if(length<n){
            return -1;
        }
        curr=ll.head;
        for(int i=1;i<length-n+1;i++){
            curr = curr.next;
        }
        return curr.data;
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

    private static void printLL(Node curr){
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
            Node curr = linkedList.head;
            for(int i=0;i<size;i++){
                curr = curr.next;
            }
            return curr.data;
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