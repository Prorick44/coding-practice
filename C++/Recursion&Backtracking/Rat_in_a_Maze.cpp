#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  void solve(int i, int j, vector<vector<int>> &m, int n, string path, vector<string> &ans, vector<vector<int>> &vis)
  {
    if (i == n - 1 && j == n - 1)
    {
      ans.push_back(path);
      return;
    }

    string dir = "DLRU";
    int di[] = {1, 0, 0, -1};
    int dj[] = {0, -1, 1, 0};

    for (int k = 0; k < 4; k++)
    {
      int ni = i + di[k];
      int nj = j + dj[k];

      if (ni >= 0 && nj >= 0 && ni < n && nj < n && !vis[ni][nj] && m[ni][nj] == 1)
      {
        vis[i][j] = 1;
        solve(ni, nj, m, n, path + dir[k], ans, vis);
        vis[i][j] = 0;
      }
    }
  }
  vector<string> findPath(vector<vector<int>> &m, int n)
  {
    vector<string> ans;

    if (m[0][0] == 0)
      return ans;

    vector<vector<int>> vis(n, vector<int>(n, 0));

    solve(0, 0, m, n, "", ans, vis);

    return ans;
  }
};
