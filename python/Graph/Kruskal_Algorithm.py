class DSU:
  def __init__(self, n):
    self.parent = list(range(n))
  
  def find(self, x):
    if self.parent[x] != x:
      self.parent[x] = self.find(self.parent[x])
    
    return self.parent[x]
  
  def union(self, x, y):
    px = self.find(x)
    py = self.find(y)

    if px != py:
      self.parent[py] = px 

def kruskal(V, edges):
  edges.sort(key=lambda x: x[2])

  dsu = DSU(V)
  mst_weight = 0 

  for u, v, wt in edges:
    if dsu.find(u) != dsu.find(v):
      dsu.union(u, v)
      mst_weight += wt 
  
  return mst_weight
