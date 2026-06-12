#include <bits/stdc++.h>
using namespace std;

int findOdd(vector<int> &nums)
{
  int ans = 0;

  for (int num : nums)
    ans ^= num;

  return ans;
}