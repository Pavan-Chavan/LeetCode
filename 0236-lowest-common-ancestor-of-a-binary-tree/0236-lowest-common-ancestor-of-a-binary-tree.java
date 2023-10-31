/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) {
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rNode = lowestCommonAncestor(root.right,p,q);

        if(lNode == null) 
            return rNode;
        else if (rNode == null)
            return lNode;
        else 
            return root;
    }
}