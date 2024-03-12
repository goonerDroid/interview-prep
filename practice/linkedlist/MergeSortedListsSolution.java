package practice.linkedlist;

import practice.linkedlist.common.LinkedListNode;
import practice.linkedlist.common.PrintList;


/**
 * LC Question - <a
 * href="https://leetcode.com/problems/merge-two-sorted-lists/description/">...</a>
 */
public class MergeSortedListsSolution {

  /**
   * This is a recursive approach, which has TC of O(M + N) and SC of O(M + N) as each each
   * recursive call consume single stack frame each, so m+n stack frames consumes O(M + N) space
   */
  public static LinkedListNode mergeTwoListsRecursively(LinkedListNode list1,
      LinkedListNode list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    } else if (list1.data < list2.data) {
      list1.next = mergeTwoListsRecursively(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoListsRecursively(list1, list2.next);
      return list2;
    }
  }


  /**
   * This has a SC of O(1) since we are just rearranging the pointers, whereas the TC remains the
   * same at O(M + N)
   */
  public static LinkedListNode mergeTwoListsIteratively(LinkedListNode list1,
      LinkedListNode list2) {

    LinkedListNode head = new LinkedListNode();
    LinkedListNode tail = head;

    while (list1 != null && list2 != null) {

      if (list1.data <= list2.data) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }

      tail = tail.next;
    }

    tail.next = list1 == null ? list2 : list1;

    return head.next;
  }

  public static void main(String[] args) {
    LinkedListNode head1 = new LinkedListNode(1);
    head1.next = new LinkedListNode(2);
    head1.next.next = new LinkedListNode(4);
    head1.next.next.next = new LinkedListNode(8);

    LinkedListNode head2 = new LinkedListNode(1);
    head2.next = new LinkedListNode(3);
    head2.next.next = new LinkedListNode(4);
    head2.next.next.next = new LinkedListNode(9);

    System.out.println("First Linked List:");
    PrintList.printListWithForwardArrow(head1);
    System.out.println();
    System.out.println("Second Linked List:");
    PrintList.printListWithForwardArrow(head2);

    System.out.println();

    System.out.println(
        "Spliced Linked List using Recursion:");

    PrintList.printListWithForwardArrow(mergeTwoListsRecursively(head1, head2));
    System.out.println();

    LinkedListNode head3 = new LinkedListNode(1);
    head3.next = new LinkedListNode(2);
    head3.next.next = new LinkedListNode(4);
    head3.next.next.next = new LinkedListNode(8);

    LinkedListNode head4 = new LinkedListNode(3);
    head4.next = new LinkedListNode(5);
    head4.next.next = new LinkedListNode(6);
    System.out.println("First Linked List:");
    PrintList.printListWithForwardArrow(head1);
    System.out.println();
    System.out.println("Second Linked List:");
    PrintList.printListWithForwardArrow(head2);

    System.out.println();
    System.out.println("Spliced Linked List using Iteration:");
    PrintList.printListWithForwardArrow(mergeTwoListsIteratively(head3, head4));
  }
}
