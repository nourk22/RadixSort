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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i = 0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int passes = 1;

    for (int i=0; i<10; i++){
      buckets[i] = new SortableLinkedList();
    }

    for (int i = 0; i<passes; i++){

      for (int j=0; j<data.size(); j++){
        int curr = data.remove(j);

        if (i==0){
          if (passes < length(curr)){
            passes = length(curr);
          }
        }

        int digit = nth(j, curr);
        buckets[digit].add(curr);

      }

      merge(data, buckets);

    }
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
