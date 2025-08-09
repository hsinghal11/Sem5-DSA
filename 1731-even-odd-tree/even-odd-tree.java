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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> gg = new LinkedList<>();
        gg.offer(root);
        int level = 0;

        while(!gg.isEmpty()){
            int size = gg.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i = 0; i<size; i++){
                TreeNode kk = gg.poll();
                int curr = kk.val;

            if(level % 2 == 0){
                if(curr % 2 == 0 || curr <= prev) return false;
            }
            else{
                if(curr % 2 != 0 || curr >= prev) return false;
            }
            prev = curr;
            if(kk.left != null) gg.offer(kk.left);
            if(kk.right != null) gg.offer(kk.right);
        }
        level++;
        }
        return true;
    }
}