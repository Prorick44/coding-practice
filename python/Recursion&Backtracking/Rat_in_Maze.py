def findPath(m, n):
  result = []

  visited = [[False] * n for _ in range(n)]

  def dfs(i, j, path):
    if i == n - 1 and j == n - 1:
      result.append(path)
      return
    
    directions = [
      (1, 0, "D"),
      (0, -1, "L"),
      (0, 1, "R"),
      (-1, 0, "U")
    ]

    for dx, dy, move in directions:
      x = i + dx 
      y = j + dy 

      if (
        0 <= x < n
        and 0 <= y < n
        and not visited[x][y]
        and m[x][y] == 1
      ):
        visited[x][y] = True
        dfs(x, y, path + move)
        visited[x][y] = False

  if m[0][0] == 1:
    visited[0][0] = True
    dfs(0, 0, "")

  return result