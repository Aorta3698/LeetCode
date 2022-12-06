class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0;
        while(i < buses.length&&j<passengers.length){
            int count = 0;
            while(j<passengers.length&&buses[i]>=passengers[j]&&count<capacity){
                j++;
                count++;
            }
            i++;
            if(i==buses.length){
                --j;
                if (capacity==count){
                    while(j>0&&passengers[j-1]+1==passengers[j]){
                        --j;
                    }
                    return passengers[j]-1;
                }else{
                    int ans = buses[buses.length-1];
                    while(j>=0&&passengers[j]==ans){
                        j--;
                        ans--;
                    }
                    return ans;
                }
            }
        }
        return buses[buses.length-1];
    }
}
