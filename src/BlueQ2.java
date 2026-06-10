public class BlueQ2 {
    /**
     * Returns which has a higher range: a given linked list or a given tree.
     * The range of a data structure is the difference between its highest
     * value and its lowest value.
     * 
     * Returns "list" if the list has a higher range and "tree" if the tree has
     * a higher range. You can assume there will not be a tie, and neither head
     * nor root will be null.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "list"
     * 
     * Explanation:
     *   The largest number in the list is 21 and -2 is the smallest.
     *   Thus the range of the list is 21 - -2 = 23
     *   The largest number in the tree is 18, and 4 is the smallest.
     *   Thus the range of the tree is 18 - 4 = 14
     *   23 is bigger than 14, so the list has the bigger range.
     *    
     * 
     * @param head the head of the list
     * @param root the root of the tree
     * @return "list" if the list has a bigger range, "tree" otherwise
     */
    public static String biggerRange(ListNode head, TreeNode root) {
        int listDiff = maxList(head) - minList(head);
        int treeDiff = 0;
        if(root.left != null || root.right != null) treeDiff = maxTree(root) - minTree(root);
        return listDiff > treeDiff ? "list" : "tree";
        /*if(listDiff > treeDiff)
        {
            return "list";
        }
        return "tree";*/
    }

    public static int minList(ListNode head)
    {
        ListNode current = head;
        int min = current.data;
        while(current != null)
        {
            if(min > current.data) min = current.data;
            current = current.next;
        }
        return min;
    }

    public static int maxList(ListNode head)
    {
        ListNode current = head;
        int max = current.data;
        while(current != null)
        {
            if(max < current.data) max = current.data;
            current = current.next;
        }
        return max;
    }

    public static int minTree(TreeNode root)
    {
        if(root == null) return Integer.MAX_VALUE;
        int min = root.data;
        if(minTree(root.left) < min) min = root.left.data;
        if(minTree(root.right) < min) min = root.right.data;
        return min;
    }

    public static int maxTree(TreeNode root)
    {
        if(root == null) return Integer.MIN_VALUE;
        int max = root.data;
        if(minTree(root.left) > max) max = root.left.data;
        if(minTree(root.right) > max) max = root.right.data;
        return max;
    }


}
