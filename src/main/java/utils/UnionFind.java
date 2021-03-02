package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UnionFind<T> {
    private final Map<T, Pair<T, Integer>> parentMap;

    public UnionFind() {
        this.parentMap = new HashMap<>();
    }

    public void union (T a, T b) {
        Optional<T> optionalA = find(a);
        Optional<T> optionalB = find(b);
        if (optionalA.isEmpty() && optionalB.isEmpty()) {
            parentMap.put(b, new Pair<>(a, 0));
            parentMap.put(a, new Pair<>(a, 1));
        } else if (optionalA.isEmpty()) {
            parentMap.put(a, new Pair<>(b, 0));
        } else if (optionalB.isEmpty()) {
            parentMap.put(b, new Pair<>(a, 0));
        } else if (!optionalA.equals(optionalB)) {
            T rootA = optionalA.get();
            T rootB = optionalB.get();
            int heightA = parentMap.get(rootA).getRight();
            int heightB = parentMap.get(rootB).getRight();
            if (heightA < heightB) {
                parentMap.get(rootA).left(rootB);
            } else {
                parentMap.get(rootB).left(rootA);
                if (heightA == heightB) parentMap.get(rootA).right(heightA + 1);
            }
        }
    }

    public Optional<T> find (T a) {
        if (!parentMap.containsKey(a)) return Optional.empty();
        T cur = a;
        while (!cur.equals(parentMap.get(cur).getLeft()))
            cur = parentMap.get(cur).getLeft();
        return Optional.of(cur);
    }

    public Integer size () {
        Set<T> set = new HashSet<>();
        for (var e : parentMap.entrySet()) {
            var node = e.getKey();
            var parent = e.getValue().getLeft();
            if (node.equals(parent)) {
                set.add(node);
            }
        }
        return set.size();
    }

    public void clear () {
        parentMap.clear();
    }
}