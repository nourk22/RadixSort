public class Radix{
  public static int nth(int n, int col){
    int digit;
    digit = n / (int)(Math.pow(10, col));
    digit = digit%10;

    return digit;
  }

  public static int length(int n){
    return -1;
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets){

  }

}
