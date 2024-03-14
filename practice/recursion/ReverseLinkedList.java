package practice.recursion;

import practice.linkedlist.common.LinkedListNode;
import practice.linkedlist.common.PrintList;

public class ReverseLinkedList {

  private static LinkedListNode reverseListRecursively(LinkedListNode head) {
    if (head == null || head.next == null) {//Base case
      return head;
    }

    LinkedListNode reversedSubList = reverseListRecursively(head.next);//recursive call
    head.next.next = head;
    head.next = null;
    return reversedSubList;
  }

  private static LinkedListNode reverseListIteratively(LinkedListNode head) {
    LinkedListNode prev = null;
    LinkedListNode curr = head;

    while (curr != null) {
      LinkedListNode tempNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tempNext;
    }
    return prev;
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    head.next.next = new LinkedListNode(5);
    head.next.next.next = new LinkedListNode(9);

    LinkedListNode head1 = new LinkedListNode(1);
    head1.next = new LinkedListNode(2);
    head1.next.next = new LinkedListNode(5);
    head1.next.next.next = new LinkedListNode(9);

    System.out.println("Original Linked List:");
    PrintList.printListWithForwardArrow(head);
    System.out.println();
    System.out.println("Reversed Linked List using Recursion:");
    PrintList.printListWithForwardArrow(reverseListRecursively(head));
    System.out.println();
    System.out.println("Reversed Linked List using Iteration:");
    PrintList.printListWithForwardArrow(reverseListIteratively(head1));
  }
}
