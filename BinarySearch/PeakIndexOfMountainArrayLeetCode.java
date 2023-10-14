package BinarySearch;

public class PeakIndexOfMountainArrayLeetCode {
    //finding peak of array aslında 1,2,3,4,5,7(peak),6,3,2
    public static void main(String[] args) {
        int[] arr ={0,10,5,2};
        int ans=peakIndexInMountainArray(arr);
        System.out.println(ans);


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

}
