class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j] = '.';

        getValidBoard(board, result, n, 0);
        return result;
    }

    void getValidBoard(char[][] board, List<List<String>> result, int length, int row)
    {
        if(row == length)
        {
            result.add(construct(board));
            return;
        }

        for(int col=0; col<length; col++)
        {
            if(isValidPosition(board, row, col))
            {
                board[row][col] = 'Q';
                getValidBoard(board, result, length, row+1);
                board[row][col] = '.';
            }
        }
    }

    List<String> construct(char[][] board)
    {
        List<String> res = new ArrayList<>();
        for(char[] ch : board)
            res.add(new String(ch));
        return res;
    }


    boolean isValidPosition(char[][] board, int row, int col)
    {
        for(int i = row-1; i>=0; i--)
        {
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row-1, j = col+1; i>=0 && j<board.length; i--, j++ )
        {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j-- )
        {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
