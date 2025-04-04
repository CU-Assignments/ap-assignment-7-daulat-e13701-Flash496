import java.util.*;

public class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) indexMap.put(target[i], i);
        List<Integer> sequence = new ArrayList<>();
        for (int num : arr) {
            if (indexMap.containsKey(num)) {
                int idx = indexMap.get(num);
                int pos = Collections.binarySearch(sequence, idx);
                if (pos < 0) pos = -(pos + 1);
                if (pos == sequence.size()) sequence.add(idx);
                else sequence.set(pos, idx);
            }
        }
        return target.length - sequence.size();
    }
}
