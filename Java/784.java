class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s.toCharArray(), 0, new char[s.length()], ans);
        return ans;
    }

    private static void backtrack(char[] arr, int idx, char[] tmp, List<String> ans){
        if (idx == arr.length){
            ans.add(String.valueOf(tmp));
            return;
        }

        if (Character.isDigit(arr[idx])){
            tmp[idx] = arr[idx];
            backtrack(arr, idx + 1, tmp, ans);
            return;
        }

        tmp[idx] = Character.toLowerCase(arr[idx]);
        backtrack(arr, idx + 1, tmp, ans);
        tmp[idx] = Character.toUpperCase(arr[idx]);
        backtrack(arr, idx + 1, tmp, ans);
    }
}
