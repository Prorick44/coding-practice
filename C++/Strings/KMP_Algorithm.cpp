#include <bits/stdc++.h>
using namespace std;

vector<int> computeLPS(string pattern)
{
  int n = pattern.size();
  vector<int> lps(n, 0);

  int len = 0, i = 1;

  while (i < n)
  {
    if (pattern[i] == pattern[len])
    {
      len++;
      lps[i] = len;
      i++;
    }
    else
    {
      if (len != 0)
        len = lps[len - 1];
      else
        i++;
    }
  }
  return lps;
}

int KMP(string text, string pattern)
{
  vector<int> lps = computeLPS(pattern);

  int i = 0, j = 0;

  while (i < text.size())
  {
    if (text[i] == pattern[j])
    {
      i++;
      j++;
    }

    if (j == pattern.size())
      return i - j;

    else if (i < text.size() && text[i] != pattern[j])
    {
      if (j != 0)
        j = lps[j - 1];
      else
        i++;
    }
  }
  return -1;
}