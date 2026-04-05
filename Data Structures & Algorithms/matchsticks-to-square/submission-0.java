class Solution {
   public boolean makesquare(int[] matchsticks) {
        int target = 0;

        for(int i=0; i<matchsticks.length; i++)
        {
            target += matchsticks[i];
        }

        if(target%4 != 0) return false;
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }
        return isValidStick(matchsticks, target/4, 0, new int[4]);
    }

    boolean isValidStick(int[] matchsticks, int target, int index, int[] sides)
    {
        if(matchsticks.length == index)
        {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int stick = matchsticks[index];

        for(int i=0; i<4; i++)
        {
            if(sides[i] + stick <= target)
            {
                sides[i] += stick;
                if(isValidStick(matchsticks, target, index+1, sides)) return true;

                sides[i] -= stick;
            }
        }

        return false;
    }
}