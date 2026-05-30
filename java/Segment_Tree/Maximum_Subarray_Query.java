package java.Segment_Tree;

class Node {
  int sum;
  int prefix;
  int suffix;
  int max;

  Node(int sum, int prefix, int suffix, int max) {
    this.sum = sum;
    this.prefix = prefix;
    this.suffix = suffix;
    this.max = max;
  }
}

public class Maximum_Subarray_Query {
  Node[] tree;
  int n;

  Maximum_Subarray_Query(int[] arr) {
    n = arr.length;
    tree = new Node[4 * n];
    build(arr, 0, 0, n - 1);
  }

  void build(int[] arr, int node, int start, int end) {
    if (start == end) {
      int val = arr[start];
      tree[node] = new Node(val, val, val, val);
      return;
    }
    int mid = (start + end) / 2;
    build(arr, 2 * node + 1, start, mid);
    build(arr, 2 * node + 2, mid + 1, end);
    tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
  }

  Node merge(Node left, Node right) {
    int sum = left.sum + right.sum;
    int prefix = Math.max(left.prefix, left.sum + right.prefix);
    int suffix = Math.max(right.suffix, right.sum + left.suffix);
    int max = Math.max(Math.max(left.max, right.max), left.suffix + right.prefix);

    return new Node(sum, prefix, suffix, max);
  }
}
