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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ll = new ArrayList<>();
        if(solve(root, ll ,to_delete)!=null) ll.add(root);
        return ll;
    }

    public TreeNode solve(TreeNode root, List<TreeNode> ll, int[] to_delete){
        if(root == null) return null;
        TreeNode right = solve(root.right, ll, to_delete);
        TreeNode left = solve(root.left, ll, to_delete);
        if(exist(root.val, to_delete)){
            if(left != null) ll.add(left);
            if(right != null) ll.add(right);
            return null;
        }
        root.left = left;
        root.right = right;
        return root;

    }

    public boolean exist(int value ,int[] to_delete){
        for(int i=0 ;i<to_delete.length ; i++){
            if(value==to_delete[i]) return true;
        }
        return false;
    }
}