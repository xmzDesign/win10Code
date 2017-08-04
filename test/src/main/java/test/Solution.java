package test;

import java.util.Arrays;

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
           
            int extra=target-nums[i];
            for(int j=0;j<nums.length;j++){
                if(extra==nums[j]&&j!=i){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums={-1,-2,-3,-4,-5};
		int[] twoSum = twoSum(nums,-8);
		System.out.println(twoSum[0]+" "+twoSum[1]);
	}

}
