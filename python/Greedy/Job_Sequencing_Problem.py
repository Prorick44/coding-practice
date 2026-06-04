def jobScheduling(jobs):
  jobs.sort(key=lambda x: x[2], reverse=True)

  max_deadline = max(job[1] for job in jobs)

  slots = [-1] * (max_deadline + 1)

  count = 0 
  profit = 0 

  for job_id, deadline, gain in jobs:
    for j in range(deadline, 0, -1):
      if slots[j] == -1:
        slots[j] = job_id
        count += 1 
        profit += gain 
        break
  
  return [count, profit]
