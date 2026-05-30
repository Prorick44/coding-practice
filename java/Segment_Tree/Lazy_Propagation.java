package java.Segment_Tree;

public class Lazy_Propagation {
  int[] tree;
  int[] lazy;
  int n;

  Lazy_Propagation(int[] arr) {
    n = arr.length;
    tree = new int[4 * n];
    lazy = new int[4 * n];
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
    tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
  }

  void update(int node, int start, int end, int left, int right, int val) {
    if (lazy[node] != 0) {
      tree[node] += (end - start + 1) * lazy[node];
      if (start != end) {
        lazy[2 * node + 1] = lazy[node];
        lazy[2 * node + 1] = lazy[node];
      }
      lazy[node] = 0;
    }

    if (right < start || end < left) {
      return;
    }

    if (left <= start && end <= right) {
      tree[node] += (end - start + 1) * val;

      if (start != end) {
        lazy[2 * node + 1] += val;
        lazy[2 * node + 2] += val;
      }
      return;
    }
    int mid = (start + end) / 2;
    update(2 * node + 1, start, mid, left, right, val);
    update(2 * node + 2, mid + 1, end, left, right, val);
    tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
  }

  int query(int node, int start, int end, int left, int right) {
    if (lazy[node] != 0) {
      tree[node] += (end - start + 1) * lazy[node];
      if (start != end) {
        lazy[2 * node + 1] += lazy[node];
        lazy[2 * node + 2] += lazy[node];
      }
      lazy[node] = 0;
    }
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
