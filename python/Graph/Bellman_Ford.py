def bellmanFord(V, edges, src):
  dist = [float('inf')] * V 
  dist[src] = 0 

  for _ in range(V - 1):
    for u, v, wt in edges:
      if dist[u] != float('inf') and dist[u] + wt < dist[v]:
        dist[v] = dist[u] + wt 
  
  return dist