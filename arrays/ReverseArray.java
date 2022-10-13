package arrays;

import java.util.Arrays;

public class ReverseArray {
    // Reverse the array
    public int[] reverse1(int[] array) {
        // 1,2,3,4,5,6,7
        int arrayLength = array.length;
        int temp=0;
        for(int i=0; i<arrayLength/2; i++){
            temp = array[i];
            array[i] = array[arrayLength-(i+1)];
            array[arrayLength-(i+1)] = temp;
        }
        return array;
    }

    // Reverse array by creating a new array
    public int[] reverse2(int[] array) {
        int[] newArray = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[index] = array[i];
            index++;
        }
        return newArray;
    }

    public static void main(String[] args) {
        ReverseArray r = new ReverseArray();
        int[] intArray = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(r.reverse1(intArray)));
    }

}
