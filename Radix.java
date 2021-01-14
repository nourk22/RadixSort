public class Radix{
  public static int nth(int n, int col){
    int digit;
    digit = n / (int)(Math.pow(10, col));
    digit = digit%10;

    return digit;
  }

  public static int length(int n){
    int num_digits;
    if (n==0){
      num_digits = 1;
    }else{
      num_digits = (int)Math.floor(Math.log10(Math.abs(n)))+1;
    }
    return num_digits;
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets){

  }

}
