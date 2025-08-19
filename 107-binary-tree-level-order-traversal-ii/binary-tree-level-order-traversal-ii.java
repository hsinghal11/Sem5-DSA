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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int n = q.size();
            while(n-->0){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null){
                q.add(node.left);
                }
                if(node.right != null){
                q.add(node.right);
                }
            }
            ll.add(l);
        }
        Collections.reverse(ll);
        return ll;
    }
}