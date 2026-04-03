class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int c = matrix[0].length - 1;
        int pickRow = -1;

      while(top <= bottom){
        int mid = top + (bottom - top) / 2;

        if(target > matrix[mid][c]){
            top = mid + 1;
        }
         else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                // This means: matrix[mid][0] <= target <= matrix[mid][c]
                pickRow = mid;
                break;
            }
      }
      if(pickRow == -1) return false;

      int left = 0;
      int right = c;

      while(left <= right){
        int mid = left + (right - left) / 2;

        if(target == matrix[pickRow][mid]) return true;

        if(target < matrix[pickRow][mid]){
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
      }
      return false;
    }
}
