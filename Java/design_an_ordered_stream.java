class OrderedStream {

    String[] arr;
    int ptr;
    public OrderedStream(int n) {
        arr = new String[n+1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        arr[idKey] = value;
        while(ptr < arr.length && arr[ptr] != null)
            ans.add(arr[ptr++]);

        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
