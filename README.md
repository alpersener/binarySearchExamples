**Binary search kullanmak için array’in sorted olması gerekir.Sorted bir array içerisinde arama aralığını her defasında 2 ye bölerek kullanılan bir search algoritmasıdır.O(logn) time complexity’e sahiptir.**

![photo1](https://github.com/alpersener/binarySearchExamples/blob/master/photo1.png)

*   ilk başta mid değeri bulunur eğer target> mid ise sağ tarafa target<mid ise sol tarafa gidilir(ascending olursa yani küçükten büyüğüne doğru öbür türlü tam tersi)

*   mid değeri bulunduktan sonra target sağ tarafta kalıyor mid ve midin solundakilerin hepsi iptal

*   ardından midin sağındakilerden başlayarak yine aynı işlemler yapılır

*   eğer target=mid ise cevap odur

Neden Binary Search?
====================

Middle elementi bulduktan sonra target’e göre sağa ya da sola gidildiğinde otomatik olarak yarısını elemiş oluyoruz bu da işlemleri kolaylaştırıyor yani aslında sırayla n,n/2,n/4… şeklinde gittiği için bu yüzden **O(logn)**
![photo2](https://github.com/alpersener/binarySearchExamples/blob/master/photo2.png)



*   N→Array Size

*   K:Worst case’de en fazla kaç adımda buluyor?

*   Örneğin dizideki eleman sayısı 10 olsa log10 yani log2 tabanında 10 =3,12… vs yani 3 adımda bulmuş olacaktır.

    public class BinarySearchExample {
        public static void main(String[] args) {
            int[] arr={2,4,6,9,11,12,14,20,36,48};
            int target=2;
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

Order Agnostic Binary Search
============================

Binary search kullanırken elemanların ascending ya da descending olarak sıralanmış şekilde olmasını bekleriz.

Ancak elimizde böyle bir bilgi yoksa ascending olarak mı yoksa descending olarak mı sıralanmış olduğunu bilmiyorsak order agnostic binary search kullanmak yararlıdır.

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
