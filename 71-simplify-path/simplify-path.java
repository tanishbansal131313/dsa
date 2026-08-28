class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Empty part or current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal directory
            else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // Root directory
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}