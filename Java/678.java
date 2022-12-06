class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        if (s.length() % 2 == 0){
            return check(arr, 1) && check(arr, -1);
        }

        for (int j = 0; j < arr.length; j++){
            if (arr[j] != '*'){
                continue;
            }
            arr[j]++;
            if (check(arr, 1) && check(arr, -1)){
                return true;
            }
            arr[j]--;
        }

        return false;
    }

    private boolean check(char[] arr, int d){
        int i = d == 1? 0 : arr.length - 1, ok = 0;
        for (; i >= 0 && i < arr.length && ok >= 0; i += d){
            if (arr[i] == '('){
                ok += d;
            }else if (arr[i] == ')'){
                ok -= d;
            }else if (arr[i] == '*'){
                ok++;
            }
        }
        return ok >= 0;
    }
}
