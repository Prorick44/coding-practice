from collections import deque 

def bfs(graph, start):
  visited = set()
  q = deque([start])

  while q:
    node = q.popleft()

    if node not in visited:
      print(node, end=" ")
      visited.add(node)

      for neighbor in graph[node]:
        if neighbor not in visited:
          q.append(neighbor)
           