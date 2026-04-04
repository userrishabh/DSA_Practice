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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();

        encode(root, sb);

        return sb.toString();
    }

    void encode(TreeNode root, StringBuilder sb)
    {
        if(root == null) 
        {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        encode(root.left, sb);
        encode(root.right, sb);
    }
    int i = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder();
        while(data.charAt(i) != ',')
        {
            sb.append(data.charAt(i));
            i++;
        }
        i++;
         if(sb.toString().equals("#")) return null;
        TreeNode tr = new TreeNode(Integer.parseInt(sb.toString()));
        tr.left = deserialize(data);
        tr.right = deserialize(data);

        return tr;
    }
}
