class Solution {
    Solution[] prefix = new Solution[26];
    String word = "";
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0; i<words.length; i++)
        {
            Solution node = this;
            String temp = words[i];
            for(int j=0; j<temp.length(); j++)
            {
                int index = temp.charAt(j) - 'a';
                if(node.prefix[index] == null) node.prefix[index] = new Solution();
                node = node.prefix[index];
            }
            node.word = temp;
        }

        List<String> res = new ArrayList<>();

        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                backtrack(board, i, j, res, new boolean[board.length][board[0].length], this);

        return res;
    }

    void backtrack(char[][] board, int i, int j, List<String> res, boolean[][] visited, Solution node)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]) return;
        int index = board[i][j] - 'a';
        if(node.prefix[index] == null) return;
        if(!node.prefix[index].word.equals(""))
        {
            res.add(node.prefix[index].word);
            node.prefix[index].word = "";
            // we do not return here as usual backtracking because this can be a prefix of any other word
        }

        visited[i][j] = true;

        backtrack(board, i+1, j, res, visited, node.prefix[index]);
        backtrack(board, i, j+1, res, visited, node.prefix[index]);
        backtrack(board, i-1, j, res, visited, node.prefix[index]);
        backtrack(board, i, j-1, res, visited, node.prefix[index]);

        visited[i][j] = false;
    }
}
