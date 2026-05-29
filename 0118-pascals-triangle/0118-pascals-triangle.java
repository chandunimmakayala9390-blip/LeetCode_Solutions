import java.util.*;
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> lis=new ArrayList<>();
        for(int i=1;i<=n;i++){
            lis.add(generate_row(i));
        }
        return lis;
    }
    private List<Integer>generate_row(int r){
        List<Integer>lis=new ArrayList<>();
        lis.add(1);
        for(int i=1;i<r;i++){
            lis.add(lis.get(i-1)*(r-i)/(i));
        }
        return lis;
    }
}