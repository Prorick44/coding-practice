package java.Heap_Priority_Queue;

import java.util.*;

public class Median_Finder {
  PriorityQueue<Integer> small;
  PriorityQueue<Integer> large;

  public Median_Finder() {
    small = new PriorityQueue<>(Collections.reverseOrder());
    large = new PriorityQueue<>();
  }

  public void addNum(int num) {
    small.offer(num);
    large.offer(small.poll());
    if (small.size() < large.size()) {
      small.offer(large.poll());
    }
  }

  public double findMedian() {
    if (small.size() > large.size()) {
      return small.peek();
    }
    return (small.peek() + large.peek()) / 2.0;
  }
}
