package BinarySearch;

public class SmallestLetterLeetCode {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char target='c';
        char ans=nextGreatestLetter(letters,target);
        System.out.println(ans);

    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int low=0;
        int high=letters.length-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(target<letters[middle]){
                high=middle-1;
            }
            else{
                low=middle+1;
            }
            }

        return letters[low % letters.length];
    }
}
