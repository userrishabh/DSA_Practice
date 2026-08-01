class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strs.size(); i++)
        {
            String temp = strs.get(i);
            sb.append(temp.length());
            sb.append('#');
            sb.append(temp);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        int len = str.length();
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i<len)
        {
            int j = i;

            while(str.charAt(j) != '#')
                j++;
            
            int subStrLength = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, subStrLength+j));

            i = subStrLength+j;
        }

        return res;
    }
}
