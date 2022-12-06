class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> deadSet = new HashSet<>();
        for (String str : deadends) deadSet.add(Integer.parseInt(str));
        if (deadSet.contains(0)) return -1;

        queue.offer(0);
        set.add(0);
        int dis = 0;

        while(!queue.isEmpty()){
            if (set.contains(Integer.parseInt(target)))
                return dis;

            dis++;
            int size = queue.size();

            for (int k = 0; k < size;k++){
                int cur = queue.poll();

                for (int i = 0; i < 8; i++){
                    int next = switch(i){
                        case 0 : yield (cur+1000)%10000;
                        case 1 : yield (cur-1000+10000)%10000;
                        case 2 : yield (cur+100)%1000+cur/1000*1000;
                        case 3 : yield (cur-100+1000)%1000+cur/1000*1000;
                        case 4 : yield (cur+10)%100+cur/100*100;
                        case 5 : yield (cur-10+100)%100+cur/100*100;
                        case 6 : yield (cur+1)%10+cur/10*10;
                        case 7 : yield (cur-1+10)%10+cur/10*10;
                        default : yield -1;
                    };

                    if(deadSet.contains(next)) continue;
                    if(set.add(next))queue.offer(next);
                }
            }
        }

        return -1;
    }
}
