import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        // Split the path by slashes to isolate individual components
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : components) {
            // Skip empty components (from "//") or current directory references (".")
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            
            // If parent directory "..", pop from stack if it's not empty
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // It's a valid directory or file name (e.g., "home", "...")
                stack.push(dir);
            }
        }

        // Reconstruct the simplified canonical path
        StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.append("/").append(dir);
        }

        // If the stack was empty, return "/", otherwise return the built path
        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }
}
