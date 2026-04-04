class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case ')':
                    if(st.isEmpty() || st.pop() != '(') return false;
                    break;
                case '}':
                    if(st.isEmpty() || st.pop() != '{') return false;
                    break;
                case ']':
                    if(st.isEmpty() || st.pop() != '[') return false;
                    break;
                default:
                    st.push(ch);
            }
        }

        if(!st.isEmpty())
            return false;
        return true;
    }
}
