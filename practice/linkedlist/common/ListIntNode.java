package practice.linkedlist.common;

/**
 * Custom ListNode class which has DLL property.
 */
public class ListIntNode {

  public int val;
  public ListIntNode prev;
  public ListIntNode next;

  public ListIntNode(int val) {
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}