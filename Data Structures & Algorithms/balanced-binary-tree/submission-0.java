/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int check = checkTree(root);
        return (check != -1) ? true : false;
    }
    public int checkTree(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = checkTree(node.left);
        if(leftHeight == -1 ) return -1;

        int rightHeight = checkTree(node.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(rightHeight - leftHeight) > 1) return -1;

        return 1 + Math.max(rightHeight, leftHeight);
    }
}
