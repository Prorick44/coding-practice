#include <bits/stdc++.h>
using namespace std;

int rabinKarp(string text, string pattern)
{
  int n = text.size(), m = pattern.size();

  int d = 256, q = 101;
  int h = 1, p = 0, t = 0;

  for (int i = 0; i < m - 1; i++)
    h = (h * d) % q;

  for (int i = 0; i < m; i++)
  {
    p = (d * p + pattern[i]) % q;
    t = (d * t + text[i]) % q;
  }

  for (int i = 0; i <= n - m; i++)
  {
    if (p == t)
    {
      int j;
      for (j = 0; j < m; j++)
        if (text[i + j] != pattern[j])
          break;

      if (j == m)
        return i;
    }
    if (i < n - m)
    {
      t = (d * (t - text[i] * h) + text[i + m]) % q;

      if (t < 0)
        t += q;
    }
  }
  return -1;
}