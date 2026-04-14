class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
       if(!(str1+str2).equals(str2+str1)) return "";

       int validIndex = gcd(str1.length(), str2.length());
        
        return str1.substring(0,validIndex);
    }

    int gcd(int i, int j)
    {
        if(j==0) return i;

        return gcd(j, i%j);
    }
}