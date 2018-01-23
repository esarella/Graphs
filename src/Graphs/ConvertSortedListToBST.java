/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3

 */
package Graphs;

public class ConvertSortedListToBST {

      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


      class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

        private ListNode list;
        public TreeNode sortedListToBST(ListNode a) {
            int n = 0;

            ListNode temp = a;
            while(temp != null){
                temp = temp.next;
                n++;
            }
            list = a;
            return helper(0,n-1);
        }

        private TreeNode helper(int start, int end){
            if(start > end) return null;

            int mid = (start + end) / 2;

            TreeNode left = helper(start, mid -1);
            TreeNode parent = new TreeNode(list.val);
            parent.left = left;
            list = list.next;
            parent.right = helper(mid+1, end);

            return parent;
        }

}
