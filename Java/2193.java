https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/discuss/2399882/Java-or-O(NlogN)-or-Harder-Variant-of-1505.
class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] A = s.toCharArray();
        Deque<Integer>[] deque = new ArrayDeque[26];
        Arrays.setAll(deque, o -> new ArrayDeque<>());
        for (int i = 0; i < A.length; i++){
            deque[A[i]-'a'].offer(i);
        }
        int[] head = new int[A.length+1];
        int[] tail = new int[A.length+1];
        int i = 0, j = s.length()-1, ans = 0;
        while(i < j){
            int min = (int)1e9, idx = -1;
            for (int k = 0; k < 26; k++){
                if (deque[k].size()>=2){
                    int L = deque[k].peekFirst(), R = deque[k].peekLast();
                    int a = L - i + (i - sum(head, L)) - sum(tail, L);
                    int b = j - R + sum(tail, R) - (i - sum(head, R));
                    if (a+b < min){
                        min=a+b;
                        idx=k;
                    }
                }
            }
            ans += min;
            add(head, deque[idx].pollFirst(), 1);
            add(tail, deque[idx].pollLast(), 1);
            i++;
            j--;
        }

        return ans;
    }

    private void add(int[] bit, int idx, int inc){
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx]+=inc;
        }
    }

    private int sum(int[] bit, int idx){
        int ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}
