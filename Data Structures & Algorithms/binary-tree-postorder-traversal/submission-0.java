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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> temp = new ArrayDeque<>();
        TreeNode lastVisited = null;
        while(root != null || !temp.isEmpty())
        {
            while(root != null)
            {
                temp.push(root);
                root = root.left;
            }
            TreeNode peek = temp.peek();
            if(peek.right == null || peek.right == lastVisited)
            {
                temp.pop();
                res.add(peek.val);
                lastVisited = peek;
            }
            else
                root = peek.right;
        }
        return res;
    }
}