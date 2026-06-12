#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  int activitySelection(vector<int> start, vector<int> end, int n)
  {
    vector<pair<int, int>> activities;

    for (int i = 0; i < n; i++)
      activities.push_back({end[i], start[i]});

    sort(activities.begin(), activities.end());

    int count = 1;
    int lastEnd = activities[0].first;

    for (int i = 1; i < n; i++)
    {
      if (activities[i].second > lastEnd)
      {
        count++;
        lastEnd = activities[i].first;
      }
    }
    return count;
  }
};