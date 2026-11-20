import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> uniqueResults = new HashSet<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), uniqueResults);
        return new ArrayList<>(uniqueResults);
    }

    private void findCombinations(int[] candidates, int target, int currentSum, 
                                  List<Integer> currentList, Set<List<Integer>> uniqueResults) {
      
        if (currentSum == target) {
            List<Integer> validCombo = new ArrayList<>(currentList);
            Collections.sort(validCombo); 
            uniqueResults.add(validCombo);
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            findCombinations(candidates, target, currentSum + candidates[i], currentList, uniqueResults);
            currentList.remove(currentList.size() - 1);
        }
    }
}
