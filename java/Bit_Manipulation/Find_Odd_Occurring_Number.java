package java.Bit_Manipulation;

public class Find_Odd_Occurring_Number {
  public int findOdd(int[] arr) {
    int xor = 0;
    for (int num : arr) {
      xor ^= num;
    }
    return xor;
  }
}
