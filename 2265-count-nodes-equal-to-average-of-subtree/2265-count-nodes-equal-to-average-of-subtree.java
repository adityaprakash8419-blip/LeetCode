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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    int dfs(TreeNode root, int[] sum, int[] num) {

        if (root == null) {
            sum[0] = 0;
            num[0] = 0;
            return 0;
        }

        int r = dfs(root.left, sum, num);

        int s = sum[0] + root.val;
        int n = num[0] + 1;

        r += dfs(root.right, sum, num);

        sum[0] += s;
        num[0] += n;

        if (sum[0] / num[0] == root.val) {
            r++;
        }

        return r;
    }

    public int averageOfSubtree(TreeNode root) {
        int[] sum = {0};
        int[] num = {0};

        return dfs(root, sum, num);
    }
}