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
    int total = 0;
    public int findTilt(TreeNode root) {
        tilt(root);
        return total;
    }

    public int tilt(TreeNode root){
        if(root == null) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        total += Math.abs(left-right);
        return root.val+left+right;
    }
}