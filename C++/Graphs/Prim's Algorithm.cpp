#include <bits/stdc++.h>
using namespace std;

int spanningTree(int V, vector<vector<int>> adj[])
{
  priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

  vector<int> visited(V, 0);

  pq.push({0, 0});
  int sum = 0;

  while (!pq.empty())
  {
    auto it = pq.top();
    pq.pop();

    int wt = it.first;
    int node = it.second;

    if (visited[node])
      continue;

    visited[node] = 1;
    sum += wt;

    for (auto neighbor : adj[node])
    {
      int adjNode = neighbor[0];
      int edgeWt = neighbor[1];

      if (!visited[adjNode])
        pq.push({edgeWt, adjNode});
    }
  }
  return sum;
}