#include <bits/stdc++.h>
using namespace std;

class DisjointSet
{
public:
  vector<int> parent, rank;

  DisjointSet(int n)
  {
    parent.resize(n);
    rank.resize(n, 0);
    for (int i = 0; i < n; i++)
      parent[i] = i;
  }

  int findUPar(int x)
  {
    if (parent[x] != x)
      parent[x] = findUPar(parent[x]);
    return parent[x];
  }

  void unionBySize(int x, int y)
  {
    int parX = findUPar(x);
    int parY = findUPar(y);

    if (rank[parX] < rank[parY])
      parent[parX] = parY;
    else if (rank[parX] > rank[parY])
      parent[parY] = parX;
    else
    {
      parent[parY] = parX;
      rank[parX]++;
    }
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

  DisjointSet ds(V);
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