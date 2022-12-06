class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] valid = new boolean[s.length()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') stack.push(i);
            if (s.charAt(i) == ')' && !stack.isEmpty())
                valid[i] = valid[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++)
            if (valid[i] || Character.isLetter(s.charAt(i)))
                sb.append(s.charAt(i));

        return sb.toString();
    }
}

// approach 2:
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int d = rev(arr, '(', ')') + rev(arr, ')', '(');
        char[] ans = new char[arr.length - d];
        for (int i = 0, j = 0; i < arr.length; i++){
            if (arr[i] == '.') continue;
            ans[j++] = arr[i];
        }

        return String.valueOf(ans);
    }

    private int rev(char[] arr, char t, char c){
        int n = arr.length,
            start = t == '('? 0 : n - 1,
            d = t == '('? 1 : -1,
            count = 0,
            ans = 0;

        for (int i = start; i >= 0 && i < n; i += d){
            if (arr[i] != t && arr[i] != c) continue;
            count += arr[i] == t? 1 : -1;
            if (count < 0){
                count = 0;
                ans++;
                arr[i] = '.';
            }
        }

        return ans;
    }
}
