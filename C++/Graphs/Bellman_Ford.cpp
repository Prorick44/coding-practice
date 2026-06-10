#include <bits/stdc++.h>
using namespace std;

vector<int> bellman_ford(int V, vector<vector<int>> &edges, int S)
{
  vector<int> dist(V, 1e8);
  dist[S] = 0;

  for (int i = 0; i < V - 1; i++)
  {
    for (auto edge : edges)
    {
      int u = edge[0];
      int v = edge[1];
      int wt = edge[2];

      if (dist[u] != 1e8 && dist[u] + wt < dist[v])
        dist[v] = dist[u] + wt;
    }
  }
  return dist;
}