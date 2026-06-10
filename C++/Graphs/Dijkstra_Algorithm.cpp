#include <bits/stdc++.h>
using namespace std;

vector<int> dijkstra(int V, vector<vector<int>> adj[], int S)
{
  priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

  vector<int> dist(V, INT_MAX);

  dist[S] = 0;
  pq.push({0, S});

  while (!pq.empty())
  {
    int d = pq.top().first;
    int node = pq.top().second;
    pq.pop();

    for (auto it : adj[node])
    {
      int adjNode = it[0];
      int wt = it[1];

      if (d + wt < dist[adjNode])
      {
        dist[adjNode] = d + wt;
        pq.push({dist[adjNode], adjNode});
      }
    }
  }
  return dist;
}