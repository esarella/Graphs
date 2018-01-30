/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CaptureRegionsOnBoard {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new  ArrayList<ArrayList<Character>> ();

        String [] rows = {"OOX", "OOO", "XXX", "XXX", "XOX", "XOX", "XXO" };

        solve(a);

        System.out.println(a);

    }

    public static void solve(ArrayList<ArrayList<Character>> a) {
        int maxRow = a.size()-1;
        int maxCol = a.get(0).size()-1;
        for (int i = 0; i <= maxRow; i++) {
            dfs(a, i, 0);
        }
        for (int j = 0; j <= maxCol; j++) {
            dfs(a, 0, j);
        }
        for (int i = 0; i <= maxRow; i++) {
            dfs(a, i, maxCol);
        }
        for (int j = 0; j <= maxCol; j++) {
            dfs(a, maxRow, j);
        }
        //now change all the 'O's to 'X's
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                if (a.get(i).get(j) != 'R') {
                    a.get(i).set(j, 'X');
                }
            }
        }
        //now change all the 'R's back to 'O's
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                if (a.get(i).get(j) == 'R') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Character>> a, int r, int c) {
        if (r < 0 || r >= a.size() || c < 0 || c >= a.get(r).size() || a.get(r).get(c) != 'O') return;

        a.get(r).set(c, 'R');

        dfs(a, r+1, c);
        dfs(a, r, c+1);
        dfs(a, r-1, c);
        dfs(a, r, c-1);
    }
}


