package main;

import java.beans.Expression;

public class Test4 {
    public static void main(String[] args) {
        int found=0;
        String strin =  "??*3?3=-?545";
        String a=  a(strin); //a
        System.out.println(a);
        String b = b(strin); //b
        String wtf = wtf(strin); //+ - *
        String result = answ(strin); //otvet

        switch (wtf) {
            case "*": {
                for (int i = 0; i < 10; i++) {

                    int a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int result1 = Integer.parseInt(result.replaceAll("\\?", Integer.valueOf(i).toString()));
                    if (a1 * b1 == result1) {
                        found = i;
                        break;
                    }
                }
            }
            case "+":{
                for (int i = 0; i < 10; i++) {

                    int a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int result1 = Integer.parseInt(result.replaceAll("\\?", Integer.valueOf(i).toString()));
                    if (a1 + b1 == result1) {
                        found = i;
                        break;
                    }
                }
            }
            case "-": {
                for (int i = 0; i < 10; i++) {
                    int a1 = Integer.parseInt(a.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int b1 = Integer.parseInt(b.replaceAll("\\?", Integer.valueOf(i).toString()));
                    int result1 = Integer.parseInt(result.replaceAll("\\?", Integer.valueOf(i).toString()));
                    if (a1 - b1 == result1) {
                        found = i;
                        break;
                    }
                }
            }
        }
        System.out.println(found);
    }
    public static int solveExpression( final String expression ) {

        int missingDigit = -1;

        return missingDigit;
    }


    private static String wtf(String str){
        String res = "";
        String[] math = new String[] {"*","+"};
        for (String s: math
                ) { if ((str.contains(s)))
            res = Character.toString(str.charAt(str.indexOf(s)));
        }
        return res;
    }
    private static String answ(String str){
        return   str.substring(str.indexOf("=")+1);
    }
    private static String a(String str){
       String[] f= str.split("^([-]?[a-z \\?])",1);
        System.out.println(f[0]);
       return f[0];
    }
    private static String b(String str){
        return str.substring(str.indexOf(wtf(str))+1,str.indexOf(answ(str))-1);

    }
}
