class Solution {
    public int divide(int dividend, int divisor) {

        // Determine the sign of the answer
        boolean negative = (dividend < 0) != (divisor < 0);

        // Use long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double the divisor while it still fits
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        // Apply sign
        if (negative) {
            result = -result;
        }

        // Handle overflow case
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}