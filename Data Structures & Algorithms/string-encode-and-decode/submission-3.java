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
            int j = i;
            while(str.charAt(j) != '#')
            {
                ++j;
            }
            int length = Integer.parseInt(str.substring(i,j));
            ++j;
            resString.add(str.substring(j, j+length));
            i = j+length;
        }
        return resString;
    }
}
