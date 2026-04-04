class Solution {
    public boolean validPalindrome(String s) {
     int count = 0;
        int j = s.length()-1;
        int i = 0;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
               break;
               i++;
               j--;
        }
        int updatedI = i+1;
        int updatedJ = j-1;
        boolean validPalindrom1 = true;
        boolean validPalindrom2 = true;

        while(updatedI<j)
        {
            if(s.charAt(updatedI) != s.charAt(j))
                {validPalindrom1 = false;
                    break;}
                  updatedI++;
                  j--;  
        }
        while(i<updatedJ)
        {
            if(s.charAt(i) != s.charAt(updatedJ))
                {validPalindrom2 = false;
                    break;}
                    updatedJ--;
                    i++;
        }


        return validPalindrom1 || validPalindrom2;
    }
}