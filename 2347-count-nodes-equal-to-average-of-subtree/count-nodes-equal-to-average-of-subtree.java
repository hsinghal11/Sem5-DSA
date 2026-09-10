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
    int ans = 0;
      public int averageOfSubtree(TreeNode root) {
          findAns(root);
          return ans;
      }

      public int[] findAns(TreeNode root){
          if(root == null){
              return new int[]{0,0};
          }
        if(root.left == null && root.right==null) {
            ans += 1;
            return new int[]{root.val, 1};
        }
        int[] left = findAns(root.left);
        int[] right = findAns(root.right);
        
        int tSum = left[0]+right[0]+root.val;
        int tNum = left[1]+right[1]+1;
        int avg = tSum / tNum;
        if(avg == root.val){
            ans ++;
        }
        return new int[]{tSum, tNum};
      }
}