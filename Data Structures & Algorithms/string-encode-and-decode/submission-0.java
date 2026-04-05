class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        for(int i=0; i<strs.size(); i++)
        {
            if(res.length() > 0)
                res.append("-1");
            res.append(strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        // if(str.length() == 0)
        //     return new ArrayList<String>();

        return new ArrayList<>(Arrays.asList(str.split("-1")));
    }
}
