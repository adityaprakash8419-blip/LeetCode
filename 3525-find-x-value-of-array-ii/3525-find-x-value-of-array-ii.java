import java.util.*;

class Solution {

    static class Node {
        int[] v;
        int m;

        Node(int k) {
            v = new int[k];
        }
    }

    static class SegmentTree {
        Node[] tree;
        int k;

        SegmentTree(int n, int k) {
            this.k = k;
            tree = new Node[4 * n];
        }

        void pushUp(int ind) {
            int left = ind * 2;
            int right = left + 1;

            tree[ind].m = (tree[left].m * tree[right].m) % k;
            tree[ind].v = tree[left].v.clone();

            for (int i = 0; i < k; i++) {
                tree[ind].v[(tree[left].m * i) % k] += tree[right].v[i];
            }
        }

        void build(int[] nums, int ind, int left, int right) {
            if (left == right) {
                tree[ind] = new Node(k);
                tree[ind].m = nums[left] % k;
                tree[ind].v[tree[ind].m] = 1;
                return;
            }

            int mid = (left + right) / 2;

            build(nums, ind * 2, left, mid);
            build(nums, ind * 2 + 1, mid + 1, right);

            tree[ind] = new Node(k);
            pushUp(ind);
        }

        Node query(int ind, int left, int right, int x, int y) {
            if (left >= x && right <= y) {
                return tree[ind];
            }

            int mid = (left + right) / 2;

            if (mid >= y) {
                return query(ind * 2, left, mid, x, y);
            }

            if (mid < x) {
                return query(ind * 2 + 1, mid + 1, right, x, y);
            }

            Node a = query(ind * 2, left, mid, x, mid);
            Node b = query(ind * 2 + 1, mid + 1, right, mid + 1, y);

            Node r = new Node(k);

            r.m = (a.m * b.m) % k;
            r.v = a.v.clone();

            for (int i = 0; i < k; i++) {
                r.v[(a.m * i) % k] += b.v[i];
            }

            return r;
        }

        void update(int ind, int left, int right, int x, int y) {
            if (left == right) {
                tree[ind] = new Node(k);
                tree[ind].m = y % k;
                tree[ind].v[tree[ind].m] = 1;
                return;
            }

            int mid = (left + right) / 2;

            if (x <= mid) {
                update(ind * 2, left, mid, x, y);
            } else {
                update(ind * 2 + 1, mid + 1, right, x, y);
            }

            pushUp(ind);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(n, k);
        tree.build(nums, 1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];

            tree.update(1, 0, n - 1, q[0], q[1]);

            Node ans = tree.query(1, 0, n - 1, q[2], n - 1);

            result[i] = ans.v[q[3]];
        }

        return result;
    }
}