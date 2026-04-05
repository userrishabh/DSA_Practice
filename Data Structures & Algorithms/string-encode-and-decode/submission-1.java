class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        for(int i=0; i<strs.size(); i++)
        {
            int length = strs.get(i).length();
            res.append(length + "#");
            res.append(strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        if(str.length() == 0)
            return new ArrayList<String>();
        StringBuilder tempString = new StringBuilder("");
        List<String> resString = new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int length = str.charAt(i) - '0';
            for(int j=i+2; j<=i+length+1; j++)
            {
                tempString.append(str.charAt(j));
            }
            resString.add(tempString.toString());
            tempString = new StringBuilder();
            i = i+length+2;
        }
        return resString;
    }
}
