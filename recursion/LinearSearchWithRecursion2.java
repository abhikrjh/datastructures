package recursion;

// find all the indexes which has target elements
// ex arr= [ 3, 2,6,8, 9, 6], o/p - [2,5]

import java.util.ArrayList;
import java.util.List;

public class LinearSearchWithRecursion2 {

    static List<Integer> searchAllIndex(int[] arr, int target) {
        //return helper(arr, target, 0, new ArrayList<>());
        return helper(arr, target, 0);
    }

    private static List<Integer> helper(int[] arr, int target, int index, List<Integer> list) {

        // Base condition or termination condition(both if)

        if (arr.length == 0) {
            return List.of(-1);
        }

        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target)
            list.add(index);

        return helper(arr, target, index + 1, list);
    }

    // Without passing list in argument, instead will create new list inside every function call
    // Not recommended to use , use 1st approach which has list as argument.
    private static List<Integer> helper(int[] arr, int target, int index) {

        List<Integer> list = new ArrayList<>();

        // base condition
        if(index == arr.length){
            return list;
        }

        if(arr[index] ==  target){
           list.add(index);
        }

        List<Integer> listOfIndexes = helper(arr, target, index + 1);

        list.addAll(listOfIndexes);

        return list;
    }



    public static void main(String[] args) {

        int[] arr = {3, 2, 6, 6, 9, 18};
        int target = 6;

        List<Integer> integers = searchAllIndex(arr, target);

        System.out.println(integers);
    }
}
