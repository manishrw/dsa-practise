package dsa.utils;

public class ArrayUtils {
    public static int[] CountingSort(int[] arr) {
        int n = arr.length;
        int max = n - 1;

        int[] count = new int[max + 1];
        for (int i : arr) {
            count[i]++;
        }

        int[] sorted = new int[n];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[index++] = i;
            }
        }

        return sorted;
    }
}
