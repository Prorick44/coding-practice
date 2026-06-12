#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  int tsp(int mask, int pos, vector<vector<int>> &dist, vector<vector<int>> &dp, int n)
  {
    if (mask == (1 << n) - 1)
      return dist[pos][0];

    if (dp[mask][pos] != -1)
      return dp[mask][pos];

    int ans = INT_MAX;

    for (int city = 0; city < n; city++)
    {
      if ((mask & (1 << city)) == 0)
      {
        ans = min(ans, dist[pos][city] + tsp(mask | (1 << city), city, dist, dp, n));
      }
    }
    return dp[mask][pos] = ans;
  }

  int solveTSP(vector<vector<int>> &dist)
  {
    int n = dist.size();

    vector<vector<int>> dp(1 << n, vector<int>(n, -1));

    return tsp(1, 0, dist, dp, n);
  }
};