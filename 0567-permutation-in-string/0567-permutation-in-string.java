class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int length = s1.length();
        int window = s2.length();

        if (length > window) {
            return false;
        }

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (int i = 0; i < length; i++) {
            int s1i = s1.charAt(i) - 'a';
            int s2i = s2.charAt(i) - 'a';

            s1Arr[s1i]++;
            s2Arr[s2i]++;
        }

        for (int i = 0; i <= window - length; i++) {

            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }

            if (i + length < window) {
                int prev = s2.charAt(i) - 'a';
                int next = s2.charAt(i + length) - 'a';

                s2Arr[prev]--;
                s2Arr[next]++;
            }
        }

        return false;
    }
}