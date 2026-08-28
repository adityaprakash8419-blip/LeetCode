class Solution {

    void make(StringBuilder s, int n) {
        String temp = s.toString();

        if ((n & 1) == 1) {
            temp = temp.substring(0, temp.length() - 1);
        }

        temp = new StringBuilder(temp).reverse().toString();
        s.append(temp);
    }

    void make(StringBuilder r, int n, int[] have) {
        for (int i = 0; r.length() < n; ) {
            if (have[i] > 0) {
                r.append((char) (i + 'a'));
                --have[i];
            } else {
                ++i;
            }
        }
    }

    public String lexPalindromicPermutation(String s, String target) {
        int[] have = new int[26];

        for (char c : s.toCharArray()) {
            ++have[c - 'a'];
        }

        char extra = '?';

        for (int i = 0; i < 26; ++i) {
            if ((have[i] & 1) == 1) {
                if (extra != '?') {
                    return "";
                }
                extra = (char) ('a' + i);
            }

            have[i] >>= 1;
        }

        int n = s.length();
        int m = n >> 1;

        StringBuilder temp = new StringBuilder(target.substring(0, m));

        int mask = 0;

        for (int i = 0; i < temp.length(); ++i) {
            int x = temp.charAt(i) - 'a';

            if (have[x]-- == 0) {
                mask |= 1 << x;
            }
        }

        while (true) {

            if (mask == 0) {

                if (temp.length() == m) {

                    StringBuilder r = new StringBuilder(temp);

                    if (extra != '?') {
                        r.append(extra);
                    }

                    make(r, n);

                    if (r.toString().compareTo(target) > 0) {
                        return r.toString();
                    }

                } else {

                    for (int i = target.charAt(temp.length()) - 'a' + 1;
                         i < 26; ++i) {

                        if (have[i] > 0) {

                            --have[i];

                            StringBuilder r = new StringBuilder(temp);
                            r.append((char) ('a' + i));

                            make(r, m, have);

                            if (extra != '?') {
                                r.append(extra);
                            }

                            make(r, n);

                            return r.toString();
                        }
                    }
                }
            }

            if (temp.length() == 0) {
                return "";
            }

            int x = temp.charAt(temp.length() - 1) - 'a';

            if (++have[x] == 0) {
                mask ^= 1 << x;
            }

            temp.deleteCharAt(temp.length() - 1);
        }
    }
}