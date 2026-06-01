from collections import deque

class Solution:
  def maxSlidingWindow(self, nums, k):
    q = deque()
    res = []
    for i in range(len(nums)):
      while q and q[0] <= i - k:
        q.popleft()
      q.append(i)
      if i >= k - 1:
        res.append(nums[q[0]])
    return res