package java.Bit_Manipulation;

public class Bitmasking_DP {
  int[][] dp;

  public int tsp(int[][] graph) {
    int n = graph.length;
    dp = new int[1 << n][n];
    for (int[] row : dp) {
      java.util.Arrays.fill(row, -1);
    }
    return solve(1, 0, graph, n);
  }

  int solve(int mask, int pos, int[][] graph, int n) {
    if (mask == (1 << n) - 1) {
      return graph[pos][0];
    }
    if (dp[mask][pos] != -1) {
      return dp[mask][pos];
    }

    int ans = Integer.MAX_VALUE;

    for (int city = 0; city < n; city++) {
      if ((mask & (1 << city)) == 0) {
        int newAns = graph[pos][city] + solve(mask | (1 << city), city, graph, n);
        ans = Math.min(ans, newAns);
      }
    }
    return dp[mask][pos] = ans;
  }
}
