package java.Segment_Tree;

import java.util.*;

public class Merge_Sort_Tree {
  List<Integer>[] tree;
  int n;

  Merge_Sort_Tree(int[] arr) {
    n = arr.length;
    tree = new ArrayList[4 * n];
    build(arr, 0, 0, n - 1);
  }

  void build(int[] arr, int node, int start, int end) {
    tree[node] = new ArrayList<>();
    if (start == end) {
      tree[node].add(arr[start]);
      return;
    }
    int mid = (start + end) / 2;
    build(arr, 2 * node + 1, start, mid);
    build(arr, 2 * node + 2, mid + 1, end);
    merge(tree[2 * node + 1], tree[2 * node + 2], tree[node]);
  }

  void merge(List<Integer> left, List<Integer> right, List<Integer> result) {
    int i = 0;
    int j = 0;
    while (i < left.size() && j < right.size()) {
      if (left.get(i) <= right.get(j)) {
        result.add(left.get(i++));
      } else {
        result.add(right.get(j++));
      }
    }
    while (i < left.size()) {
      result.add(left.get(i++));
    }
    while (j < right.size()) {
      result.add(right.get(j++));
    }
  }
}