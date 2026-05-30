package java.Segment_Tree;

public class XOR_Segment_Tree {
  int[] tree;
  int n;

  XOR_Segment_Tree(int[] arr) {
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
    tree[node] = tree[2 * node + 1] ^ tree[2 * node + 2];
  }

  int query(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
      return 0;
    }
    if (left <= start && end <= right) {
      return tree[node];
    }
    int mid = (start + end) / 2;
    return query(2 * node + 1, start, end, left, right) ^ query(2 * node + 2, mid + 1, end, left, right);
  }
}
