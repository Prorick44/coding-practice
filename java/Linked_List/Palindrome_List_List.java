package java.Linked_List;

class ListNode {
  int val;
  ListNode next;
}

public class Palindrome_List_List {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode prev = null;
    while (slow != null) {
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    while (prev != null) {
      if (head.val != prev.val)
        return false;
      head = head.next;
      prev = prev.next;
    }
    return true;
  }
}
