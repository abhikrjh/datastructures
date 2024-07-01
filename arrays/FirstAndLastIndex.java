package arrays;

import java.util.Arrays;

public class FirstAndLastIndex {

    // find the index of first and last occurance of given element

    public void findIndex(int e, int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int a = Arrays.binarySearch(array, e);
        System.out.println(a);

    }

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 7, 2, 10, 8, 6, 4, 7, 3, 7, 2, 1};
        FirstAndLastIndex f = new FirstAndLastIndex();
        f.findIndex(7, array);

    }

}
