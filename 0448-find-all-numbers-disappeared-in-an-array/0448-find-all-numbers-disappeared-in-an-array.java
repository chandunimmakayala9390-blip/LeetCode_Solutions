import java.util.List;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean seen[]=new boolean[nums.length+1];
        seen[0]=true;
        List<Integer> lis=new ArrayList<>();
        for(int i:nums)
        {
            seen[i]=true;
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(!seen[i])
            {
                lis.add(i);
            }
        }
        return lis;
    }
}