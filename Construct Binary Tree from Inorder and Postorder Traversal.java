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
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();
        postorderIndex = postorder.length - 1;

     for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

    
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = map.get(rootValue);

        root.right = build(postorder, inorderIndex + 1, right);

        root.left = build(postorder, left, inorderIndex - 1);

        return root;
    }
}
