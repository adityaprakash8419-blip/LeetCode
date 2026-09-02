class Solution {
    public String addStrings(String num1, String num2) {

       int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int a = 0;
            int b = 0;

            if (i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }

            int sum = a + b + carry;

            ans.append(sum % 10);
            carry = sum / 10;
        }

        return ans.reverse().toString();
        
    }
}