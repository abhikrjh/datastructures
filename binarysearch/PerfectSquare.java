package binarysearch;

public class PerfectSquare {

    public static boolean isPerfectSquare(int num) {

        if (num ==  1) return true;

        int start = 1;
        int end = num/2;

        while(start <= end) {

            int mid = start + (end - start)/2;

            if(mid == num/mid) {
                return true;
            }else if(mid < num/mid) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(isPerfectSquare(num));
    }
}
