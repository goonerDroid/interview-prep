package practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * LC Question  - <a
 * href="https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class LinkedListCycleSolution {

  //Bruteforce solution
  public static boolean hasCycle(ListNode head) {
    Set<ListNode> seenNodes = new HashSet<>();
    ListNode curr = head;

    while (curr != null) {
      if (seenNodes.contains(curr)) {
        return true;
      }

      seenNodes.add(curr);
      curr = curr.next;
    }
    return false;
  }


  /**
   * This has TC of O(n) and since two pointer approach is used SC is O(1)
   */
  public static boolean hasCycle1(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = new ListNode(2);

    System.out.println("Original Linked List:");
    printList(head);

    boolean isCyclic = hasCycle1(head);
    System.out.println("Result -> " + isCyclic);
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  /**
   * Definition of a singly linked list.
   */
  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
