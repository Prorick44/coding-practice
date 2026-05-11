package java.Linked_List;

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}

public class Reverse_Linked_List {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
