class WordDictionary {
WordDictionary[] prefix;
    boolean isLast;
    public WordDictionary() {
        prefix = new WordDictionary[26];
        isLast = false;
    }
    
    public void addWord(String word) {
        WordDictionary node = this;

        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(node.prefix[index] == null) node.prefix[index] = new WordDictionary();
            if(i == (word.length()-1)) node.prefix[index].isLast = true;

            node = node.prefix[index];
        }
    }

    boolean backtrackDfs(String word, int index, WordDictionary node)
    {
        if(index == word.length())
            return node.isLast;
        
        char ch = word.charAt(index);

        if(ch != '.')
        {
            int i = ch-'a';
            if(node.prefix[i] == null) return false;

            return backtrackDfs(word, index+1, node.prefix[i]);
        }

        else
        {
            for(int k=0; k<26; k++)
            {
                if(node.prefix[k] != null)
                {
                    if(backtrackDfs(word, index+1, node.prefix[k])) return true;
                }
            }
            return false;
        }
    }
    
    public boolean search(String word) {
        return backtrackDfs(word, 0, this);
    }
}
