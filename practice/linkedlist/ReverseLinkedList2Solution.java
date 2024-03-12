package practice.linkedlist;


import practice.linkedlist.common.LinkedListNode;
import practice.linkedlist.common.PrintList;

/**
 * LC - Question - <a
 * href="https://leetcode.com/problems/reverse-linked-list-ii/description/">...</a>
 */
public class ReverseLinkedList2Solution {


  private static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

    //Create dummy nodes
    LinkedListNode dummy = new LinkedListNode(0);
    dummy.next = head;

    //Assign intial markers and get current node till the left pointer
    LinkedListNode leftPre = dummy;
    LinkedListNode curr = head;
    for (int i = 0; i < left - 1; i++) {
      leftPre = leftPre.next;
      curr = curr.next;
    }

    //Create marker nodes and pre nodes
    LinkedListNode subListHead = curr;
    LinkedListNode preNode = null;
    for (int i = 0; i <= right - left; i++) {
      LinkedListNode nextNode = curr.next;
      curr.next = preNode;
      preNode = curr;
      curr = nextNode;
    }

    //Join places
    leftPre.next = preNode;
    subListHead.next = curr;

    return dummy.next;
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(4);
    head.next = new LinkedListNode(8);
    head.next.next = new LinkedListNode(15);
    head.next.next.next = new LinkedListNode(16);
    head.next.next.next.next = new LinkedListNode(23);
    head.next.next.next.next.next = new LinkedListNode(42);

    System.out.println("Original Linked List:");
    PrintList.printListWithForwardArrow(head);

    int left = 3;
    int right = 5;
    System.out.println(
        "Reversed sub Linked List from left index " + left + "  and right index " + right + ":");

    PrintList.printListWithForwardArrow(reverseBetween(head, left, right));
  }
}
