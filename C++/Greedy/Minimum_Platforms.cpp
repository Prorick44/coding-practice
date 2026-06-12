#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  int findPlatform(int arr[], int dep[], int n)
  {
    sort(arr, arr + n);
    sort(dep, dep + n);

    int i = 1, j = 0;
    int platforms = 1, result = 1;

    while (i < n && j < n)
    {
      if (arr[i] <= dep[j])
      {
        platforms++;
        i++;
      }
      else
      {
        platforms--;
        j++;
      }
      result = max(result, platforms);
    }
    return result;
  }
};