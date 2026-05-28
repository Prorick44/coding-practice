package java.Heap_Priority_Queue;

import java.util.*;

public class Find_Median_from_Data_Stream {
  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;

  public Find_Median_from_Data_Stream() {
    left = new PriorityQueue<>(Collections.reverseOrder());
    right = new PriorityQueue<>();
  }

  public void addNum(int num) {
    left.offer(num);
    right.offer(left.poll());
    if (left.size() < right.size()) {
      left.offer(right.poll());
    }
  }

  public double findMedian() {
    if (left.size() > right.size()) {
      return left.peek();
    }
    return (left.peek() + right.peek()) / 2.0;
  }
}
