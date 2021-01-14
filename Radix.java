public class Radix{
  public static int nth(int n, int col){
    int digit;
    digit = Math.abs(n / (int)(Math.pow(10, col)));
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

  public static void main(String[] args){
    System.out.println("TESTING NTH");
    System.out.println();
    System.out.println(nth(123, 1)==2);
    System.out.println(nth(-123, 1)==2);
    System.out.println(nth(123, 2)==1);
    System.out.println(nth(-123,2)==1);

    System.out.println();
    System.out.println();

    System.out.println("TESTING LENGTH");
    System.out.println();
    System.out.println(length(0)==1);
    System.out.println(length(15)==2);
    System.out.println(length(-10)==2);
    System.out.println(length(5112)==4);
  }

}
