package java.Heap_Priority_Queue;

import java.util.*;

public class Connects_Ropes_Minimum_Cost {
  long minCost(long[] arr, int n) {
    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (long num : arr) {
      pq.offer(num);
    }

    long cost = 0;

    while (pq.size() > 1) {
      long first = pq.poll();
      long second = pq.poll();
      long sum = first + second;
      cost += sum;
      pq.offer(sum);
    }
    return cost;
  }
}
