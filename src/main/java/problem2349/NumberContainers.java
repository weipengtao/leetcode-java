package problem2349;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {

    private final Map<Integer, Integer> container;

    private final Map<Integer, TreeSet<Integer>> numberMap;

    public NumberContainers() {
        container = new HashMap<>();
        numberMap = new HashMap<>();
    }

    // 讲位置为 index 的数字更改为 number
    public void change(int index, int number) {
        Integer oldNumber = container.get(index);

        if (oldNumber != null) {
            numberMap.get(oldNumber).remove(index);
        }

        container.put(index, number);
        numberMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    // 返回数字 number 最小的位置，如果找不到，返回 -1
    public int find(int number) {
        TreeSet<Integer> treeSet = numberMap.get(number);
        return treeSet == null || treeSet.isEmpty() ? -1 : treeSet.first();
    }
}
