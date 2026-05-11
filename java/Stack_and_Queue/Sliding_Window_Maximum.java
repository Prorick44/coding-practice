package java.Stack_and_Queue;

import java.util.*;

public class Sliding_Window_Maximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        result[index++] = nums[deque.peekFirst()];
      }
    }
    return result;
  }
}
