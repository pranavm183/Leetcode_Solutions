import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = coinChange(coins, amount - coin);

            if (result >= 0) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        int finalAns = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        memo.put(amount, finalAns);

        return finalAns;
    }
}
