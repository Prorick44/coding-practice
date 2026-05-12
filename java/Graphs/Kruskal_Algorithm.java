package java.Graphs;

import java.util.*;

class Edge {
  int u;
  int v;
  int wt;

  Edge(int u, int v, int wt) {
    this.u = u;
    this.v = v;
    this.wt = wt;
  }
}

class DSU {
  int[] parent;

  DSU(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  int find(int x) {
    if (parent[x] == x)
      return x;
    return parent[x] = find(parent[x]);
  }

  void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}

public class Kruskal_Algorithm {
  public int kruskal(int V, List<Edge> edges) {
    Collections.sort(edges, (a, b) -> a.wt - b.wt);
    DSU dsu = new DSU(V);
    int mstWeight = 0;
    for (Edge edge : edges) {
      if (dsu.find(edge.u) != dsu.find(edge.v)) {
        mstWeight += edge.wt;
        dsu.union(edge.u, edge.v);
      }
    }
    return mstWeight;
  }
}
