package BinarySearch;

//Yani target'dan sonraki en büyük eleman hangi indexte?
public class CeilingOfANumberQuestion {
    public static void main(String[] args) {
        int[] arr={2, 3, 5, 9, 14, 16, 18};
        int target=6;
        int ans=binarySearch(arr,target);
        System.out.println(ans);

    }

    private static int binarySearch(int[] arr, int target) {
        if (target > arr[arr.length-1]) {
            return -1;
        }
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            System.out.println("low:"+arr[low]);
            System.out.println("middle:"+arr[middle]);
            System.out.println("high:"+arr[high]);
            System.out.println("-----------------------");
            if(target>arr[middle])
                low=middle+1;
            else if(target<arr[middle])
                high=middle-1;
            else
                return middle;
        }
        return low;

    }


}
