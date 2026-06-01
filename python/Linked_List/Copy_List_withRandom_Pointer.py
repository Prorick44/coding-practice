class Node:
  def __init__(self, val=0, next=None, random=None):
    self.val = val
    self.next = next
    self.random = random

class Solution:
  def copyRandomList(self, head):
    oldToNew = {None: None}

    curr = head 

    while curr:
      oldToNew[curr] = Node(curr.val)
      curr = curr.next 
    
    curr = head 

    while curr:
      copy = oldToNew[curr]
      copy.next = oldToNew[curr.next]
      copy.random = oldToNew[curr.random]
    
    return oldToNew[head]