#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  int largestRectangleArea(vector<int> &heights)
  {
    stack<int> st;
    int maxArea = 0;
    int n = heights.size();

    for (int i = 0; i <= n; i++)
    {
      while (!st.empty() && (i == n || heights[st.top()] >= heights[i]))
      {
        int h = heights[st.top()];
        st.pop();

        int width = st.empty() ? i : i - st.top() - 1;
        maxArea = max(maxArea, h * width);
      }
      st.push(i);
    }
    return maxArea;
  }
};