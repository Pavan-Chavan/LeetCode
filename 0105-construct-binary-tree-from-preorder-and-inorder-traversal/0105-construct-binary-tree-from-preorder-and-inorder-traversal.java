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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        TreeNode root = helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,Map<Integer, Integer> inMap) {
        if(preEnd < preStart || inEnd < inStart)
            return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIn = inMap.get(preorder[preStart]);
        int onLeft = rootIn - inStart ;

        node.left = helper(preorder, preStart+1, preStart+onLeft, inorder, inStart, inStart+rootIn, inMap);
        node.right = helper(preorder, preStart+onLeft+1, preEnd, inorder, rootIn+1, inEnd, inMap);

        return node;
    }
}