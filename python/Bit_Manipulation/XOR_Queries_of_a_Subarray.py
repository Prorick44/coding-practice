class Solution:
  def xorQueries(self, arr, queries):
    prefix = [0]

    for num in arr:
      prefix.append(prefix[-1] ^ num)
    
    result = []

    for left, right in queries:
      result.append(prefix[right + 1] ^ prefix[left])
    
    return result