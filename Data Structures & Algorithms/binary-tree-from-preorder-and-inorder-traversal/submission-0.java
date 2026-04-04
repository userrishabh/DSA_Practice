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
   int counter = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            hm.put(inorder[i], i);
        }

        return constructTree(preorder, hm, 0, inorder.length-1);
    }

    TreeNode constructTree(int[] preorder, HashMap<Integer, Integer> hm, int start, int end)
    {
        if(start > end) return null;

        int root = preorder[counter++];

        TreeNode res = new TreeNode(root);

        int mid = hm.get(root);

        res.left = constructTree(preorder, hm, start, mid-1);
        res.right = constructTree(preorder, hm, mid+1, end);

        return res;
    } 
}
