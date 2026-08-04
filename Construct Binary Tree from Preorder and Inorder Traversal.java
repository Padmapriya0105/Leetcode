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

    private HashMap<Integer, Integer> map;
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();
     for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

       
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

      
        int inorderIndex = map.get(rootValue);

        root.left = build(preorder, left, inorderIndex - 1);

     
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}
