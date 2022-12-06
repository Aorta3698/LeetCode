class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new ArrayDeque<>(List.of(s));
        String ans = s;
        Set<String> seen = new HashSet<>(List.of(s));
        while(!queue.isEmpty()){
            String cur = queue.poll();
            String aNext = doA(cur, a);
            String bNext = doB(cur, b);
            if (seen.add(aNext)) queue.offer(aNext);
            if (seen.add(bNext)) queue.offer(bNext);
            if (ans.compareTo(cur) > 0) ans = cur;
        }

        return ans;
    }

    private static String doA(String s, int a){
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2)
            arr[i] = (char)((arr[i] - '0' + a) % 10 + '0');
        return String.valueOf(arr);
    }

    private static String doB(String s, int b){
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++)
            arr[i] = s.charAt((i - b % n + n) % n);
        return String.valueOf(arr);
    }
}
