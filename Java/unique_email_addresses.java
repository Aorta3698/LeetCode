class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (String e : emails){
            StringBuilder sb = new StringBuilder();
            int val = 0, key = 0, i = 0;
            char[] arr = e.toCharArray();
            for (; arr[i] != '@'; i++){
                if (arr[i] == '+') break;
                if (arr[i] != '.') sb.append(arr[i]);
            }

            val = sb.toString().hashCode();
            sb.setLength(0);
            for (i = e.indexOf("@"); i < arr.length; i++)
                sb.append(arr[i]);
            key = sb.toString().hashCode();

            map.computeIfAbsent(key, o -> new HashSet<>()).add(val);
        }

        int ans = 0;
        for (Set<Integer> set : map.values())
            ans += set.size();

        return ans;
    }
}
