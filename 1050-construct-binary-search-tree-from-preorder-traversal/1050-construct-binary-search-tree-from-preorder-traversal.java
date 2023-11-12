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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        int i = 1;
        while(i<preorder.length) {
            TreeNode node = new TreeNode(preorder[i]);
            if(preorder[i] < st.peek().val ) {
                st.peek().left = node;
                st.push(node);
            } else {
                TreeNode temp = new TreeNode();
                while(!st.isEmpty() && st.peek().val < preorder[i]) {
                    temp = st.pop();
                }
                temp.right = node;
                st.push(node);
            }
            i++;
        }
        return root;
    }
}