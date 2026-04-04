class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnTop = 0;
        int rowLeft = 0;
        int columnBottom = matrix.length - 1;
        int rowRight = matrix[0].length - 1;

        while(columnTop<=columnBottom && rowLeft<=rowRight)
        {
            int columnMid = columnTop + (columnBottom - columnTop) / 2;
            if(matrix[columnMid][0] == target)
                return true;
            else if(matrix[columnMid][0] > target)
                columnBottom = columnMid - 1;
            else if(matrix[columnMid][0] < target && matrix[columnMid][matrix[0].length-1] < target)
                columnTop = columnMid + 1;
            else
            {
                int rowMid = rowLeft + (rowRight - rowLeft) / 2;
                if(matrix[columnMid][rowMid] == target) return true;
                else if(matrix[columnMid][rowMid] < target) rowLeft = rowMid + 1;
                else rowRight = rowMid - 1;
            }

        }
        return false;
    }
}
