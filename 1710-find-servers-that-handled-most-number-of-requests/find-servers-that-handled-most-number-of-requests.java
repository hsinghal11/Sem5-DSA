class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> ans = new ArrayList<>();

        int[] freq = new int[k];
        int maxFreq = 0;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int n = arrival.length;

        for (int i = 0; i < n; i++) {

            while (!pq.isEmpty() && pq.peek()[1] <= arrival[i]) {
                int[] res = pq.poll();
                set.add(res[0]);
            }

            if (set.isEmpty()) continue;

            // First k requests
            int server;

            if (i < k) {
                server = i;
                set.remove(server);
            } 

            else {
                // Normal assignment logic
                Integer next = set.ceiling(i % k);

                if (next == null) {
                    server = set.first();
                } else {
                    server = next;
                }

                set.remove(server);
            }

            freq[server]++;
            maxFreq = Math.max(maxFreq, freq[server]);

            pq.offer(new int[]{server,arrival[i] + load[i]});
        }

        for (int i = 0; i < k; i++) {
            if (freq[i] == maxFreq) ans.add(i);
        }

        return ans;
    }
}