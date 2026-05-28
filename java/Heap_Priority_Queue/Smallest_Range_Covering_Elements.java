package java.Heap_Priority_Queue;

import java.util.*;

class Node {
  int value;
  int row;
  int col;

  Node(int value, int row, int col) {
    this.value = value;
    this.row = row;
    this.col = col;
  }
}

public class Smallest_Range_Covering_Elements {
  public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.size(); i++) {
      int val = nums.get(i).get(0);
      pq.offer(new Node(val, i, 0));
      max = Math.max(max, val);
    }

    int start = 0;
    int end = Integer.MAX_VALUE;

    while (pq.size() == nums.size()) {
      Node current = pq.poll();
      if (max - current.value < end - start) {
        start = current.value;
        end = max;
      }

      if (current.col + 1 < nums.get(current.row).size()) {
        int next = nums.get(current.row).get(current.col + 1);
        pq.offer(new Node(next, current.row, current.col + 1));
        max = Math.max(max, next);
      }
    }

    return new int[] { start, end };
  }
}
