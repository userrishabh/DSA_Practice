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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> temp = new Stack<>();

        while(root != null || !temp.isEmpty())
        {
            while(root != null)
            {
                temp.push(root);
                root = root.left;
            }
            root = temp.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}