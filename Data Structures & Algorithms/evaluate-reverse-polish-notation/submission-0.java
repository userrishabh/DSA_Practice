class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++)
        {
            String temp = tokens[i];
            switch(temp)
            {
                case "+":
                st.push(st.pop() + st.pop());
                break;
                case "-":
                int subNum1 = st.pop();
                int subNum2 = st.pop();
                st.push(subNum2 - subNum1);
                    break;
                case "*":
                st.push(st.pop() * st.pop());
                break;
                case "/":
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num2 / num1);
                    break;
                default:
                    st.push(Integer.parseInt(temp));
            }
        }
        return st.pop();
    }
}
