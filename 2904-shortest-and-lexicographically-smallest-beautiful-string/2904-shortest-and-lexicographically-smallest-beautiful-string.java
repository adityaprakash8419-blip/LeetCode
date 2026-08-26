class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String r = "";
        int n = s.length();

        for (int i = 0, j = 0, sum = 0; ; sum -= s.charAt(i++) - '0') {

            while (j < n && sum < k) {
                sum += s.charAt(j++) - '0';
            }

            if (sum < k) {
                break;
            }

            String temp = s.substring(i, j);

            if (r.isEmpty() ||
                temp.length() < r.length() ||
                (temp.length() == r.length() && temp.compareTo(r) < 0)) {
                r = temp;
            }
        }

        return r;
    }
}