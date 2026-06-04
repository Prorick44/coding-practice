def tsp(dist):
  n = len(dist)

  dp = [[float('inf')] * n for _ in range(1 << n)]

  dp[1][0] = 0 

  for mask in range(1 << n):
    for u in range(n):
      if mask & (1 << u):
        for v in range(n):
          if not (mask & (1 << v)):
            new_mask = mask | (1 << v)

            dp[new_mask][v] = min(
              dp[new_mask][v],
              dp[mask][u] + dist[u][v]
            )
  answer = float('inf')

  for i in range(1, n):
    answer = min(
      answer,
      dp[(1 << n) - 1][i] + dist[i][0]
    )
  
  return answer