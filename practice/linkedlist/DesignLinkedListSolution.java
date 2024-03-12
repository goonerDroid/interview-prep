package practice.linkedlist;

import practice.linkedlist.LinkedListCycleSolution.ListNode;

/**
 * Leetcode Q - <a href="https://leetcode.com/problems/design-linked-list/">...</a>
 */
public class DesignLinkedListSolution {

  public static class MyLinkedList {

    //Sentinel nodes for dealing with linked list and allows to avoid a myriad of edge cases
    private final ListNode head;
    private int size;

    public MyLinkedList() {
      head = new ListNode(0);
      size = 0;
    }

    public int get(int index) {
      if (index >= size || index < 0) {
        return -1;
      }
      int count = 0;
      ListNode curr = head;
      while (count <= index) {
        curr = curr.next;
        count++;
      }
      return curr.val;
    }

    public void addAtHead(int val) {
      addAtIndex(0, val);
    }

    public void addAtTail(int val) {
      addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
      if (index > size) {
        return;
      } else if (index < 0) {
        index = 0;
      }

      int count = 0;
      ListNode curr = head;
      while (count < index) {
        curr = curr.next;
        count++;
      }

      ListNode toAdd = new ListNode(val);
      toAdd.next = curr.next;
      curr.next = toAdd;
      size++;
    }

    public void deleteAtIndex(int index) {
      if (index >= size) {
        return;
      }

      int count = 0;
      ListNode curr = head;
      while (count < index) {
        curr = curr.next;
        count++;
      }

      curr.next = curr.next.next;
      size--;
    }
  }

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    printListWithForwardArrow(myLinkedList.head);
    System.out.println();
    myLinkedList.addAtTail(3);
    printListWithForwardArrow(myLinkedList.head);
    System.out.println();
    myLinkedList.addAtIndex(1, 2);
    printListWithForwardArrow(myLinkedList.head);
    System.out.println();
    System.out.println("Value are index 1 is->" + myLinkedList.get(1));
    myLinkedList.deleteAtIndex(1);
    printListWithForwardArrow(myLinkedList.head);
    System.out.println();
    System.out.println("Value are index 1 is->" + myLinkedList.get(1));
  }

  public static void printListWithForwardArrow(ListNode head) {
    ListNode temp = head;

    while (temp != null) {
      System.out.print(temp.val); // print node value
      temp = temp.next;
      if (temp != null) {
        System.out.print(" → ");
      }
    }
    // if this is the last node, print null at the end
    System.out.print(" → null ");
  }


}
