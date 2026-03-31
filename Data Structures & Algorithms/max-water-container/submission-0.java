class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int maxArea = 0;
        while(start < end){
            int width = end - start;
            int height = Math.min(heights[start], heights[end]);
            int maxAreaInside = width * height;
            if(maxArea < maxAreaInside){
                maxArea = maxAreaInside;
            }
            if(heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}
