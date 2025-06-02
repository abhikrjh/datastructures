package other;
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
        1   (0 0 0 1)
        4   (0 1 0 0)
        ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:

Input: x = 3, y = 1
Output: 1
*/

public class HammingDistance {

    private static int hammingDistance(int x, int y) {

        // Step 1: XOR to find differing bits
        int xor = x ^ y; // 5

        int count = 0;

        // After XOR operation, where ever the value is 1 that places bits are different
        while (xor != 0 ) {

            System.out.println(xor & 1); // check last digit is 1 or not, if its 1 (xor & 1) will return 1 else 0
            count += xor & 1;
            xor >>= 1; // It shifts all the bits 1 place to the right, and discards the rightmost bit shift to check next bit
                        // 0101 => 0010
        }

        return count;
    }

    public static void main(String[] args) {

        int x = 1;
        int y = 4;

        int i = hammingDistance(x, y);

        //System.out.println(i);
    }
}
