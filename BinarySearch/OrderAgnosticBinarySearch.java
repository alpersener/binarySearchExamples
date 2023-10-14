package BinarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] arr={-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int[] arr={99,80,75,22,11,10,5,2,-3};
        int target=22;
        int ans=orderAgnosticBs(arr,target);
        System.out.println(ans);

    }

    static int orderAgnosticBs(int[] array,int target){
        int low=0;
        int high=array.length-1;
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

    }


