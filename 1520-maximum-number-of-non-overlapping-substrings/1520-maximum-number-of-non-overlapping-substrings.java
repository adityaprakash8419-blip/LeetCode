class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26];
        Arrays.fill(left, -1);

        int[] right = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (left[c] == -1) {
                left[c] = i;
            }

            right[c] = i;
        }

        LinkedList<String> result = new LinkedList<>();

        for (int i = 0, last = -1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (left[c] != i) {
                continue;
            }

            int end = right[c];

            for (int j = i + 1; j <= end; j++) {
                int temp = s.charAt(j) - 'a';

                if (left[temp] < i) {
                    end = -1;
                    break;
                }

                end = Math.max(end, right[temp]);
            }

            if (end == -1) {
                continue;
            }

            if (last >= i) {
                result.removeLast();
            }

            result.add(s.substring(i, end + 1));
            last = end;
        }

        return result;
    }
}