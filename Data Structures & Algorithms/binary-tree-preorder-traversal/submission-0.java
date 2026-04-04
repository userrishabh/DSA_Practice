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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> temp = new ArrayDeque<>();
        while(root != null || !temp.isEmpty())
        {
            while(root != null)
            {
                res.add(root.val);
                temp.push(root);
                root = root.left;
            }
            root = temp.pop();
            root = root.right;
        }

        return res;
    }
}