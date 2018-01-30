/*
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. return 1/0 if it is possible/not possible.
The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].


 */
package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] pre=new int[A];

        for(int i=0;i<C.size();i++)
            pre[C.get(i)-1]++;

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0)q.add(i+1);
        }
        if(q.isEmpty())return 0;

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<B.size();i++){
                if(B.get(i)==curr){
                    pre[C.get(i)-1]--;
                    if(pre[C.get(i)-1]==0)q.add(C.get(i));
                }
            }
        }
        for(int i=0;i<pre.length;i++)
            if(pre[i]!=0)
                return 0;

        return 1;
    }

}
