package strings;

public class ValidPalindrome {
//    A phrase is a palindrome if,
//    after converting all uppercase letters into lowercase letters and
//    removing all non-alphanumeric characters, it reads the same forward and backward.
//    Alphanumeric characters include letters and numbers.

    public boolean checkPalindrome(String input) {
        if (input.length() == 0)
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
        ValidPalindrome v= new ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        System.out.println(v.checkPalindrome(input));
    }


}
