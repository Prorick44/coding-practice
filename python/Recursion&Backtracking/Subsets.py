class Solution:
  def subsets(self, nums):
    result = []

    def backtrack(index, subset):
      if index == len(nums):
        result.append(subset[:])
        return
      
      subset.append(nums[index])
      backtrack(index + 1, subset)
    
    backtrack(0, [])
    return result