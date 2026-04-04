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
        int i1 = i + 1;
        int j1 = j;
        boolean validPalindrom1 = true;
        boolean validPalindrom2 = true;

        while(i1<j1)
        {
            if(s.charAt(i1) != s.charAt(j1))
                {validPalindrom1 = false;
                    break;}
                  i1++;
                  j1--;  
        }
        int i2 = i;
    int j2 = j - 1;
        while(i2<j2)
        {
            if(s.charAt(i2) != s.charAt(j2))
                {validPalindrom2 = false;
                    break;}
                    j2--;
                    i2++;
        }


        return validPalindrom1 || validPalindrom2;
    }
}