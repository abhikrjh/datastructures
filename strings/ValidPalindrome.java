package strings;

public class ValidPalindrome {
//    A phrase is a palindrome if,
//    after converting all uppercase letters into lowercase letters and
//    removing all non-alphanumeric characters, it reads the same forward and backward.
//    Alphanumeric characters include letters and numbers.

    private boolean isValidPalindrome(String str) {

        if (null == str || str.isEmpty())
            return false;

        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        System.out.println("Removed all non-alphanumeric characters : " + str);

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {

            if (chars[i] != chars[chars.length - (i + 1)]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPalindrome(String input) {

        if (null == input || input.isEmpty())
            return false;

        String[] trimmedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split("");

        int len = trimmedInput.length;

        for (int i = 0; i < len / 2; i++) {
            if (!(trimmedInput[i].equalsIgnoreCase(trimmedInput[len - (i + 1)]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        System.out.println(v.isValidPalindrome(input));
    }
}
