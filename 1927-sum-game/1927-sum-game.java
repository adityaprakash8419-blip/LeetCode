class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int r = 0;

        for (int i = 0; i < n; i++) {
            int c = Character.isDigit(num.charAt(i))
                    ? (num.charAt(i) - '0') * 2
                    : 9;

            r += (i + i < n) ? c : -c;
        }

        return r != 0;
    }
}