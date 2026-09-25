import java.util.*;

class Solution {

    private Set<String> merge(Set<String> s, Set<String> t) {
        Set<String> r = new HashSet<>();

        for (String w1 : s) {
            for (String w2 : t) {
                r.add(w1 + w2);
            }
        }

        return r;
    }

    public Set<String> dfs(String s, int[] now) {
        Set<String> all = new HashSet<>();
        Set<String> one = new HashSet<>();
        one.add("");

        while (true) {

            if (now[0] >= s.length() || s.charAt(now[0]) == '}') {
                all.addAll(one);
                now[0]++;
                break;
            }

            if (s.charAt(now[0]) == '{') {
                now[0]++;
                one = merge(one, dfs(s, now));

            } else if (Character.isLetter(s.charAt(now[0]))) {
                Set<String> temp = new HashSet<>();
                temp.add(String.valueOf(s.charAt(now[0])));

                one = merge(one, temp);
                now[0]++;

            } else {
                all.addAll(one);
                one = new HashSet<>();
                one.add("");
                now[0]++;
            }
        }

        return all;
    }

    public List<String> braceExpansionII(String expression) {
        List<String> r = new ArrayList<>();
        int[] now = {0};

        Set<String> result = dfs(expression, now);

        for (String s : result) {
            r.add(s);
        }

        Collections.sort(r);

        return r;
    }
}