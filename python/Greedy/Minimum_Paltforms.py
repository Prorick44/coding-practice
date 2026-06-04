def findPlatform(arr, dep):
  arr.sort()
  dep.sort()

  i = 1 
  j = 0 

  platforms = 1 
  answer = 1 

  while i < len(arr) and j < len(dep):
    if arr[i] <= dep[j]:
      platforms += 1 
      i += 1 
    else:
      platforms -= 1 
      j += 1 

    answer = max(answer, platforms)
  
  return answer