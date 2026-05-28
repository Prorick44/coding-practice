package java.Heap_Priority_Queue;

import java.util.*;

public class Kth_Largest_Element {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }
}
