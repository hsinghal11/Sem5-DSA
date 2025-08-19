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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build the tree using helper function
        return createTree(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode createTree(int[] in, int[] pos, int plo, int phi, int ilo, int ihi){
        // base case: no elements left
        if (ilo > ihi || plo > phi) {
            return null;
        }

        // root node will always be the last element in current postorder range
        TreeNode node = new TreeNode(pos[phi]);

        // find root index in inorder array
        int idx = search(in, node.val, ilo, ihi);

        // number of nodes in left subtree
        int len = idx - ilo;

        // build right subtree
        node.right = createTree(
            in, pos,
            plo + len, phi - 1,     // postorder range for right subtree
            idx + 1, ihi            // inorder range for right subtree
        );
        /**
         * Explanation:
         * In inorder: right subtree lies to the right of idx → [idx+1 ... ihi]
         * In postorder: right subtree comes just before the root
         *     → start at plo+len (skip left-subtree part), end at phi-1 (exclude root)
         *
         * Example:
         * inorder   = [9, 3, 15, 20, 7]
         * postorder = [9, 15, 7, 20, 3]
         *
         * Suppose root = 3 (pos[phi])
         * inorder split: left = [9], right = [15,20,7]
         * postorder split: left = [9], right = [15,7,20]
         */

        // build left subtree
        node.left = createTree(
            in, pos,
            plo, plo + len - 1,     // postorder range for left subtree
            ilo, idx - 1            // inorder range for left subtree
        );
        /**
         * Explanation:
         * In inorder: left subtree lies to the left of idx → [ilo ... idx-1]
         * In postorder: left subtree comes first in the segment
         *     → start at plo, end at plo+len-1 (length = size of left subtree)
         *
         * Example:
         * inorder left = [9]
         * postorder left = [9]
         */

        return node;
    }

    // helper to find root in inorder array
    private int search(int[] in, int item, int st, int end){
        for (int i = st; i <= end; i++) {
            if (in[i] == item) {
                return i;
            }
        }
        return 0; 
    }
}
