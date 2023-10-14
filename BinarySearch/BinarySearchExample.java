    package BinarySearch;

    public class BinarySearchExample {
        public static void main(String[] args) {
            int[] arr={0,1,2,3,4,5,6,7,8,9};
            int target=8;
            int ans=binarySearch(arr,target);
            System.out.println(ans);
        }

        private static int binarySearch(int[] arr, int target) {
            int low=0;
            int high=arr.length-1; //sıralandığı için ensondaki eleman en büyük olacak mantiken
            while(low<=high){
                //int middle=(low+high)/2; int range'yi geçebilir aşağıdaki kod da aynı anlama geliyor zaten.
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
    }
