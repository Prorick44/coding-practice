class Solution:
  def divide(self, dividend, divisor):
    MAX_INT = 2**31 - 1 
    MIN_INT = -2**31

    if dividend == MIN_INT and divisor == -1:
      return MAX_INT
    
    sign = -1 if (dividend < 0) ^ (divisor < 0) else 1

    dividend = abs(dividend)
    divisor = abs(divisor)

    quotient = 0 

    while dividend >= divisor:
      temp = divisor
      multiple = 1 

      while dividend >= (temp << 1):
        temp <<= 1 
        multiple <<= 1 
      
      dividend -= temp 
      quotient += multiple
    
    return sign * quotient