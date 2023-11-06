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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode();
        root = helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap);
        return root;
    }
    private TreeNode helper(int[] inorder, int startIn,int endIn, int[] postorder, int startPost, int endPost, Map<Integer,Integer> inMap) {
        if(endIn < startIn || endPost < startPost)
            return null;

        TreeNode node = new TreeNode(postorder[endPost]);

        int PostInIn = inMap.get(postorder[endPost]);
        int onRight = endIn - PostInIn; 

        node.left = helper(inorder, startIn, PostInIn-1 , postorder,startPost ,endPost-onRight-1 ,inMap);
        node.right = helper(inorder,PostInIn+1 ,endIn , postorder, endPost-onRight,endPost-1 ,inMap);

        return node;
    }
}