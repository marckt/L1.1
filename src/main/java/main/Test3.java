package main;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(listSquared(5,7));
    }
    public static String listSquared(long m, long n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder("[");
        for (long i = m; i <=n ; i++) {
            for (long j = 1; j <=i ; j++) {
                if (i%j==0) {
                    sum+=j*j;
                }
           }
          if (Math.sqrt(sum)%1==0)
              sb.append("[" + i + ", " + sum + "], ");
            sum=0;
        }
return sb.length()>1?sb.replace(sb.length()-2,sb.length(),"]").toString():"[]";
    }
}
