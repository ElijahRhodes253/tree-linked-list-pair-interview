public class BlueQ1 {
    /**
     * Given a reference to the root of a tree, return the sum of the leaf nodes with even values in the tree.
     * Do not include any odd or branch nodes.
     * 
     * Example:
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  \
     *       4   8  16   20
     *      /              \
     *     3                22 
     *   Expected Answer: 46
     *   The leaf nodes are 3   8   16   22, and the even ones are 8   16   22.
     *   The sum of the even leaf nodes is 8+16+22 = 46
     * 
     * If the root is null, return 0.
     * If there are no even leaf nodes, return 0.
     * 
     * @param root the root of the tree
     * @return the sum of the even leaf nodes
     */
    public static int evenLeafSum(TreeNode root) {
        if(root == null) return 0;
        int sum = evenLeafSum(root.left) + evenLeafSum(root.right);;

        if(root.left == null && root.right == null && root.data % 2 == 0) sum+=root.data;
        return sum;
    }
}
