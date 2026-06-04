import heapq 

class Node:
  def __init__(self, freq, char=None):
    self.freq = freq 
    self.char= char 
    self.left = None 
    self.right = None 

  def __lt__(self, other):
    return self.freq < other.freq 

def huffmanCoding(chars, freq):
  heap = []

  for c, f in zip(chars, freq):
    heapq.heappush(heap, Node(f, c))
  
  while len(heap) > 1:
    left = heapq.heappop(heap)
    right = heapq.heappop(heap)

    parent = Node(left.freq + right.freq)
    parent.left = left 
    parent.right = right 

    heapq.heappush(heap, parent)
  
  root = heap[0]

  codes = {}

  def dfs(node, code):
    if not node:
      return
    
    if node.char is not None:
      codes[node.char] = code 
    
    dfs(node.left, code + "0")
    dfs(node.right, code + "1")

  dfs(root, "")

  return codes 


