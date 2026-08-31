class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m + n - 1;
        int idxa = m - 1;
        int idxb = n - 1;

        while (idxa >= 0 && idxb >= 0) {
            if (nums1[idxa] < nums2[idxb]) {
                nums1[j--] = nums2[idxb--];
            } else {
                nums1[j--] = nums1[idxa--];
            }
        }

        while (idxb >= 0) {
            nums1[j--] = nums2[idxb--];
        }
    }
}