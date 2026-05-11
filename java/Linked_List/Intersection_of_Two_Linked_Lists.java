package java.Linked_List;

class ListNode {
  int val;
  ListNode next;
}

public class Intersection_of_Two_Linked_Lists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      a = (a == null) ? headB : a.next;
      b = (b == null) ? headA : b.next;
    }
    return a;
  }
}
