package problem120;

import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = triangle.getLast().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = triangle.size() - 2; i >= 0; i--) {
            var row = triangle.get(i);
            IntStream.range(0, triangle.get(i).size())
                    .forEach(j -> dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j));
        }

        return dp[0];
    }
}
