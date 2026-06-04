class Solution:
  def partition(self, s):
    result = []

    def isPalindrome(sub):
      return sub == sub[::-1]

    def dfs(index, path):
      if index == len(s):
        result.append(path[:])
        return
      
      for i in range(index, len(s)):
        if isPalindrome(s[index:i + 1]):
          dfs(i + 1, path)
          path.pop()
    
    dfs(0, [])
    return result
  
