class Solution {
    public int maxProfit(int[] prices) {
        
    int minPrice = Integer.MAX_VALUE;
    int output = 0;

    for(Integer k : prices){
        if(k < minPrice){
            minPrice = k;
        }
        if((k - minPrice) > output){
            output = k - minPrice;
        }
    }
    return output;
    }
}
