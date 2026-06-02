class TreeNode:
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right


def search(root, key):
  if not root or root.val == key:
    return root
  
  if key < root.val:
    return search(root.left, key)

  return search(root.right, key)

def insert(root, key):
  if not root:
    return TreeNode(key)
  
  if key < root.val:
    root.left = insert(root.left, key)
  else:
    root.right = insert(root.right, key)
  return root

def delete(root, key):
  if not root:
    return None 
  
  if key < root.val:
    root.left = delete(root.left, key)
  
  elif key > root.val:
    root.right = delete(root.right, key)
  
  else:
    if not root.left:
      return root.right
    if not root.right:
      return root.left
    temp = root.right
    while temp.left:
      temp = temp.left
    root.val = temp.val
    root.right = delete(root.right, temp.val)
    
  return root