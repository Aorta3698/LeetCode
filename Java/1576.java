class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '?'){
                char prev = i == 0? ' '  : arr[i - 1];
                char next = i == arr.length - 1? ' ' : arr[i + 1];
                char rep = 'a';
                for (int w = 0; w < 3; w++, rep = (char)(rep + 1))
                    if (rep != prev && rep != next)
                        break;
                arr[i] = rep;
            }
        }

        return String.valueOf(arr);
    }
}
