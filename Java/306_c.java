class Solution {
    public String smallestNumber(String pattern) {
        Queue<Item> queue = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++){
            queue.offer(new Item(i));
        }
        for (char ch : pattern.toCharArray()){
            Queue<Item> nq = new ArrayDeque<>();
            for (Item item : queue){
                if (ch == 'I'){
                    int j = item.sb.charAt(item.sb.length()-1)-'0';
                    for (int val=j+1; val <= 9; val++){
                        if ((item.hash & 1<<val)==0){
                            Item nitem = new Item();
                            nitem.sb=new StringBuilder(item.sb);
                            nitem.hash=item.hash;
                            nitem.sb.append(val);
                            nitem.hash|=1<<val;
                            nq.offer(nitem);
                        }
                    }
                }else{
                    int j = item.sb.charAt(item.sb.length()-1)-'0';
                    for (int val=j-1; val > 0; val--){
                        if ((item.hash & 1<<val)==0){
                            Item nitem = new Item();
                            nitem.sb=new StringBuilder(item.sb);
                            nitem.hash=item.hash;
                            nitem.sb.append(val);
                            nitem.hash|=1<<val;
                            nq.offer(nitem);
                        }
                    }
                }
            }
            queue=nq;
        }
        List<String> all = new ArrayList<>();
        for (Item item : queue){
            all.add(item.sb.toString());
        }
        Collections.sort(all);
        return all.get(0);
        // int ic = 0, dc;
        // for (char ch : pattern.toCharArray()){
        //     if (ch == "I"){
        //         ic++;
        //     }else{
        //         dc++;
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // int prev = 1;
        // for (int i = 0; i < pattern.length()-1; i++){
        //     if (pattern.charAt(i)=='I' && pattern.charAt(i) =='D'){
        //         int jump = 0;
        //         for (int j = i+1; j < pattern.length(); j++){
        //             if (pattern.charAt(j) == 'D'){
        //                 jump++;
        //             }else{
        //                 break;
        //             }
        //         }
        //         sb.append(prev+jump+1);
        //         prev=prev+jump+1;
        //     }else if (pattern.charAt(i)=='D'){
        //         int d = 0;
        //         for (int j = i; j < pattern.length(); j++){
        //             if (pattern.charAt(j)=='D'){
        //                 d++;
        //             }else{
        //                 break;
        //             }
        //         }
        //         sb.append(prev+d);
        //         prev=prev+d;
        //     }else if (pattern.charAt(i)=='D'){
        //         sb.append(prev-1);
        //         prev--;
        //     }else if (pattern.charAt(i)=='I'){
        //         sb.append(prev+1);
        //         prev++;
        //     }
        // }
        // return sb.toString();
    }

    class Item{
        StringBuilder sb = new StringBuilder();
        int hash = 0;
        Item(int i){
            sb.append(i);
            hash |= 1<<i;
        }
        Item(){}
    }
}
