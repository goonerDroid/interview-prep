package practice.linkedlist;

import practice.linkedlist.common.LinkedList;
import practice.linkedlist.common.LinkedListNode;
import practice.linkedlist.common.PrintList;


/**
 * LC Question  - <a
 * href="https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class AddTwoNumbersSolution {

  /*
      Basic intuition is to do basic math and use carry logic.
      This has a TC of O(max(M X N)), where M & N are the length of l1 and l2 respectively.
      It iterates at most max(m,n) times

      SC is O(1)
   */
  public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
    LinkedListNode dummyNode = new LinkedListNode(0);
    LinkedListNode curr = dummyNode;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int x = l1 != null ? l1.data : 0;
      int y = l2 != null ? l2.data : 0;

      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new LinkedListNode(sum % 10);
      curr = curr.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummyNode.next;
  }

  public static void main(String[] args) {
    int[] input1 = new int[]{9, 9, 9, 9, 9, 9, 9};
    int[] input2 = new int[]{9, 9, 9, 9};

    LinkedList<Integer> inputLinkedList1 = new LinkedList<>();
    inputLinkedList1.createLinkedList(input1);
    PrintList.printListWithForwardArrow(inputLinkedList1.head);

    LinkedList<Integer> inputLinkedList2 = new LinkedList<>();
    inputLinkedList2.createLinkedList(input2);
    PrintList.printListWithForwardArrow(inputLinkedList2.head);

    System.out.println();
    System.out.print("Sum of integers in linked list ");
    PrintList.printListWithForwardArrow(
        addTwoNumbers(inputLinkedList1.head, inputLinkedList2.head));
  }


}
