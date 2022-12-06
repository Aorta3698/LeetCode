class Solution {
    public int countDistinct(String s) {
        Set<String> seen = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j <= i; j++)
                if (seen.add(s.substring(j, i + 1)))
                    ans++;
        return ans;
    }
}
