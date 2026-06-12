#include <bits/stdc++.h>
using namespace std;

void swapNumbers(int &a, int &b)
{
  a ^= b;
  b ^= a;
  a ^= b;
}