class Solution:
  def missingNumber(Self, nums):
    ans = len(nums)

    for i in range(len(nums)):
      ans ^= i ^ nums[i]
    
    return ans 
  