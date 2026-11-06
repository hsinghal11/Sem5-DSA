class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a,b) -> Integer.compare(a[0], b[0]));


        int si = 0;
        int ei = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[queries.length];
        for (int i = 0; i < q.length; i++) {
            int start = q[i][0]-x;
            int end = q[i][0];

            while (si < logs.length && logs[si][1] < start){
                if(map.containsKey(logs[si][0])) {
                    map.put(logs[si][0], map.get(logs[si][0]) - 1);
                    if(map.get(logs[si][0]) == 0) map.remove(logs[si][0]);
                }
                si++;
            }

            while (ei < logs.length && logs[ei][1] <= end){
                if(logs[ei][1] >= start && logs[ei][1] <= end){
                    map.put(logs[ei][0], map.getOrDefault(logs[ei][0], 0) +1);
                }
                ei++;
            }

            ans[q[i][1]] = n-map.size();
        }
        return ans;
    }
}