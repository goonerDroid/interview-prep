package practice.linkedlist;

import practice.linkedlist.common.ListStringNode;

/**
 * LC Q - <a href="https://leetcode.com/problems/design-browser-history/description/">...</a>
 */
public class DesignBrowserHistory {

  static class BrowserHistory {

    ListStringNode curr;

    public BrowserHistory(String homepage) {
      curr = new ListStringNode(homepage);
    }

    public void visit(String url) {
      ListStringNode tempNode = new ListStringNode(url);
      curr.next = tempNode;
      tempNode.prev = curr;
      curr = curr.next;
    }

    public String back(int steps) {
      while (curr.prev != null && steps-- > 0) {
        curr = curr.prev;
      }
      return curr.url;
    }

    public String forward(int steps) {
      while (curr.next != null && steps-- > 0) {
        curr = curr.next;
      }
      return curr.url;
    }
  }

  public static void main(String[] args) {
    String homePageURL = "leetcode.com";
    String visitURL1 = "google.com";
    String visitURL2 = "facebook.com";
    String visitURL3 = "youtube.com";
    String visitURL4 = "linkedin.com";
    BrowserHistory obj = new BrowserHistory(homePageURL);
    obj.visit(visitURL1);
    System.out.println(obj.curr.url);
    System.out.println();

    obj.visit(visitURL2);
    System.out.println(obj.curr.url);
    System.out.println();

    obj.visit(visitURL3);
    System.out.println(obj.curr.url);
    System.out.println();

    System.out.println("GO BACK BY 1-> Current pageURL-> " + obj.back(1));
    System.out.println();

    System.out.println("GO BACK AGAIN BY 1-> Current pageURL-> " + obj.back(1));
    System.out.println();

    System.out.println("GO FORWARD BY 1-> Current pageURL-> " + obj.forward(1));
    System.out.println();

    obj.visit(visitURL4);
    System.out.println(obj.curr.url);
    System.out.println();

    System.out.println("GO FORWARD BY 2-> Current pageURL-> " + obj.forward(2));
    System.out.println();

    System.out.println("GO BACK BY 2-> Current pageURL-> " + obj.back(2));
    System.out.println();

    System.out.println("GO BACK AGAIN BY 7-> Current pageURL-> " + obj.back(7));
    System.out.println();

  }

}
