class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<operations.length; i++)
        {
            switch(operations[i])
               { case "C":
                    st.pop();
                    break;
                case "D":
                    int tempScore = st.peek();
                    st.push(tempScore*2);
                    break;
                case "+":
                    int nums1 = st.peek();
                    st.pop();
                    int nums2 = st.peek();
                    st.push(nums1);
                    st.push(nums1+nums2);
                    break;
                default:
                    st.push(Integer.parseInt(operations[i]));
               }
        }
        int resSum = 0;
        while(!st.isEmpty())
            {
                resSum += st.peek();
                st.pop();
            }
        return resSum;
    }
}