class NumMatrix {
    int[][] prefixSumArray;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        prefixSumArray = new int[row][col];

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(j==0)
                    prefixSumArray[i][j] = matrix[i][j];
                else
                    prefixSumArray[i][j] = matrix[i][j]+prefixSumArray[i][j-1];
            }
        }

        for(int i=0; i<col; i++)
        {
            for(int j=0; j<row; j++)
            {
                if(j==0)
                    prefixSumArray[j][i] = prefixSumArray[j][i];
                else
                    prefixSumArray[j][i] = prefixSumArray[j][i]+prefixSumArray[j-1][i];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // for(int num : prefixSumArray[2])
        //     System.out.println(num);
        if(row1==0 && col1==0)
            return prefixSumArray[row2][col2];
        else if(row1 == 0)
            return prefixSumArray[row2][col2] - prefixSumArray[row2][col1-1];
        else if(col1 == 0)
            return prefixSumArray[row2][col2] - prefixSumArray[row1-1][col2];
        else
            return prefixSumArray[row2][col2] - prefixSumArray[row1-1][col2] - prefixSumArray[row2][col1-1] + prefixSumArray[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */