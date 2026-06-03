def hasCycle(V, adj):
  visited = [False] * V 

  def dfs(node, parent):
    visited[node] = True 

    for neighbor in adj[node]:
      if not visited[neighbor]:
        if dfs(neighbor, node):
          return True 
      elif neighbor != parent:
        return True
    
    return False
  
  for i in range(V):
    if not visited[i]:
      if dfs(i, -1):
        return True
      
  return False