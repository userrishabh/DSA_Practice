class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> storingIndexOfIncreasingElements = new Stack<>();
        int largestRectangle = 0;

        for(int i=0; i<heights.length; i++)
        {
            while(!storingIndexOfIncreasingElements.isEmpty() && heights[i] <= heights[storingIndexOfIncreasingElements.peek()])
            {
                int top = storingIndexOfIncreasingElements.pop();
                int width = i;
                if(!storingIndexOfIncreasingElements.isEmpty())
                    width =  width - storingIndexOfIncreasingElements.peek() - 1;

                largestRectangle = Math.max(largestRectangle, heights[top]*width); 
            }

            storingIndexOfIncreasingElements.push(i);
        }

        while(!storingIndexOfIncreasingElements.isEmpty())
        {
            int top = storingIndexOfIncreasingElements.pop();
            int width = heights.length;

            if(!storingIndexOfIncreasingElements.isEmpty())
                width =  width - storingIndexOfIncreasingElements.peek() - 1; 
            
            largestRectangle = Math.max(largestRectangle, heights[top]*width); 
        }

        return largestRectangle;
    }
}
