class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        TreeMap<Character, Integer> map = new TreeMap<>();
        int[] last = new int[10];
        for (int i = 0; i < s.length(); i++){
            map.merge(s.charAt(i), 1, Integer::sum);
            last[s.charAt(i) - '0'] = i;
        }

        int j = -1;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != map.lastKey()){
                j = i;
                break;
            }
            if (map.merge(s.charAt(i), -1, Integer::sum) == 0){
                map.remove(s.charAt(i));
            }
        }
        if (j == -1)
            return num;

        int k = last[map.lastKey() - '0'];
        char[] ans = s.toCharArray();
        ans[k] = s.charAt(j);
        ans[j] = s.charAt(k);
        return Integer.parseInt(String.valueOf(ans));
    }
}
