package Insta;

import java.util.HashSet;

public class May2nd {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int ans=-1;
        for(int i=0;i< nums.length;i++){
            if(hs.contains(nums[i]*-1)){
                if(Math.abs(nums[i])>ans){
                    ans=Math.abs(nums[i]);
                }
            }
            else{
                hs.add(nums[i]);
            }
        }
       return ans;
    }
}
