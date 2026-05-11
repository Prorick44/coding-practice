package java.Linked_List;

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}

public class Reverse_Node_in_K_Group {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    int count = 0;
    while (current != null && count < k) {
      current = current.next;
      count++;
    }
    if (count == k) {
      current = reverseKGroup(current, k);
      while (count-- > 0) {
        ListNode temp = head.next;
        head.next = current;
        current = head;
        head = temp;
      }
      head = current;
    }
    return head;
  }
}
