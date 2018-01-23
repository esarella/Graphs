/*

Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

Also think about a version of the question where you are asked to do a level order traversal of the tree when
depth of the tree is much greater than number of nodes on a level.

 */

package Graphs;

import java.util.ArrayList;

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        helper(result, A, 0);
        return result;
    }

    public void helper(ArrayList<ArrayList<Integer>> level, TreeNode A, int height) {
        if (A == null)
            return;
        if (height >= level.size()) {
            level.add(new ArrayList<Integer>());
        }

        level.get(height).add(A.val);
        helper(level, A.left, height + 1);
        helper(level, A.right, height + 1);
    }

    // Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
