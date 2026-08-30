import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to handle duplicates and enable pruning
        Arrays.sort(candidates);
        
        // 2. Start the backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining, int start) {
        // Base Case: If remaining target is 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: Since the array is sorted, if the current element 
            // is greater than the remaining target, all subsequent items will be too
            if (candidates[i] > remaining) {
                break; 
            }
            
            // Skip duplicates: Avoid picking the same number for the same position 
            // in the combination path if it has already been explored
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Include the current candidate
            current.add(candidates[i]);
            
            // Move to the next index (i + 1) because each number can only be used once
            backtrack(result, current, candidates, remaining - candidates[i], i + 1);
            
            // Backtrack: Remove the last added element before trying the next branch
            current.remove(current.size() - 1);
        }
    }
}
