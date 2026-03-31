class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> set = new HashSet<>();

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
             
                if(board[row][col] != '.'){
                char currV = board[row][col];

                String colP = col + "c" + currV;
                String rowP = row + "r" + currV;
                String box = row/3 + "-" + col/3 + "b" + currV;

                if(!set.add(colP) || !set.add(rowP) || !set.add(box)) return false;
                }
                
            }
        }
        return true;
    }
}
