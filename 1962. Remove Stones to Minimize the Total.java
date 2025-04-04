import java.util.*;

public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int pile : piles) maxHeap.add(pile);
        while (k-- > 0) {
            int top = maxHeap.poll();
            maxHeap.add(top - top / 2);
        }
        int sum = 0;
        for (int pile : maxHeap) sum += pile;
        return sum;
    }
}
