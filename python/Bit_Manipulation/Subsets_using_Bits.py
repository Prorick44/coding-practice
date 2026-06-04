def subsets(nums):
  n = len(nums)

  result = []

  for mask in range(1 << n):
    curr = []

    for i in range(n):
      if mask & (1 << i):
        curr.append(nums[i])
    
    result.append(curr)
  
  return result