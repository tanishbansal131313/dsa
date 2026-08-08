class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Numbers ending in 0 are not palindromes
        // except 0 itself
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {

            int digit = x % 10;

            reversed = reversed * 10 + digit;

            x = x / 10;
        }

        // Even number of digits
        // OR odd number of digits
        return x == reversed || x == reversed / 10;
    }
}