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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        ans(root,targetSum,ans,ll);
        return ans;
    }
    public void ans(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> ll){
        if(root == null) return;
        ll.add(root.val);
        if(root.left == null && root.right == null && targetSum-root.val == 0){
            ans.add(new ArrayList<>(ll));
        }
        ans(root.left, targetSum-root.val, ans, ll);
        ans(root.right, targetSum-root.val, ans, ll);
        ll.remove(ll.size()-1);
    }
}