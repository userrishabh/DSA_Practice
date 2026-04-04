class Solution {
    public boolean exist(char[][] board, String word) {
     int row = board.length;
        int column = board[0].length;

        boolean[][] visited = new boolean[row][column];

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<column; j++)
            {
                if(board[i][j] == word.charAt(0)){
                boolean found = getWordSearch(board, word, visited, i, j, 0);
                if(found) return true;
                }
            }
        }

        return false;
    }

    boolean getWordSearch(char[][] board, String word, boolean[][] visited, int i, int j, int index)
    {
        if(word.length() == index)
        {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;

            visited[i][j] = true;

            if(getWordSearch(board, word, visited, i+1, j, index+1) || 
                getWordSearch(board, word, visited, i-1, j, index+1) ||
                getWordSearch(board, word, visited, i, j+1, index+1) ||
                getWordSearch(board, word, visited, i, j-1, index+1)
            )
            return true;

        visited[i][j] = false;
        return false;
    }
}
