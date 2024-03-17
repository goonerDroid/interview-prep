package practice.sorting;


import java.util.ArrayList;
import java.util.List;
import practice.linkedlist.common.ListIntNode;

/**
 * LC Q - <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">...</a>
 */
public class MergeKSortedLists {

  private static ListIntNode merge(ListIntNode left, ListIntNode right) {
    ListIntNode helper = new ListIntNode(0);
    ListIntNode temp = helper;

    while (left != null && right != null) {
      if (left.val < right.val) {
        temp.next = left;
        temp = temp.next;
        left = left.next;
      } else {
        temp.next = right;
        temp = temp.next;
        right = right.next;
      }
    }

    while (left != null) {
      temp.next = left;
      temp = temp.next;
      left = left.next;
    }

    while (right != null) {
      temp.next = right;
      temp = temp.next;
      right = right.next;
    }

    return helper.next;
  }

  private static ListIntNode mergeSort(List<ListIntNode> lists, int start, int end) {
    if (start == end) {
      return lists.get(start);
    }

    int mid = (end - start) / 2;
    ListIntNode left = mergeSort(lists, start, mid);
    ListIntNode right = mergeSort(lists, mid + 1, end);

    return merge(left, right);
  }

  private static ListIntNode mergeKLists(List<ListIntNode> lists) {
    if (lists.size() == 0) {
      return null;
    }
    return mergeSort(lists, 0, lists.size() - 1);
  }

  public static void main(String[] args) {
    List<ListIntNode> multipleLists = new ArrayList<>();
    multipleLists.add(createList(new int[]{1, 4, 5}));
    multipleLists.add(createList(new int[]{1, 3, 4}));
    multipleLists.add(createList(new int[]{2, 6}));
    ListIntNode result3 = mergeKLists(multipleLists);

    System.out.println("Reversed List -> ");
    printList(result3);
  }

  private static ListIntNode createList(int[] values) {
    ListIntNode dummy = new ListIntNode(-1);
    ListIntNode current = dummy;
    for (int value : values) {
      current.next = new ListIntNode(value);
      current = current.next;
    }
    return dummy.next;
  }

  private static void printList(ListIntNode head) {
    ListIntNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
