def kadane(arr):
  curr = arr[0]
  best = arr[0]

  for i in range(1, len(arr)):
    curr = max(arr[i], curr + arr[i])
    best = max(best, curr)
  
  return best 
