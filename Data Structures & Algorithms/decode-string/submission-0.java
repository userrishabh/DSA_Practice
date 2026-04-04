class Solution {
    public String decodeString(String s) {
        int countNum = 0;
        StringBuilder currentString = new StringBuilder();
        Deque<String> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)>= 'a' && s.charAt(i) <= 'z')
            {
                currentString.append(s.charAt(i));
            }
            else if(s.charAt(i) == '[')
            {
                dq.push(currentString.toString());
                dq.push(Integer.toString(countNum));
                countNum = 0;
                currentString = new StringBuilder();
            }
            else if(s.charAt(i) == ']')
            {
                int repeatcount= Integer.parseInt(dq.pop());
               String tempStr = dq.pop();
                while(repeatcount>0)
                {
                    tempStr += currentString.toString();
                    repeatcount--;
                }

                currentString = new StringBuilder(tempStr);
            }
            else
            {
                countNum = countNum*10 + (s.charAt(i)-'0');
            }
        }
        return currentString.toString();
    }
}