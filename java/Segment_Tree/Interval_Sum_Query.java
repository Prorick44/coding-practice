package java.Segment_Tree;

public class Interval_Sum_Query {
  int[] prefix;

  public Interval_Sum_Query(int[] nums) {
    prefix = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    return prefix[right + 1] - prefix[left];
  }
}
