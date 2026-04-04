class TimeMap {
class Pair {
        int timeStamp;
        String value;
        Pair(int timeStamp, String value)
        {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }
    HashMap<String,List<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> tempList = new ArrayList<>();
        if(hm.containsKey(key))
            tempList = hm.get(key);
        tempList.add(new Pair(timestamp, value));
        hm.put(key, tempList);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key))
            return "";
        List<Pair> pairedValue = hm.get(key);
        int left = 0;
        int right = pairedValue.size() - 1;
        String ans = "";
        while(left<=right)
        {
            int mid = left + (right-left) / 2;
            Pair element = pairedValue.get(mid);
            if(element.timeStamp == timestamp)
                return element.value;
            else if(timestamp < element.timeStamp)
                right = mid-1;
            else
                {left = mid+1;
                ans = element.value;}

        }

        return ans;
    }
}
