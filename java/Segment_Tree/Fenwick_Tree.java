package java.Segment_Tree;

public class Fenwick_Tree {
  int[] bit;
  int n;

  Fenwick_Tree(int n) {
    this.n = n;
    bit = new int[n + 1];
  }

  void update(int index, int delta) {
    index++;
    while (index <= n) {
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

  int rangeQuery(int left, int right) {
    return query(right) - query(left - 1);
  }
}
