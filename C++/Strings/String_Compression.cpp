#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  int compress(vector<char> &chars)
  {
    int index = 0, i = 0;

    while (i < chars.size())
    {
      char curr = chars[i];
      int cnt = 0;

      while (i < chars.size() && chars[i] == curr)
      {
        cnt++;
        i++;
      }

      chars[index++] = curr;

      if (cnt > 1)
      {
        string s = to_string(cnt);
        for (char c : s)
          chars[index++] = c;
      }
    }
    return index;
  }
};