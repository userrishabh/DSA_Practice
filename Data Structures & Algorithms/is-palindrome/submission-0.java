class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j=s.length()-1;
                System.out.println(j);
        
        while(i<j)
        {
            char tempLeft = s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ? (char)('a' + s.charAt(i) - 'A') : s.charAt(i);
            char tempRight = s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' ? (char)('a' + s.charAt(j) - 'A') : s.charAt(j);
            System.out.println("hey - " + tempLeft + " " + tempRight);
            if(!((tempLeft >= '0' && tempLeft <= '9') || (tempLeft >= 'A' && tempLeft <= 'Z') || (tempLeft >= 'a' && tempLeft <= 'z' )))
                {i++; continue;}
            if(!((tempRight >= '0' && tempRight <= '9') || (tempRight >= 'A' && tempRight <= 'Z') || (tempRight >= 'a' && tempRight <= 'z' )))
                {j--; continue;}
            if(tempLeft != tempRight)
            {
                System.out.println(i + " " + j);
                System.out.println(tempLeft + " " + tempRight);
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
