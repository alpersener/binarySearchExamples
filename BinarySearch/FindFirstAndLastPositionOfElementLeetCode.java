package BinarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementLeetCode {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=7;
        int[] output=searchRange(nums,target);
        System.out.println(Arrays.toString(output));

    }


    public static int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        //check of first occurence if target first
        int low=search(nums,target,true);
        int high=search(nums,target,false);

        ans[0]=low;
        ans[1]=high;
        return ans;



    }

    //this function return index value of target
    static int search(int[] nums,int target,boolean findStartIndex) {
        int ans=-1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            System.out.println("middle:" + nums[middle]);
            if (target < nums[middle])
                high = middle - 1;
            else if (target > nums[middle]) {
                low = middle + 1;
            } else{
                //potential ans
                ans=middle;
                if(findStartIndex){
                    high=middle-1;
                }
                else
                    low=middle+1;
            }


        }
        return ans;
    }

}
