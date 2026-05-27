package java.Bit_Manipulation;

public class Swap_Without_Temp {
  public void swap(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
}
