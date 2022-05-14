package LinkedList;

import org.w3c.dom.Node;
 /*
  A node can be added in three ways
    1) At the front of the linked list
    2) After a given node.
    3) At the end of the linked list.
 */
public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
//            next = null;
        }
    }

//     Add a node at the front

     public void addAtFront(int data){

        Node newNode = new Node(data);
         newNode.next = head;
         head = newNode;
     }

 // Add a node after a given node

     public void insertAfter(Node previous_node, int data){
        if(previous_node == null){
            System.out.println(
                    "The given previous node cannot be null");
            return;
        }
        Node n = head;

        while(n != null){
            if(previous_node.data == n.data){
                Node newNode = new Node(data);
               newNode.next = previous_node.next;
               previous_node.next = newNode;
            }
            n = n.next;
        }
     }
//     Add a node at the end

     public void addAtEnd(int data){

        Node n = head;
        Node lastNode = head;
        while(n != null){
            lastNode = n;
            n = n.next;
        }
        Node newNode = new Node(data);
        lastNode.next = newNode;
        newNode.next = null;
     }

     // delete a node from the linked list

     public void deleteANode(int data){

        Node n = head;
        Node prev_node = n;

        while(n != null){
            if(n == head && n.data == data){
                    head = n.next;
                    return;
            }else{
                if(n.data == data){
                    prev_node.next = n.next;
                    return;
                }else{
                    prev_node = n;
                    prev_node.next = n.next;
                }
            }
            n = n.next;
        }

     }




     public void printList(){
        Node n = head;
        while(n.next !=  null){
            System.out.print(n.data+" -> ");
            n = n.next;
        }
         System.out.println(n.data);

     }

 }
