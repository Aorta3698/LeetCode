class Solution {
    TreeMap<Integer, Integer>[] map = new TreeMap[26];
    TreeMap<Integer, Integer> sMap = new TreeMap<>();
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Arrays.setAll(map, o -> new TreeMap<>());
        char[] A = s.toCharArray();
        for (int i = 0, j = 0; i < A.length; i++){
            if (i == A.length - 1 || A[i] != A[i+1]){
                map[A[i]-'a'].put(j, i);
                sMap.merge(i-j+1, 1, Integer::sum);
                j = i+1;
            }
        }
        int[] ans = new int[queryIndices.length];
        for (int i = 0; i < ans.length; i++){
            int k = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            delete(A[k] - 'a', k);
            insert(ch - 'a', k);
            A[k] = ch;
            ans[i] = sMap.lastKey();
        }
        return ans;
    }

    private void delete(int idx, int k){
        var delMap = map[idx];
        int L = delMap.floorKey(k), R = delMap.get(L);
        if (L == R){
            delMap.remove(L);
        }else if (L == k){
            delMap.remove(L);
            delMap.put(L+1, R);
            sMap.merge(R-L, 1, Integer::sum);
        }else if (R == k){
            delMap.put(L, R - 1);
            sMap.merge(R-L, 1, Integer::sum);
        }else{
            delMap.put(L, k-1);
            delMap.put(k+1, R);
            sMap.merge(k-L, 1, Integer::sum);
            sMap.merge(R-k, 1, Integer::sum);
        }
        if (sMap.merge(R - L + 1, -1, Integer::sum) == 0){
            sMap.remove(R - L + 1);
        }
    }

    private void insert(int idx, int k){
        var insMap = map[idx];
        Integer L = insMap.floorKey(k), R = 0;
        if (L == null || insMap.get(L)+1 < k){
            if (insMap.get(k+1) != null){
                R = insMap.get(k+1);
                insMap.put(k, R);
                insMap.remove(k+1);
                sMap.merge(R-k+1, 1, Integer::sum);
                if (sMap.merge(R-k, -1, Integer::sum) == 0){
                    sMap.remove(R-k);
                }
            }else{
                insMap.put(k, k);
                sMap.merge(1, 1, Integer::sum);
            }
        }else{
            R = insMap.get(L);
            if (R+1 == k && insMap.get(k+1) != null){
                int end = insMap.get(k+1);
                if (sMap.merge(R-L+1, -1, Integer::sum) == 0){
                    sMap.remove(R-L+1);
                }
                if (sMap.merge(end - k, -1, Integer::sum) == 0){
                    sMap.remove(end - k);
                }
                sMap.merge(end - L + 1, 1, Integer::sum);
                insMap.remove(k+1);
                insMap.put(L, end);
            }else{
                if (sMap.merge(R-L+1, -1, Integer::sum) == 0){
                    sMap.remove(R-L+1);
                }
                sMap.merge(k-L+1, 1, Integer::sum);
                insMap.put(L, k);
            }
        }
    }
}
