package java.Greedy;

import java.util.*;

class Node {
  int data;
  char ch;

  Node left;
  Node right;

  Node(char ch, int data) {
    this.ch = ch;
    this.data = data;
  }
}

public class Huffman_Coding {
  void printCodes(Node root, String code) {
    if (root == null)
      return;

    if (root.left == null && root.right == null) {
      System.out.println(root.ch + " : " + code);
    }
    printCodes(root.left, code + "0");
    printCodes(root.right, code + "1");
  }

  public void huffman(char[] chars, int[] freq, int n) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
    for (int i = 0; i < n; i++) {
      pq.offer(new Node(chars[i], freq[i]));
    }
    while (pq.size() > 1) {
      Node left = pq.poll();
      Node right = pq.poll();
      Node merged = new Node('-', left.data + right.data);
      merged.left = left;
      merged.right = right;
      pq.offer(merged);
    }
    printCodes(pq.peek(), "");
  }
}
