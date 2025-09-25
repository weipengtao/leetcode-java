package problem2197;

import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int num : nums) {
            while (!queue.isEmpty() && gcd(queue.getLast(), num) > 1) {
                num = lcm(queue.removeLast(), num);
            }
            queue.addLast(num);
        }

        return new ArrayList<>(queue);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
