def findOdd(arr):
  ans = 0 

  for num in arr:
    ans ^= num 
  
  return ans 
