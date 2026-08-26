class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean digitAfterE = true;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                digitSeen = true;

                if (eSeen) {
                    digitAfterE = true;
                }
            }

            // Decimal point
            else if (c == '.') {

                // Decimal cannot appear after e
                // and cannot appear twice
                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {

                // Exponent needs a number before it
                // and cannot appear twice
                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;

                // We haven't seen a digit after e yet
                digitAfterE = false;
            }

            // Sign
            else if (c == '+' || c == '-') {

                // Sign is only allowed at the beginning
                // or immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // Anything else is invalid
            else {
                return false;
            }
        }

        return digitSeen && digitAfterE;
    }
}