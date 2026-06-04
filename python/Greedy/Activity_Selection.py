def activitySelection(start, end):
  activities = sorted(zip(start, end), key=lambda x: x[1])

  count = 1 
  prev_end = activities[0][1]

  for s, e in activities[1:]:
    if s >= prev_end:
      count += 1 
      prev_end = e 
  
  return count