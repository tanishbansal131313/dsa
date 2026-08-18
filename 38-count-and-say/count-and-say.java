class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int i = 1; i < n; i++) {

            StringBuilder next = new StringBuilder();

            int j = 0;

            while (j < result.length()) {

                char digit = result.charAt(j);
                int count = 0;

                // Count consecutive same digits
                while (j < result.length() &&
                       result.charAt(j) == digit) {

                    count++;
                    j++;
                }

                // Add count + digit
                next.append(count);
                next.append(digit);
            }

            result = next.toString();
        }

        return result;
    }
}