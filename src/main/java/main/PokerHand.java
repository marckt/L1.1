package main;

import java.util.*;

public class PokerHand {
    private boolean isFlashStreigth;
    private boolean isFlash;
    private boolean isStreight;
    private boolean isKare;
    private boolean isRoyal;
    private int score;
    private int pairMax;
    private StringBuilder sb = new StringBuilder();


    private String thisString = "";
    final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    final String mast = "SHDC";
    private int[] intsorted = new int[5];

    public enum Result {TIE, WIN, LOSS}

    PokerHand(String hand) {
        this.thisString = hand;
    }

    public String[] getString() {
        return thisString.split(" ");
    }

    public void cardsint() {
        for (int i = 0; i < intsorted.length; i++) {
            intsorted[i] = Integer.parseInt(getString()[i]
                    .replaceAll("T", "10")
                    .replaceAll("J", "11")
                    .replaceAll("Q", "12")
                    .replaceAll("K", "13")
                    .replaceAll("A", "14")
                    .replaceAll("S", "")
                    .replaceAll("H", "")
                    .replaceAll("D", "")
                    .replaceAll("C", ""));
        }
        Arrays.sort(intsorted);
        for (int i = 0; i < intsorted.length; i++) {
            sb.append(intsorted[i]);
        }
    }

    public boolean isFlashStreight() {
        return isFlash() && isStreight() && !isRoyal;
    }

    public boolean isFlashStreightRoyal() {
        return isFlash() && isStreight() && isRoyal;
    }

    public boolean isStreight() {
        cardsint();

        String cards1 = "234567891011121314";
        if (cards1.contains(sb.toString()) || sb.toString().equals("234514")) {
            if (sb.toString().equals("1011121314"))
                isRoyal = true;
        isStreight = true;
        }
        sb.setLength(0);
        return isStreight;

    }

    public boolean isFlash() {
        int res = 0;
        for (int i = 0; i < getString().length - 1; i++) {
            if (getString()[0].substring(1, 2).equals(getString()[i + 1].substring(1, 2))) {
                res++;
            }
        }
        return res == 4;
    }

    public int highCard() {
        cardsint();
        sb.setLength(0);
        return intsorted[4];
    }    public int tirdCard() {
        cardsint();
        sb.setLength(0);
        return intsorted[3];
    }
    private boolean isTwo() {
        cardsint();
        sb.setLength(0);
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i <intsorted.length ; i++) {
            used.add(intsorted[i]);
        }
        return used.size()<=3;
    }

    public boolean isKare() {
        cardsint();
        return ((intsorted[0] == intsorted[1]) && (intsorted[2] == intsorted[3]) && (intsorted[0] == intsorted[3]));
    }

    public boolean isFullhouse() {
        cardsint();
        sb.setLength(0);
        if ((intsorted[0] == intsorted[1]) && (intsorted[3] == intsorted[4])) {
            if ((intsorted[2] == intsorted[1])) {
                pairMax = intsorted[4];
                return true;
            }
            if (intsorted[2] == intsorted[4]) {
                pairMax = intsorted[0];
                return true;
            } else return false;
        } else return false;
    }
    public boolean isThree() {
        cardsint();
        sb.setLength(0);
        boolean first =((intsorted[0] == intsorted[1])&&(intsorted[0]==intsorted[2]));
        boolean last = intsorted[2]==intsorted[3]&& intsorted[3] == intsorted[4];
        if (first) {
            pairMax = intsorted[4];
            return true;
        }
        if (last) {
            pairMax = intsorted[1];
            return true;
        }
        else return false;
    }

    public Result compareWith(PokerHand hand) {
        if (isFlashStreightRoyal() && hand.isFlashStreightRoyal()) //flashRoyal
            return Result.TIE;
        if (isFlashStreight() && hand.isFlashStreight()) //flashstreight
        {
            if (highCard() > hand.highCard()) {
                return Result.WIN;
            } else if (highCard() == hand.highCard())
                return Result.TIE;
            else return Result.LOSS;
        }
        if (isKare() && hand.isKare()) {                //Kare
            if (intsorted[1] > hand.intsorted[1]) {
                return Result.WIN;
            } else if (highCard() == hand.highCard())
                return Result.TIE;
            else return Result.LOSS;
        }
        if (isFullhouse() && hand.isFullhouse()) {       //fullhuose
            if (intsorted[2] > hand.intsorted[2])
                return Result.WIN;
            if (intsorted[2] == hand.intsorted[2])
                return pairMax > hand.pairMax ? Result.WIN : Result.LOSS;
            else return Result.LOSS;
        }

        if (isFlash() && hand.isFlash()) { //Flash
            if (highCard() > hand.highCard()) {
                return Result.WIN;
            } else if (highCard() == hand.highCard())
                return Result.TIE;
            else return Result.LOSS;
        }
        if (isStreight() && hand.isStreight()){ //Streight
            if ((intsorted[3]==5&&intsorted[4]==14)||(hand.intsorted[3]==5&&hand.intsorted[4]==14)) {
                if ((intsorted[3] == 5 && intsorted[4] == 14) && !(hand.intsorted[3] == 5 && hand.intsorted[4] == 14))
                    return Result.LOSS;
                if ((intsorted[3] == 5 && intsorted[4] == 14) && (hand.intsorted[3] == 5 && hand.intsorted[4] == 14))
                    return Result.TIE;
                if (!(intsorted[3] == 5 && intsorted[4] == 14) && (hand.intsorted[3] == 5 && hand.intsorted[4] == 14))
                    return Result.WIN;
            }
            if (highCard() > hand.highCard()) {
                return Result.WIN;
            } else if (highCard() == hand.highCard())
                return Result.TIE;
            else return Result.LOSS;
        }
        if (isThree()&& hand.isThree()) {          //Three
            if (intsorted[2] > hand.intsorted[2])
                return Result.WIN;
            if (intsorted[2] == hand.intsorted[2])
                return pairMax > hand.pairMax ? Result.WIN : Result.LOSS;
            else return Result.LOSS;
        }
        if (isTwo() && hand.isTwo()){
            if (tirdCard() > hand.tirdCard()) {
                return Result.WIN;
            } else if (tirdCard() == hand.tirdCard())
                return intsorted[4]==hand.intsorted[4]?Result.TIE:intsorted[4]>hand.intsorted[4]?Result.WIN:Result.LOSS;
            else return Result.LOSS;
        }
        else {System.out.println("Werwer"); return Result.WIN;}
    }



    public static void main(String[] args) {
        PokerHand hand = new PokerHand("AC AD AD TD QD");
        System.out.println(hand.compareWith(new PokerHand("AD AD AD TD 3D")));

    }
}

