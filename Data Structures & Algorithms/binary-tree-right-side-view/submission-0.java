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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int length = q.size();

            for(int i=0; i<length; i++)
            {
                TreeNode tempNode = q.poll();
                if(i == length-1)
                    res.add(tempNode.val);

                if(tempNode.left != null) q.offer(tempNode.left);
                if(tempNode.right != null) q.offer(tempNode.right); 
            }
        }
        return res;
    }
}
