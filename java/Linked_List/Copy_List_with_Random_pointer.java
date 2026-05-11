package java.Linked_List;

class Node {
  int val;
  Node next;
  Node random;

  Node(int val) {
    this.val = val;
  }
}

public class Copy_List_with_Random_pointer {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    Node current = head;
    while (current != null) {
      Node copy = new Node(current.val);
      copy.next = current.next;
      current.next = copy;
      current = copy.next;
    }
    current = head;
    while (current != null) {
      if (current.random != null)
        current.next.random = current.random.next;
      current = current.next.next;
    }
    current = head;
    Node dummy = new Node(0);
    Node copyCurrent = dummy;
    while (current != null) {
      copyCurrent.next = current.next;
      current.next = current.next.next;
      current = current.next;
      copyCurrent = copyCurrent.next;
    }
    return dummy.next;
  }
}
