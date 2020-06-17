package com.company;

import static java.lang.System.out;

public class Task1 {
    public static void main(String[] msi) {
        out.println(remainder(10,6));
        out.println(triArea(3,2));
        out.println(animals(2,3,5));
        out.println(profitableGamble(1,2,50));
        out.println(operation(24,15,9));
        out.println(ctoa("A"));
        out.println(addUpTo(3));
        out.println(nextEdge(8,10));
        out.println(sumOfCubes(2));
        out.println(abcmath(42,5,10));

    }

    //#Test1
    public static int remainder(int a, int b) {
        return a % b;
    }

    //#Test2
    public static float triArea(int a, int b) {
        return (float) (a * b) / 2;
    }

    //#Test3
    public static int animals(int chickens, int pig, int cow) {
        return chickens * 2 + pig * 4 + cow * 4;
    }

    //#Test4
    public static boolean profitableGamble(float prob, int prize, int pay) {
        return prob * prize > pay;
    }

    //#Test5
    public static String operation(int a, int b,int s) {
        if ((b - a == s) | (a - b == s)) return "substacted";
        if ((b + a == s)) return  "added";
        if ((b / a == s) | (a / b == s)) return  "division";
        if ((b * a == s)) return  "multiplication";
        return "none";
    }

    //#Test6
    public static int ctoa(String s) {
        return s.charAt(0);
    }

    //#Test7
    public static int addUpTo(int a) {
        int s = 0;
        for (int i = 0; i <= a; i++) s += i;
        return (s);
    }

    //#Test8
    public static int nextEdge(int a, int b) {
        return (a + b - 1);
    }

    //#Test9
    public static int sumOfCubes(int... a) {
        int s = 0;
        for (int i : a) {
            s += Math.pow(i, 3);
        }
        return (s);
    }

    //#Test10
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a += a;
        }
        return (a % c == 0);
    }
}
