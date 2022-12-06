int[] scnt = new int[26];
int[] tcnt = new int[26];
for (char ch : s.toCharArray()){
    scnt[ch - 'a']++;
}

int ans = s.length();
for (char ch : t.toCharArray()){
    ans = Math.min(ans, scnt[ch - 'a']/++tcnt[ch - 'a']);
}

return ans;
