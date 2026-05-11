package java.Stack_and_Queue;

import java.util.*;

public class Next_Greatr_Element {
  public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i]);
    }
    return result;
  }
}
