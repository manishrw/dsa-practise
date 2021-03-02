package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UnionFind<T> {
    private final Map<T, T> parentMap;
    private final Map<T, Integer> heightMap;

    public UnionFind() {
        parentMap = new HashMap<>();
        heightMap = new HashMap<>();
    }

    public void union (T a, T b) {
        Optional<T> optionalA = find(a);
        Optional<T> optionalB = find(b);
        if (optionalA.isEmpty() && optionalB.isEmpty()) {
            parentMap.put(b, a);
            parentMap.put(a, a);
            heightMap.put(b, 0);
            heightMap.put(a, 1);
        } else if (optionalA.isEmpty()) {
            parentMap.put(a, b);
            heightMap.put(a, 0);
        } else if (optionalB.isEmpty()) {
            parentMap.put(b, a);
            heightMap.put(b, 0);
        } else if (!optionalA.equals(optionalB)) {
            T rootA = optionalA.get();
            T rootB = optionalB.get();
            int heightA = heightMap.get(rootA);
            int heightB = heightMap.get(rootB);
            if (heightA < heightB) {
                parentMap.put(rootA, rootB);
            } else {
                parentMap.put(rootB, rootA);
                if (heightA == heightB) heightMap.put(rootA, heightA + 1);
            }
        }
    }

    public Optional<T> find (T a) {
        if (!parentMap.containsKey(a)) return Optional.empty();
        T cur = a;
        while (!cur.equals(parentMap.get(cur)))
            cur = parentMap.get(cur);
        return Optional.of(cur);
    }

    public Integer size () {
        Set<T> set = new HashSet<>();
        for (var e : parentMap.entrySet()) {
            var node = e.getKey();
            var parent = e.getValue();
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