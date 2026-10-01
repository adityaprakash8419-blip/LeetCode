class Solution {
    public boolean isValid(String s) {

        char[] arr = new char[s.length()];
        int top = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                top++;
                arr[top] = c;
            }
            else {
                if(top == -1) {
                    return false;
                }
                if(c == ')') {
                    if(arr[top] != '(') {
                        return false;
                    }
                }
                else if(c == '}') {
                    if(arr[top] != '{') {
                        return false;
                    }
                }
                else if(c == ']') {
                    if(arr[top] != '[') {
                        return false;
                    }
                }

                top--;
            }
        }

        if(top == -1) {
            return true;
        }
        else {
            return false;
        }
    }
} 