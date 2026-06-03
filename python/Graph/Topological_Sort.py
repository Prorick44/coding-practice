from collections import deque 

def topoSort(V, adj):
  indegree = [0] * V 

  for u in range(V):
    for v in adj[u]:
      indegree[v] += 1

  q = deque()

  for i in range(V):
    if indegree[i] == 0:
      q.append(i)
  
  result = []

  while q:
    node = q.popleft()
    result.append(node)

    for neighbor in adj[node]:
      indegree[neighbor] -= 1 

      if indegree[neighbor] == 0:
        q.append(neighbor)
  
  return result