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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(solve(root.left), 0);
        int right = Math.max(solve(root.right), 0);
        ans = Math.max(ans,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}