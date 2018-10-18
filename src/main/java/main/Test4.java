package main;


public class Test4 {
    public static void main(String[] args) {

        System.out.println(solveExpression("?0?+??=?60"));
           }

    public static int solveExpression( final String expression ) {
        int missingDigit = -1;
        int a1,b1,result1,inxexb;
        String a,op;

        String res=expression.substring(expression.indexOf("=")+1);
        String f[] = expression.split("");
        a = f[0];
        int i = 1;
        while (true) {
            if (f[i].equals("-") || f[i].equals("*") || f[i].equals("+")) {
                op = f[i];
                inxexb= i;
                    break;
            }
            a += f[i];
            i++;
        }
        String b;
        try {
            b = expression.substring(inxexb+1,expression.indexOf("="));
        } catch (Exception e) {
            return missingDigit;
        }
        int start = 0;
        if (b.startsWith("??")||a.startsWith("??")||res.startsWith("??"))
            start++;
         switch (op) {

             case "*": {
                 for (int j=start; j < 10; j++) {

                     try {
                         a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(j).toString()));
                         b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(j).toString()));
                         result1 = Integer.parseInt(res.replaceAll("\\?", Integer.valueOf(j).toString()));
                     } catch (NumberFormatException e) {
                         return missingDigit;
                     }
                     if (a1 * b1 == result1&&(!expression.contains(Integer.valueOf(j).toString()))) {
                         missingDigit = j;
                         break;
                     }
                 }
                 break;
             }
             case "+": {
                 for (int j = start; j < 10; j++) {
                     try {
                         a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(j).toString()));
                         b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(j).toString()));
                         result1 = Integer.parseInt(res.replaceAll("\\?", Integer.valueOf(j).toString()));
                     } catch (NumberFormatException e) {
                         return missingDigit;
                     }
                     if ((a1 + b1 == result1)&&(!expression.contains(Integer.valueOf(j).toString()))) {
                         missingDigit = j;
                         break;
                     }
                 }
                 break;
             }
             case "-": {
                 for (int j = start; j < 10; j++) {
                     try {
                         a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(j).toString()));
                         b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(j).toString()));
                         result1 = Integer.parseInt(res.replaceAll("\\?", Integer.valueOf(j).toString()));
                     } catch (NumberFormatException e) {
                         return -1;
                     }
                     if (a1 - b1 == result1&&(!expression.contains(Integer.valueOf(j).toString()))) {
                         missingDigit = j;
                         break;
                     }
                 }
                 break;
             }
         }
        return missingDigit;
    }


}
