import heapq 

def dijkstra(V, adj, src):
  dist = [float('inf')] * V 
  dist[src] = 0 

  pq = [(0, src)]

  while pq:
    d, node = heapq.heappop(pq)

    if d > dist[node]:
      continue 

    for neighbor, weight in adj[node]:
      if dist[node] + weight < dist[neighbor]:
        dist[neighbor] = dist[node] + weight
        heapq.heappush(pq, (dist[neighbor], neighbor))
  
  return dist