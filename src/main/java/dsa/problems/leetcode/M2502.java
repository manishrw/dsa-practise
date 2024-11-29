/**
 * Leetcode Medium: 2502 - Design Memory allocator.
 * Url: https://leetcode.com/problems/design-memory-allocator/
 */
package dsa.problems.leetcode;

import java.util.*;

public class M2502 {
    private final TreeMap<Integer, TreeSet<MemoryRange>> freeMap;
    private final Map<Integer, TreeSet<MemoryRange>> memMap;

    public M2502(int n) {
        this.memMap = new HashMap<>();
        this.freeMap = new TreeMap<>();
        this.freeMap.put(n, new TreeSet<>());
        this.freeMap.get(n).add(new MemoryRange(0, n - 1));
    }

    static class MemoryRange implements Comparable<MemoryRange> {
        int start;
        int end;

        public MemoryRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MemoryRange o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public int allocate(int size, int mID) {
        Integer availableSize = this.freeMap.ceilingKey(size);
        if (availableSize == null) return -1;
        if (availableSize == size) {
            // Find the free memory block
            Integer idx = findFreeMemoryIdx(availableSize);
            if (idx == null) return -1;

            // Allocate memory
            allocateMemory(size, mID, idx);
            return idx;
        } else if (availableSize > size ){
            int sizeDiff = availableSize - size;
            Integer idx = findFreeMemoryIdx(availableSize);
            if (idx == null) return -1;

            // Allocate memory
            allocateMemory(size, mID, idx);

            // Update free memory
            this.freeMap.computeIfAbsent(sizeDiff, k -> new TreeSet<>()).add(new MemoryRange(idx + size, idx + availableSize - 1));
            return idx;
        }
        return -1;
    }

    private Integer findFreeMemoryIdx(int size) {
        var set = this.freeMap.get(size);
        var range = set.pollFirst();
        if (set.isEmpty()) {
            this.freeMap.remove(size);
        }
        if (range == null) return null;
        return range.start;
    }

    private void allocateMemory(int size, int mID, int idx) {
        MemoryRange allocatedMemory = new MemoryRange(idx, idx + size - 1);
        this.memMap.computeIfAbsent(mID, k -> new TreeSet<>()).add(allocatedMemory);
    }

    public int freeMemory(int mID) {
        TreeSet<MemoryRange> allocatedMemories = this.memMap.get(mID);
        if (allocatedMemories == null) return 0;
        int freed = 0;
        for (MemoryRange allocatedMemory : allocatedMemories) {
            int size = allocatedMemory.end - allocatedMemory.start + 1;
            this.freeMap.computeIfAbsent(size, k -> new TreeSet<>()).add(allocatedMemory);
            freed += size;
        }
        this.memMap.remove(mID);

        // Merge free memories
        var freeMemoryRanges = new TreeSet<MemoryRange>();
        for (TreeSet<MemoryRange> set : this.freeMap.values()) {
            freeMemoryRanges.addAll(set);
        }
        mergeAllocatedMemories(freeMemoryRanges);
        this.freeMap.clear();
        for (MemoryRange freeMemoryRange : freeMemoryRanges) {
            this.freeMap.computeIfAbsent(freeMemoryRange.end - freeMemoryRange.start + 1, k -> new TreeSet<>()).add(freeMemoryRange);
        }

        return freed;
    }

    private void mergeAllocatedMemories(TreeSet<MemoryRange> allocatedMemories) {
        List<MemoryRange> mergedMemories = new ArrayList<>();
        MemoryRange prev = null;
        for (MemoryRange allocatedMemory : allocatedMemories) {
            if (prev == null) {
                prev = allocatedMemory;
                continue;
            }
            if (prev.end + 1 == allocatedMemory.start) {
                prev.end = allocatedMemory.end;
            } else {
                mergedMemories.add(prev);
                prev = allocatedMemory;
            }
        }
        mergedMemories.add(prev);
        allocatedMemories.clear();
        allocatedMemories.addAll(mergedMemories);
    }

    @Override
    public String toString() {
        return "Allocator{" +
                " freeMap=" + freeMap +
                ", memMap=" + memMap +
                " }";
    }
}
