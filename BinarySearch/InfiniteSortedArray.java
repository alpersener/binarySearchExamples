package BinarySearch;

public class InfiniteSortedArray {
    public static void main(String[] args) {
       int[] arr={3,5,7,9,10,90,100,130,140,160,170};
       int target=10;
        System.out.println(ans(arr,target));


    }

    static int ans(int[] arr,int target) {
        //first find the range
        //first start with a box of size 2
        int low = 0;
        int high = 1;

        //condition for the target to lie in the range
        while(target>arr[high]){
            int newLow=high+1; //temp olarak kullanıyoruz aslında.
            //double the box value
            //high=previous high+sizeofbox*2 yani high değeri ile kaçarlı aldığımızın 2 katını toplayıp yeni high değeri
            high=high+(high-low+1)*2;
            low=newLow;
        }
        return binarySearch(arr,target,low,high);
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
