class PrefixTree {
PrefixTree[] prefixTree;
        boolean isLast;
    public PrefixTree() {
        prefixTree = new PrefixTree[26];
        isLast = false;
    }
    
    public void insert(String word) {
        PrefixTree node = this;
        for(int i=0; i<word.length(); i++)
        {
            if(node.prefixTree[word.charAt(i) - 'a'] == null)
                node.prefixTree[word.charAt(i) - 'a'] = new PrefixTree();
            if(i == (word.length()-1)) 
                node.prefixTree[word.charAt(i) - 'a'].isLast = true;

            node = node.prefixTree[word.charAt(i) - 'a'];
        }
    }
    
    public boolean search(String word) {
        PrefixTree node = this;
        for(int i = 0; i<word.length(); i++)
        {
            if(node.prefixTree[word.charAt(i) - 'a'] == null) return false;
            if(i == (word.length()-1) && node.prefixTree[word.charAt(i) - 'a'].isLast == false)
            return false;
            node = node.prefixTree[word.charAt(i) - 'a'];
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for(int i=0; i<prefix.length(); i++)
        {
            if(node.prefixTree[prefix.charAt(i) - 'a'] == null) return false;
            node = node.prefixTree[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
