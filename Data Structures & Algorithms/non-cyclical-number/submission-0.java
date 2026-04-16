class Solution {
    public boolean isHappy(int n) {
        if(n<=0) return false;

        int slow = n;
        int fast = getNextNumber(n);

        while(fast != 1 && fast != slow)
        {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return fast == 1;
    }

    int getNextNumber(int n)
    {
        int res = 0;

        while (n!=0)
        {
            int num = n%10;
            res += num*num;
            n = n/10;
        }

        return res;
    }
}
