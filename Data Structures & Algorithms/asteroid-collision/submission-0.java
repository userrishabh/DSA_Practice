class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++)
        {
            if(st.isEmpty() || asteroids[i] >= 0)
            {
                st.push(asteroids[i]);
            }
            else
            {
                boolean isBothExploded = false;
                while(!st.isEmpty() && st.peek() >= 0 && Math.abs(asteroids[i])>=st.peek())
                {
                   if(st.pop() == Math.abs(asteroids[i]))
                   {
                    isBothExploded = true;
                    break;
                   }

                }
                if((st.isEmpty() || st.peek() < 0) && !isBothExploded)
                {
                    st.push(asteroids[i]);
                }
            }
        }
        int [] res = new int[st.size()];
        int count = st.size() - 1;
        while(!st.isEmpty())
        {
            res[count] = st.pop();
            count--;
        }

        return res;
    }
}