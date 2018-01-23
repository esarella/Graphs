/*
Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12

Return the numbers in sorted order.

 */
package Graphs;

import java.util.ArrayList;

public class SteppingNumbers {
    public static void main(String[] args) {
        int a = 0;
        int b = 1000;
        System.out.println("Stepping Numbers between " +  a + " and " + b + " = " + stepNum(a,b));
        System.out.println("Number of Stepping Numbers between " +  a + " and " + b + " = " + stepNum(a,b).size());
    }

    public static ArrayList<Integer> stepNum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = A ; i<= B; i++){
            if (stepNumHelper(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean stepNumHelper(int x){
        if (x<10) return true;
        int prev = x%10;
        x /= 10;
        int cur = 0;
        while (x>0){
            cur = x%10;
            if (cur - prev !=1 && cur - prev != -1){
                return false;
            }
            prev = cur;
            x /= 10;
        }
        return true;
    }
}
