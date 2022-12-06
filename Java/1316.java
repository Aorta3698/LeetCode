https://leetcode.com/problems/distinct-echo-substrings/discuss/2467581/Clean-Java-or-Sliding-Window
class Solution {
    public int distinctEchoSubstrings(String text) {
        int ans = 0, n = text.length()/2;
        for (int i = 1; i <= n; i++){
            Set<String> seen = new HashSet<>();
            for (int j = 0, k = j+i, ok = 0; k < text.length(); j++, k++){
                if (text.charAt(j) == text.charAt(k)){
                    ok++;
                }
                if (j >= i && text.charAt(j-i) == text.charAt(k-i)){
                    ok--;
                }
                if (j >= i-1 && ok == i && seen.add(text.substring(j-i+1,j+1))){
                    ans++;
                }
            }
        }
        return ans;
    }
}



class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int ans = 0;
        int p = 31;
        int M = (int)1e9+7;
        long h = 1;
        long[] m = new long[n/2+1];
        for (int i = 0; i < m.length; i++){
            m[i]=h;
            h=h*p%M;
        }
        for (int i = 1; i <= n/2; i++){
            Set<Long> seen = new HashSet<>();
            long a = 0;
            long b = 0;
            for (int j = 0, k = i; k < n; j++,k++){
                a = (a * p + text.charAt(j) - 'a' + 1) % M;
                b = (b * p + text.charAt(k) - 'a' + 1) % M;
                if (j >= i){
                    a = ((a - m[i]*(text.charAt(j-i) - 'a' + 1))%M + M)%M;
                    b = ((b - m[i]*(text.charAt(k-i) - 'a' + 1))%M + M)%M;
                }
                if (j >= i-1 && a == b && !seen.contains(a)){
                    seen.add(a);
                }
            }
            ans+=seen.size();
        }
        return ans;
    }
}

class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int ans = 0;
        int p = 31;
        int M = (int)1e9+7;
        long h = 1;
        long[] m = new long[n/2+1];
        for (int i = 0; i < m.length; i++){
            m[i]=h;
            h=h*p%M;
        }
        long aa = 0;
        long bb = 0;
        for (int i = 1; i <= n/2; i++){
            Set<Long> seen = new HashSet<>();
            long a = aa;
            long b = bb;
            for (int j = i-1, k = 2*i-1; k < n; j++,k++){
                a = (a * p + text.charAt(j)) % M;
                b = (b * p + text.charAt(k)) % M;
                if (j >= i){
                    a = ((a - m[i]*text.charAt(j-i))%M + M)%M;
                    b = ((b - m[i]*text.charAt(k-i))%M + M)%M;
                }
                if (j >= i-1 && a == b && !seen.contains(a)){
                    seen.add(a);
                }
                if (j == i-1){
                    aa=a;
                }
                if (j == i){
                    bb=b;
                }
            }
            ans+=seen.size();
        }
        return ans;
    }
}
