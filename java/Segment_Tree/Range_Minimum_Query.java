package java.Segment_Tree;

public class Range_Minimum_Query {
  int[] tree;
  int n;

  Range_Minimum_Query(int[] arr) {
    n = arr.length;
    tree = new int[4 * n];
    build(arr, 0, 0, n - 1);
  }

  void build(int[] arr, int node, int start, int end) {
    if (start == end) {
      tree[node] = arr[start];
      return;
    }
    int mid = (start + end) / 2;
    build(arr, 2 * node + 1, start, mid);
    build(arr, 2 * node + 2, mid + 1, end);
    tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
  }

  int query(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
      return Integer.MAX_VALUE;
    }
    if (left <= start && end <= right) {
      return tree[node];
    }
    int mid = (start + end) / 2;
    return Math.min(query(2 * node + 1, start, mid, left, right), query(2 * node + 1, mid + 1, end, left, right));
  }
}
