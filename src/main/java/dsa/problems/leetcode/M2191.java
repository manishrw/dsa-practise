package dsa.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class M2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] mapResult = new int[nums.length];
        int idx = 0;
        for (int num: nums) {
            int result = this.getMappedValue(num, mapping);
            System.out.printf("%d -> %d%n", num, result);
            mapResult[idx++] = result;
        }

        this.sortArrayByOrder(nums, mapResult);
        return nums;
    }

    private void sortArrayByOrder(int[] arr, int[] order) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            orderMap.put(arr[i], order[i]);
            indexMap.put(arr[i], i);
        }

        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            if (Objects.equals(orderMap.get(a), orderMap.get(b))) {
                return Integer.compare(indexMap.get(a), indexMap.get(b));
            }
            return Integer.compare(orderMap.get(a), orderMap.get(b));
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
    }

    private int getMappedValue(int num, int[] mapping) {
        if (num < 10) return mapping[num];
        int result = 0;
        int base = 1;
        while (num > 0) {
            int val = mapping[num % 10];
            result += (base * val);
            base *= 10;
            num /= 10;
        }
        return result;
    }
}
