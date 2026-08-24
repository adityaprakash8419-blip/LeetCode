class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<spaces.length && i==spaces[j]){
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
        
    }
}