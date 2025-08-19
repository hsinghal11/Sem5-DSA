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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        boolean zigzag = true;
        while(!q.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            int n = q.size();
            while(n-- > 0){
                TreeNode node = q.poll();
                ll.add(node.val);
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
            }
            if(!zigzag){
                Collections.reverse(ll);
            }
            zigzag = !zigzag;
            ans.add(ll);
        }
        return ans;
    }
}