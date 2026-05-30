package java.Segment_Tree;

public class Range_Sum_Query {
  int[] tree;
  int n;

  public Range_Sum_Query(int[] nums) {
    n = nums.length;
    tree = new int[4 * n];
    build(nums, 0, 0, n - 1);
  }

  void build(int[] nums, int node, int start, int end) {
    if (start == end) {
      tree[node] = nums[start];
      return;
    }
    int mid = (start + end) / 2;
    build(nums, 2 * node + 1, start, mid);
    build(nums, 2 * node + 2, mid + 1, end);
    tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
  }

  public int sumRange(int left, int right) {
    return query(0, 0, n - 1, left, right);
  }

  int query(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
      return 0;
    }
    if (left <= start && end <= right) {
      return tree[node];
    }
    int mid = (start + end) / 2;
    return query(2 * node + 1, start, mid, left, right) + query(2 * node + 2, mid + 1, end, left, right);
  }
}
