class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        
        int row = board.length;
        int column = board[0].length;

        for(int r = 0; r < row; r++){
            if(board[r][0] == 'O') dfs(board, r, 0);
            if(board[r][column - 1] == 'O') dfs(board, r, column - 1);
        }
        for(int c = 0; c < column; c++){
            if(board[0][c] == 'O') dfs(board, 0, c);
            if(board[row - 1][c] == 'O') dfs(board, row - 1, c);
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                else if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int row, int column){
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] != 'O'){
            return;
        }

        board[row][column] = 'T';

        dfs(board, row + 1, column);
        dfs(board, row - 1, column);
        dfs(board, row, column - 1);
        dfs(board, row, column + 1);
    }
}
