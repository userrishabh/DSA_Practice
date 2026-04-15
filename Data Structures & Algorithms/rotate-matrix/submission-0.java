class Solution {
    public void rotate(int[][] matrix) {
     int n = matrix.length;

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int tempNum = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempNum;
            }

            int left = 0;
            int right = n-1;

            while(left<right)
            {
                int tempNum = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tempNum;
                left++;
                right--;
            }
        }
    }
}
