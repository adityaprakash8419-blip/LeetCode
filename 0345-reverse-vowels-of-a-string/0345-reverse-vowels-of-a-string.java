class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;

        while (i < j) {
            while (i < j && !isVowel(a[i])) {
                i++;
            }

            while (i < j && !isVowel(a[j])) {
                j--;
            }

            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }

        return new String(a);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}