class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];

        for(int k : prices){
            if(k < min){
                min = k;
            }
            if((k - min) > res){
                res = (k - min);
            }
        }
        return res;
    }
}
