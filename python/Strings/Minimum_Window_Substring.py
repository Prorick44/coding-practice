from collections import Counter

class Solution:
  def minWindow(self, s, t):
    if not t:
      return ""
    
    need = Counter(t)
    window = {}

    have = 0
    required = len(need)

    left = 0
    res = [-1, -1]
    resLen = float("inf")

    for right in range(len(s)):
      c = s[right]

      window[c] = window.get(c, 0) + 1

      if c in need and window[c] == need[c]:
        have += 1 
      
      while have == required:
        if (right - left + 1) < resLen:
          res = [left, right]
          resLen = right - left + 1 
        
        window[s[left]] -= 1 

        if s[left] in need and window[s[left]] < need[s[left]]:
          have -= 1 
        
        left += 1

    left, right = res 
    return s[left:right + 1] if resLen != float("inf") else ""