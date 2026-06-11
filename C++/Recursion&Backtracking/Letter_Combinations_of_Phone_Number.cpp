#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  vector<string> mp = {
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  void solve(string digits, int idx, string temp, vector<string> &ans)
  {
    if (idx == digits.size())
    {
      ans.push_back(temp);
      return;
    }
    string letters = mp[digits[idx] - '0'];
    for (char ch : letters)
      solve(digits, idx + 1, temp + ch, ans);
  }
  vector<string> letterCombinations(string digits)
  {
    vector<string> ans;
    if (digits.empty())
      return ans;
    solve(digits, 0, "", ans);
    return ans;
  }
};