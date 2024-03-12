package practice.linkedlist.common;

/**
 * Custom ListNode class which has DLL property and stores String as data type. This is used for
 * browser history DLL problem
 */
public class ListStringNode {

  public String url;
  public ListStringNode prev;
  public ListStringNode next;

  public ListStringNode(String url) {
    this.url = url;
    this.prev = null;
    this.next = null;
  }
}