https://leetcode.com/problems/brace-expansion/discuss/1655797/Java-100-Backtracking-Solution-1ms-with-Comments
class Solution {
    public String[] expand(String s) {
        char[] arr = s.toCharArray();
        int num = 1, len = 0;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++, len++){
            if (arr[i] == '{') {
                List<Character> cand = new ArrayList<>();
                int j = i;
                while(arr[i] != '}')
                    if (++i % 2 != j % 2)
                        cand.add(arr[i]);

                num *= cand.size();
                Collections.sort(cand);
                map.put(j, cand);
            }
        }

        String[] ans = new String[num];
        backtrack(arr, ans, 0, 0, 0, new char[len], map);
        return ans;
    }

    private int backtrack(char[] arr, String[] ans, int i, int j, int k, char[] tmp, Map<Integer, List<Character>> map){
        if (k == tmp.length){
            ans[i++] = String.valueOf(tmp);
            return i;
        }

        if (!map.containsKey(j)){
            tmp[k] = arr[j];
            i = backtrack(arr, ans, i, j + 1, k + 1, tmp, map);
        }else{
            for (int w = 0, sz = map.get(j).size(); w < sz; w++){
                tmp[k] = map.get(j).get(w);
                i = backtrack(arr, ans, i, j + 2 * sz + 1, k + 1, tmp, map);
            }
        }

        return i;
    }
}
