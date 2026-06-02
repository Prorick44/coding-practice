from collections import defaultdict, deque 

class Solution:
  def verticalTraversal(self, root):
    mp = defaultdict(list)

    q = deque([(root, 0)])

    while q:
      node, col = q.popleft()

      if node:
        mp[col].append(node.val)

        q.append((node.left, col - 1))
        q.append((node.right, col + 1))
    
    result = []

    for col in sorted(mp.keys()):
      result.append(mp[col])

    return result