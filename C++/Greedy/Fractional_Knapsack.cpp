#include <bits/stdc++.h>
using namespace std;

struct Item
{
  int value;
  int weight;
};

class Solution
{
public:
  static bool cmp(Item a, Item b)
  {
    double r1 = (double)a.value / a.weight;
    double r2 = (double)b.value / b.weight;

    return r1 > r2;
  }

  double fractionalKnapsack(int W, Item arr[], int n)
  {
    sort(arr, arr + n, cmp);
    double profit = 0;
    for (int i = 0; i < n; i++)
    {
      if (arr[i].weight <= W)
      {
        profit += arr[i].value;
        W -= arr[i].weight;
      }
      else
      {
        profit += ((double)arr[i].value / arr[i].weight) * W;
        break;
      }
    }
    return profit;
  }
};