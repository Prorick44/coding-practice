package java.Heap_Priority_Queue;

import java.util.*;

public class K_Closest_Points_to_Origin {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

    for (int[] point : points) {
      pq.offer(point);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll();
    }

    return result;
  }

  int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}
