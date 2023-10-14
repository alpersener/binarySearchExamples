package BinarySearch;

public class SearchInMountainHardLeetCode {
    public static void main(String[] args) {
        int[] arr={0,1,2,4,2,1};
        int target=3;
        System.out.println(search(arr,target));

    }

    static int search(int[] arr,int target){
       int peak= peakIndexInMountainArray(arr);
       int firstAttempt=orderAgnosticBs(arr,target,0,peak);
       if(firstAttempt!=-1){
           return firstAttempt;
       }
      //try to search other half
        return orderAgnosticBs(arr,target,peak+1,arr.length-1);

    }
    static int orderAgnosticBs(int[] array,int target,int low,int high){
        //find whether the array ascending or descending
        boolean isAsc=array[low] < array[high];
        /*yöntem 2
        boolean isAsc;
        if (array[low] < array[high]){
            isAsc=true;
        }
        else{
            isAsc=false;
        }
        */
        while(low<=high){
            int middle=low+(high-low)/2;
            System.out.println("Middle:"+array[middle]);

            if (target == array[middle]) {
                return middle;
            }
            if(isAsc){
                if(target<array[middle])
                    high=middle-1;
                else
                    low=middle+1;
            }
            else {
                if(target>array[middle])
                    high=middle-1;
                else
                    low=middle+1;
            }
        }
        return -1;
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int middle=low+(high-low)/2;

            if(arr[middle]>arr[middle+1]){
                //descending part of array
                //maybe answer here but look at left
                high=middle;
            }else {
                //ascending part of array
                low=middle+1;
            }

        }
        //en sonunda low==high olursa largest number bulunur yukarıdaki 2 check işleminden dolayı
        //low ve high her zaman maximum elementi bulmaya çalışır yukarıdaki 2 check işleminden dolayı
        //bundan dolayı bunlar tek elementi işaret eder ve büyük bulunur
        return low; //ya da high döndür çünkü ikisi de aynı yeri gösteriyor zaten.

    }

    private static int binarySearch(int[] arr, int target,int low,int high) {
        while(low<=high){
            int middle=low+(high-low)/2;
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



}
