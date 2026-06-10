#include <bits/stdc++.h>
using namespace std;

void dfsHelper(int node, vector<int> adj[], vector<bool> &visited, vector<int> &dfs)
{
  visited[node] = true;
  dfs.push_back(node);

  for (int neighbor : adj[node])
  {
    if (!visited[neighbor])
      dfsHelper(neighbor, adj, visited, dfs);
  }
}

vector<int> dfsOfGraph(int V, vector<int> adj[])
{
  vector<bool> visited(V, false);
  vector<int> dfs;

  dfsHelper(0, adj, visited, dfs);

  return dfs;
}