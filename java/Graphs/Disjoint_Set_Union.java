package java.Graphs;

public class Disjoint_Set_Union {
  int[] parent;
  int[] rank;

  Disjoint_Set_Union(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  void union(int x, int y) {
    int px = find(x);
    int py = find(y);
    if (px == py)
      return;
    if (rank[px] < rank[py]) {
      parent[px] = py;
    } else if (rank[px] > rank[py]) {
      parent[py] = px;
      rank[px]++;
    }
  }
}
