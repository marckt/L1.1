package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

import java.awt.*;
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
        System.out.println(presses("LOL"));

    }


    public static int presses(String phrase) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabetChar = alphabet.toCharArray();
        char[] chNums = phrase.toLowerCase().toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < alphabetChar.length-1; i += 3) {
            if (i==15) {
                hashMap.put(alphabetChar[i], 1);
                hashMap.put(alphabetChar[i + 1], 2);
                hashMap.put(alphabetChar[i + 2], 3);
                hashMap.put(alphabetChar[i + 3], 4);
             i++;
            }

            else {
                hashMap.put(alphabetChar[i], 1);
                hashMap.put(alphabetChar[i + 1], 2);
                hashMap.put(alphabetChar[i + 2], 3);
            }
        }
     hashMap.put(alphabetChar[24],3);
     hashMap.put(alphabetChar[25],4);
     hashMap.put(' ',1);
        for (int i = 1; i <9 ; i++) {
            hashMap.put()

        }

        int sum =0;
        char [] res = phrase.toCharArray();
        for (int i = 0; i <res.length ; i++) {
            for (Map.Entry entry : hashMap.entrySet()) {
                              if (entry.getKey().toString().equalsIgnoreCase(Character.toString(res[i])))
                    sum+=Integer.parseInt(entry.getValue().toString());
            }
        }

        return sum;
    }
}

