class Solution {
    public int minimumBuckets(String street) {
        char[] arr = street.toCharArray();
        if (arr.length == 1 && arr[0] == 'H') return -1;
        if (arr[0] == 'H' && arr[1] == 'H') return -1;
        if (arr[arr.length - 1] == 'H' && arr[arr.length - 2] == 'H') return -1;

        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] == 'H' && arr[i - 1] == 'H' && arr[i + 1] == 'H') return -1;
        }

        int count = 0;
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] == '.' && arr[i - 1] == 'H' && arr[i + 1] == 'H'){
                count++;
                arr[i - 1] = 'x';
                arr[i + 1] = 'x';
            }
        }

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 'H') count++;

        return count;
    }
}
