/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
            Stack<TreeNode> nodes = new Stack<>();
            ArrayList<Integer> output = new ArrayList<>();

            nodes.push(a);
            while (!nodes.isEmpty()) {
                TreeNode n = nodes.pop();
                output.add(n.val);
                if (n.left != null) {
                    nodes.push(n.left);
                }
                if (n.right != null) {
                    nodes.push(n.right);
                }
            }

            Collections.reverse(output);
            return output;
        
    }
}
