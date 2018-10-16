package main;
import java.util.*;

/*------- ------- -------
|     | | ABC | | DEF |
|  1  | |  2  | |  3  |
------- ------- -------
------- ------- -------
| GHI | | JKL | | MNO |
|  4  | |  5  | |  6  |
------- ------- -------
------- ------- -------
|PQRS | | TUV | | WXYZ|
|  7  | |  8  | |  9  |
------- ------- -------
------- ------- -------
|     | |space| |     |
|  *  | |  0  | |  #  |
------- ------- -------*/
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(presses("z"));
        System.out.println(" 30:85:a9:af:0b:73".replaceAll(":", "").toUpperCase());

    }

    public static int presses(String phrase) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz #*1".split("");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < alphabet.length-1; i += 3) {
                hashMap.put(alphabet[i], 1);
                hashMap.put(alphabet[i + 1], 2);
                hashMap.put(alphabet[i + 2], 3);
            if (i==15|| i ==22) {
               hashMap.put(alphabet[i + 3], 4);
                i++;
            }
        }
        String [] one = {" ", "#","*","1"};
        for (int i = 0; i <one.length ; i++) {
            hashMap.put(one[i],1);
        }

     hashMap.put(alphabet[24],3);
     hashMap.put(alphabet[25],4);

     hashMap.put("0",2);
        for (int i = 2; i <=6 ; i++) {
            hashMap.put(Integer.toString(i),4);
        }
        hashMap.put("7",5);
        hashMap.put("8",4);
        hashMap.put("9",5);

        int sum =0;
        String [] res = phrase.split("");
        for (int i = 0; i <res.length ; i++) {
            for (Map.Entry entry : hashMap.entrySet()) {
                              if (entry.getKey().toString().equalsIgnoreCase((res[i])))
                    sum+=Integer.parseInt(entry.getValue().toString());
            }
        }
        return sum;
    }
}

