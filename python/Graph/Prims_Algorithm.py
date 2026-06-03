import heapq

def prim(V, adj):
  visited = [False] * V 

  pq = [(0, 0)]
  mst_weight = 0 

  while pq:
    wt, node = heapq.heappop(pq)

    if visited[node]:
      continue 

    visited[node] = True
    mst_weight += wt 

    for neighbor, edgeWt in adj[node]:
      if not visited[neighbor]:
        heapq.heappush(pq, (edgeWt, neighbor))
  return mst_weight