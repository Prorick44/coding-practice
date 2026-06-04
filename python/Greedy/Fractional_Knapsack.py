def fractionalKnapsack(capacity, items):
  items.sort(key=lambda x: x[1] / x[0], reverse = True)

  total = 0 

  for weight, value in items:
    if capacity >= weight:
      total += value 
      capacity -= weight 
    else:
      total += value * (capacity / weight)
      break 

  return total