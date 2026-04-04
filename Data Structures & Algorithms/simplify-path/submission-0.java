class Solution {
    public String simplifyPath(String path) {
        Deque<String> resStack = new ArrayDeque<String>();
        String[] splitPath = path.split("/");

        for(int i=0; i<splitPath.length; i++)
        {
            if(splitPath[i].equals("") || splitPath[i].equals("."))
                continue;
            if(splitPath[i].equals(".."))
            {
                if(!resStack.isEmpty())
                    resStack.pop();
            }
            else{
                resStack.push(splitPath[i]);
            }
        }

        if(resStack.isEmpty())
            return "/";

        StringBuilder res = new StringBuilder();
        while(!resStack.isEmpty())
            res.append("/"+resStack.removeLast());

        return res.toString();
    }
}