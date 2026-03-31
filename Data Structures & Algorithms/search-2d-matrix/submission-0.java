class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int rowSearch = -1; 

        while(top <= bottom){
            int mid = top + (bottom - top) / 2;

            if(target > matrix[mid][columns - 1]){
                top = mid + 1;
            }
            else if(target < matrix[mid][0]){
                bottom = mid - 1;
            }
            else{
                rowSearch = mid;
                break;
            }
        }

        if(rowSearch == -1) return false;

        int start = 0;
        int end = columns - 1;

        int[] tab = matrix[rowSearch];

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == tab[mid]){
                return true;
            }
            else if(target < tab[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;
    }
}
