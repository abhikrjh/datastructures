package arrays;

import java.util.ArrayList;
import java.util.List;

public class SeparateSortedOddEvenList {


    private static void separateList(int[] arr1, int[] arr2) {

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();


        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {

            if (arr1[index1] < arr2[index2]) {

                if (arr1[index1] % 2 == 0) {

                    evenList.add(arr1[index1]);
                } else {

                    oddList.add(arr1[index1]);
                }

                index1++;

            } else {

                if (arr2[index2] % 2 == 0) {

                    evenList.add(arr2[index2]);
                } else {

                    oddList.add(arr2[index2]);
                }

                index2++;
            }
        }

        while (index1 < arr1.length) {

            if (arr1[index1] % 2 == 0) {

                evenList.add(arr1[index1]);
            } else {

                oddList.add(arr1[index1]);
            }

            index1++;

        }

        while (index2 < arr2.length) {

            if (arr2[index2] % 2 == 0) {

                evenList.add(arr2[index2]);
            } else {

                oddList.add(arr2[index2]);
            }

            index2++;
        }

        System.out.println(evenList);
        System.out.println(oddList);
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 8, 12, 15, 21, 42, 49, 99};
        int[] arr2 = {5, 7, 10, 20, 51, 80, 91};

        // 1, 3, 5, 7, ...

        // 8, 10, 12,...


        separateList(arr1, arr2);
    }

}
