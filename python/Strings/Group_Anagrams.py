from collections import defaultdict

class Solution:
  def groupAnagraams(self, strs):
    mp = defaultdict(list)

    for word in strs:
      key = ''.join(sorted(word))
      mp[key].append(word)
    
    return list(mp.values())
  