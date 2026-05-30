package java.Segment_Tree;

import java.util.*;

public class Count_Smaller_Numbers {
  public List<Integer> countSmaller(int[] nums) {
    int offset = 10000;
    FenwickTree ft = new FenwickTree(20002);
    List<Integer> result = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      result.add(ft.query(nums[i] + offset - 1));
      ft.update(nums[i] + offset, 1);
    }
    Collections.reverse(result);
    return result;
  }
}

class FenwickTree {
  int[] bit;

  FenwickTree(int n) {
    bit = new int[n + 1];
  }

  void update(int index, int delta) {
    index++;
    while (index < bit.length) {
      bit[index] += delta;
      index += index & -index;
    }
  }

  int query(int index) {
    index++;
    int sum = 0;
    while (index > 0) {
      sum += bit[index];
      index -= index & -index;
    }
    return sum;
  }
}
