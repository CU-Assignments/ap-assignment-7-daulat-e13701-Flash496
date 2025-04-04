import java.util.*;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canAssign(mid, tasks, workers, pills, strength)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = workers.length - k;
        for (int j = k - 1; j >= 0; j--) {
            int task = tasks[j];
            while (i < workers.length && workers[i] + strength >= task) deque.add(workers[i++]);
            if (deque.isEmpty()) return false;
            if (deque.peekLast() >= task) deque.pollLast();
            else {
                if (pills == 0) return false;
                pills--;
                deque.pollFirst();
            }
        }
        return true;
    }
}
