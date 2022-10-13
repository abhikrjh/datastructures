package arrays;

import java.util.Arrays;

public class ContainsDuplicate {

    // Given an integer array nums,
    // return true if any value appears at least twice in the array,
    // and return false if every element is distinct.

    public boolean containsDuplicate(int[] array){
        Arrays.sort(array);
        for(int i=0; i< array.length-1; i++){
            if(array[i] == array[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        int[] array = {1, 2, 3, 4, 5, 7, 8, 4};
        System.out.println(c.containsDuplicate(array));


    }

}
