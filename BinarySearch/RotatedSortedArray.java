package BinarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {



    }

    public static int search(int[] nums, int target,int low,int high) {
        int pivot=findPivot(nums);
        if(pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        //if pivot is found we have found 2 ascending sorted array
        //first case
        if(nums[pivot]==target)
            return pivot;
        if (target >= nums[0]) {
            return binarySearch(nums,target,0,pivot-1);
        }
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }
    private static int binarySearch(int[] arr, int target,int low,int high) {
        while(low<=high){
            int middle=low+(high-low)/2;
            System.out.println("middle:"+arr[middle]);
            if(target<arr[middle])
                high=middle-1;
            else if (target > arr[middle]) {
                low=middle+1;
            }
            else
                return middle;
        }
        return -1;
    }
    public static int findPivot(int[] arr){
        int low=0;
        int high=arr.length-1;
       while (low <= high) {
           int midddle=low+(high-low)/2;
           //4 cases over there
           //1st case
           if(midddle<high && arr[midddle]>arr[midddle+1])
               return midddle;
           //2nd case
           if(midddle>low && arr[midddle]<arr[midddle-1])
               return midddle-1;
           //3rd case
           if(arr[midddle]<=arr[low]) {
               high = midddle - 1;
           }
           else{
               low=midddle+1;
           }
       }
        return -1;
   }
}
