class Solution {

    class Pair {
        int person, time;
        Pair(int p, int t) {
            person = p;
            time = t;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] m : meetings) {
            graph[m[0]].add(new int[]{m[1], m[2]});
            graph[m[1]].add(new int[]{m[0], m[2]});
        }

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.add(new Pair(0, 0));
        pq.add(new Pair(firstPerson, 0));
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.time > earliest[cur.person]) continue;

            for (int[] nbr : graph[cur.person]) {
                int next = nbr[0];
                int meetTime = nbr[1];

                if (meetTime >= cur.time && meetTime < earliest[next]) {
                    earliest[next] = meetTime;
                    pq.add(new Pair(next, meetTime));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) ans.add(i);
        }
        return ans;
    }
}
