import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // An IP address requires between 4 and 12 digits
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> currentSegments, List<String> result) {
        // If we have found 4 segments and consumed the entire string, it's a valid IP
        if (currentSegments.size() == 4) {
            if (startIndex == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }

        // Try extracting segments of length 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            if (startIndex + len > s.length()) {
                break;
            }

            String segment = s.substring(startIndex, startIndex + len);

            // Check for leading zero or value out of bounds (> 255)
            if ((segment.startsWith("0") && segment.length() > 1) || (len == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }

            // Choose
            currentSegments.add(segment);
            // Explore next segments
            backtrack(s, startIndex + len, currentSegments, result);
            // Backtrack (unchoose)
            currentSegments.remove(currentSegments.size() - 1);
        }
    }
}
