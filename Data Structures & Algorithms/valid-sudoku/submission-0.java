class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for(int i = 0;i<9; i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] == '.')
                    continue;
                
                String rowKey = i + "R" + board[i][j];
                String colKey = j + "C"+ board[i][j];
                String boxKey = i/3 + "Box" + j/3 + board[i][j];

                if(!hs.add(rowKey))
                    return false;
                if(!hs.add(colKey))
                    return false;
                if(!hs.add(boxKey))
                    return false;
            }
        }
        return true;
    }
}
