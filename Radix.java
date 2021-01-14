public class Radix{
  public static int nth(int n, int col){
    return Math.abs(n / (int)(Math.pow(10, col)))%10;
  }

  public static int length(int n){
    if (n==0){
      return 1;
    }else{
      return (int)Math.floor(Math.log10(Math.abs(n)))+1;
    }
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

      while (data.size() > 0){
        int curr = data.remove(0);

        if (i==0){
          if (passes < length(curr)){
            passes = length(curr);
          }
        }

        int digit = nth(curr, i);

        if (curr<0){
          buckets[9-digit].add(curr);
        }else{
          buckets[digit].add(curr);
        }

      }

      merge(data, buckets);

    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList neg = new SortableLinkedList();
    SortableLinkedList pos = new SortableLinkedList();

    while (data.size()>0){
      int curr = data.remove(0);
      if (curr>=0){
        pos.add(curr);
      }else{
        neg.add(curr);
      }
    }

    radixSortSimple(pos);
    radixSortSimple(neg);


    neg.extend(pos);
    data.extend(neg);

  }

  public static void main(String[] args){
  //  System.out.println("TESTING NTH");
  //  System.out.println();
  //  System.out.println(nth(123, 1)==2);
  //  System.out.println(nth(-123, 1)==2);
  //  System.out.println(nth(123, 2)==1);
  //  System.out.println(nth(-123,2)==1);
  //  System.out.println(nth(198, 3));

  //  System.out.println();
  //  System.out.println();

  /*  System.out.println("TESTING LENGTH");
    System.out.println();
    System.out.println(length(0)==1);
    System.out.println(length(15)==2);
    System.out.println(length(-10)==2);
    System.out.println(length(5112)==4);
    */

  /*  SortableLinkedList test = new SortableLinkedList();
    test.add(10);
    test.add(-10);
    test.add(2);
    test.add(-3);
    test.add(5);
    test.add(-4);
    test.add(3);
    test.add(-5);
    test.add(4);
    test.add(-2);
    test.add(0);
    test.add(101);
    test.add(-101);
    test.add(11);
    test.add(-14);
    test.add(23);
    test.add(-34932);

    radixSort(test);
    System.out.println(test);
  */
  }

}
