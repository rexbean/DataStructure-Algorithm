# Dijkstra

| #   | # of Prob | Status     | Note |
| --- | --------- | ---------- | ---- |
| 1   | 743       | To be Done |      |



``` Java
PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
    heap.offer(new int[]{0, K});

    Map<Integer, Integer> dist = new HashMap();

    while (!heap.isEmpty()) {
        int[] info = heap.poll();
        int d = info[0], node = info[1];
        if (dist.containsKey(node)) continue;
        dist.put(node, d);
        if (graph.containsKey(node))
            for (int[] edge: graph.get(node)) {
                int nei = edge[0], d2 = edge[1];
                if (!dist.containsKey(nei))
                    heap.offer(new int[]{d+d2, nei});
            }
    }

    if (dist.size() != N) return -1;
    int ans = 0;
    for (int cand: dist.values())
        ans = Math.max(ans, cand);
    return ans;
}
```
