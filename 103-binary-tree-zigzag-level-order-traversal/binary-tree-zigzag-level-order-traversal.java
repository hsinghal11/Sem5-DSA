class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean zigzag = false; // level 0 (root) is left to right

        q.add(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> ll = new LinkedList<>();
            int n = q.size();

            while (n-- > 0) {
                TreeNode node = q.poll();

                // add values based on zigzag flag
                if (zigzag) {
                    ll.addFirst(node.val); 
                } else {
                    ll.addLast(node.val);
                }

                // always enqueue children in left → right order
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            ans.add(ll);
            zigzag = !zigzag; // flip
        }

        return ans;
    }
}
