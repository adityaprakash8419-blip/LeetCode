

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> p : knowledge) {
            map.put(p.get(0), p.get(1));
        }

        StringBuilder key = new StringBuilder();
        StringBuilder r = new StringBuilder();
        boolean in = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                in = true;
            } else if (c == ')') {
                String k = key.toString();

                if (map.containsKey(k)) {
                    r.append(map.get(k));
                } else {
                    r.append("?");
                }

                key.setLength(0);
                in = false;
            } else if (in) {
                key.append(c);
            } else {
                r.append(c);
            }
        }

        return r.toString();
    }
}