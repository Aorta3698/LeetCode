class Solution {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != '?') continue;
            if (i == 0 && ('3' >= arr[1] || arr[1] == '?')) arr[i] = '2';
            if (i == 0 && arr[1] != '?' && arr[1] > '3') arr[i] = '1';
            if (i == 1 && arr[0] == '2') arr[i] = '3';
            if (i == 1 && arr[0] != '2') arr[i] = '9';
            if (i == 3) arr[i] = '5';
            if (i == 4) arr[i] = '9';
        }

        return String.valueOf(arr);
    }
}
