#include <bits/stdc++.h>
using namespace std;

// Disjoint Set (Union-Find) implementation
class DisjointSet
{
public:
  vector<int> parent, sz;
  DisjointSet(int n)
  {
    parent.resize(n + 1);
    sz.resize(n + 1, 1);
    for (int i = 0; i <= n; ++i)
      parent[i] = i;
  }
  int findUPar(int node)
  {
    if (parent[node] == node)
      return node;
    return parent[node] = findUPar(parent[node]);
  }
  void unionBySize(int u, int v)
  {
    int pu = findUPar(u);
    int pv = findUPar(v);
    if (pu == pv)
      return;
    if (sz[pu] < sz[pv])
      swap(pu, pv);
    parent[pv] = pu;
    sz[pu] += sz[pv];
  }
};

int spanningTree(int V, vector<vector<int>> adj[])
{
  vector<pair<int, pair<int, int>>> edges;

  for (int i = 0; i < V; i++)
  {
    for (auto it : adj[i])
    {
      int adjNode = it[0];
      int wt = it[1];

      edges.push_back({wt, {i, adjNode}});
    }
  }

  sort(edges.begin(), edges.end());

  DisjointSet ds(V - 1);
  int mstWt = 0;

  for (auto it : edges)
  {
    int wt = it.first;
    int u = it.second.first;
    int v = it.second.second;

    if (ds.findUPar(u) != ds.findUPar(v))
    {
      mstWt += wt;
      ds.unionBySize(u, v);
    }
  }

  return mstWt;
}