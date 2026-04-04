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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<Integer>();
            int length = q.size();
            for(int i=0; i<length; i++)
            {
                TreeNode tempNode = q.remove();
                temp.add(tempNode.val);

                if(tempNode.left != null) q.add(tempNode.left);
                if(tempNode.right != null) q.add(tempNode.right);
             }
             res.add(temp);
        }

        return res;
    }
}
