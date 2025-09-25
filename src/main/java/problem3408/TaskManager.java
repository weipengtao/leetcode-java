package problem3408;

import java.util.*;

public class TaskManager {

    private final Map<Integer, List<Integer>> tasksMap;
    private final Set<List<Integer>> tasksSet;

    public TaskManager(List<List<Integer>> tasks) {
        tasksMap = new TreeMap<>();
        tasksSet = new TreeSet<>((o1, o2) -> {
            Integer taskId1 = o1.get(1);
            Integer taskId2 = o2.get(1);
            Integer priority1 = o1.get(2);
            Integer priority2 = o2.get(2);
            if (Objects.equals(priority1, priority2)) {
                return taskId2 - taskId1;
            }
            return priority2 - priority1;
        });
        tasks.forEach(task -> {
            tasksMap.put(task.get(1), task);
            tasksSet.add(task);
        });
    }

    public void add(int userId, int taskId, int priority) {
        List<Integer> task = Arrays.asList(userId, taskId, priority);
        tasksMap.put(taskId, task);
        tasksSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        List<Integer> task = tasksMap.get(taskId);
        tasksSet.remove(task);
        task.set(2, newPriority);
        tasksSet.add(task);
    }

    public void rmv(int taskId) {
        List<Integer> task = tasksMap.remove(taskId);
        tasksSet.remove(task);
    }

    public int execTop() {
        Iterator<List<Integer>> iterator = tasksSet.iterator();
        if (!iterator.hasNext()) {
            return -1;
        }
        List<Integer> task = iterator.next();
        tasksSet.remove(task);
        tasksMap.remove(task.get(1));
        return task.getFirst();
    }
}